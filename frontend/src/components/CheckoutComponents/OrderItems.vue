<template>
  <div id="order-container">
    <h2 style="text-align: left; border-bottom: solid 2px #fbfff19b;"><strong>Order Summary</strong></h2>

    <div id="row">
        <div id="col">
            <div id="col">
                <h5><strong>Movie</strong></h5>
                <span>{{this.$store.state.checkout.movieTitle}}</span>
            </div>
        </div>

        <div id="col">
            <h5><strong>Date and Showtime</strong></h5>
            <span>{{this.$store.state.checkout.showDate}} @ {{this.$store.state.checkout.timeSlot}}</span>
        </div>
    </div>

    <div id="row">
        <div id="col">
            <h5><strong>Seats</strong></h5>
            <span>{{this.$store.state.checkout.seats.toString()}}</span>
        </div>

        <div id="col">
            <h5><strong>Theatre</strong></h5>
            <span>{{this.$store.state.checkout.theatre}}</span>
        </div>
    </div>

    <div id="row">
        <div id="col">
            <h5><strong>Tickets</strong></h5>
            <span>Child . . . x{{this.$store.state.checkout.childTickets}}</span>
            <span>Adult . . . x{{this.$store.state.checkout.adultTickets}}</span>
            <span>Senior . . . x{{this.$store.state.checkout.seniorTickets}}</span>
        </div>
    </div>

    <div id="row">
        <div id="col">
            <input id="checkoutPromoInput" autocomplete="off">
            <label for="checkoutPromoInput">Promo Code</label>
            <small v-if="promoApplied">Enjoy {{promoAmount}}% off!</small>
        </div>

        <div id="col">
            <div id="col" style="margin: 0;" v-if="promoApplied"><i class="fa-solid fa-circle-check"></i></div>
            <div id="col" style="margin: 0;" v-else ><i @click="checkPromo()" id="check-promo-btn" class="fa-solid fa-arrow-left"></i></div>
        </div>
    </div>

    <div id="row">
        <div id="col">
            <h5><strong>Order Total</strong></h5>
            <span>Ticket Sum: ${{Number(this.$store.state.checkout.totalWithoutTax).toFixed(2)}}</span>
            <span>Tax: {{Number(this.$store.state.checkout.taxPrice).toFixed(2)}}%</span>
            <span>Order Total: ${{Number(this.$store.state.checkout.total).toFixed(2)}}</span>
        </div>
    </div>

    <div id="row">
        <button @click="executePayment()">Purchase</button>
        <button @click="cancelProcess()">Cancel</button>
    </div>
  </div>
</template>

<script>
export default {
    name: "OrderItems",
    props: {
        showId : String
    },
    data() {
        return {
            promoApplied : false,
            promoAmount : 0
        }
    },
    methods: {
        executePayment() {
            let orderCard = document.querySelector("#checkoutCardNum").value
            let orderCC = document.querySelector("#ccNumCheckout").value
            let orderMonth = document.querySelector("#checkoutExpireMM").value
            let orderYear = document.querySelector("#checkoutExpireYY").value
            let orderAddress = document.querySelector("#checkoutAddress").value
            let orderApt = document.querySelector("#checkoutApt").value
            let orderCity = document.querySelector("#checkoutCity").value
            let orderZip = document.querySelector("#checkoutZip").value
            let orderState = document.querySelector("#checkoutState").value
            let checkoutPromo = ""
            if (this.promoApplied) checkoutPromo = document.querySelector("#checkoutPromoInput").value

            let checkoutPayload = {
                "userID" : this.$store.state.site.id,
                "movieID" : this.$store.state.checkout.movieId,
                "showID" : parseInt(this.showId),
                "tickets" : {
                    "child" : this.$store.state.checkout.childTickets,
                    "adult" : this.$store.state.checkout.adultTickets,
                    "senior" : this.$store.state.checkout.seniorTickets
                },
                "bookedSeats" : this.$store.state.checkout.seats,
                "promoCode" : checkoutPromo,
                "total" : this.$store.state.checkout.total,
                "payment" : {
                    "cardNumber" : orderCard,
                    "cc" : orderCC,
                    "cardExpiry" : orderMonth + "/" + orderYear,
                    "billingAddress" : {
                        "street" : orderAddress,
                        "apt" : orderApt,
                        "city" : orderCity,
                        "zipcode" : orderZip,
                        "state" : orderState,
                    }
                },
            }

            const submitPayment = async () => {
                await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/confirmbooking", {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(checkoutPayload)
                })
                .then((res) => res.json())
                .then((s) => {
                    console.log("checkout success" + JSON.stringify(s));
                    this.$store.commit("checkout/SET_CONFIRMED_ORDER_OBJ", s)
                    this.$router.push({path: "/checkout/" + this.showId +"/order-confirmed"})
                })
                .catch((err) => {console.log("Err: " + err);})
            }

            let orderInputs = [orderCard, orderMonth, orderYear, orderAddress, orderCity, orderZip, orderState, orderCC]
            if (this.isEmpty(orderInputs)) {
                submitPayment()
            } else {
                this.$emit("missingInputs")
            }
        },
        checkPromo() {
            let checkoutPromo = document.querySelector("#checkoutPromoInput").value

            const verifyPromo = async () => {
                await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/promotion-details/" + checkoutPromo, {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    if (s.process == "success") {
                        this.$emit("promoSuccess")
                        this.promoAmount = s.discount
                        document.querySelector("#checkoutPromoInput").disabled = true
                        document.querySelector("#check-promo-btn").style.display = "none"
                        this.promoApplied = true
                    } else {
                        this.$emit("promoFail")
                    }
                    console.log(s);
                })
            }
            if (!(checkoutPromo.length == 0)) {
                verifyPromo()
            }
        },
        isEmpty(vals) {
            for (let i = 0; i < vals.length; i++) {
                if (vals[i].length == 0) {
                    return false
                }
            }
            return true
        },
        cancelProcess() {
            this.$store.commit("checkout/CLEAR_CHECKOUT_STORE")
            this.$router.push({path:"/"})
        }
    },
    mounted() {
        document.querySelector("#checkoutPromoInput").disabled = false
        document.querySelector("#check-promo-btn").disabled = false
        this.promoApplied = false
    }
}
</script>

<style scoped>
    #order-container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        padding: 20px;
    }

    #row {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        margin: 10px 0;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 15px;
    }

    h5 {
        color: #FBFFF1;
        border-bottom: solid 2px #FBFFF1;
    }

    span {
        display: block;
    }

    label {
        font-size: 17px;
        padding-right: 10px;
        text-align: left;
    }

    i {
        font-size: 20px;
        height: 20px;
        width: 10px;
        cursor: pointer;
    }

    input {
        height: 50px;
        background-color: transparent;
        font-size: 15px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: white;
        text-align: center;
        transition: border-color 0.2s ease-in-out;
    }

    button {
        border: solid #3C3744 10px;
        border-radius: 20px;
        background-color: #3C3744;
        color: #FBFFF1;
        margin: 0px 10px;
        transition: opacity 0.3s ease-in-out;
    }

    button:hover {
        opacity: 0.7;
    }
</style>