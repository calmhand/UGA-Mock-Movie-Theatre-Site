<template>
<!-- <button @click="updateSeats()">seats from db</button> -->
<h5>Seats Remaining: {{allowedSeats}}</h5><br>

<div id="movie-seating-container">

</div>
<div v-if="ifSoldOut()">Sold Out</div>
<Transition>
    <div style="height: 100px;">
        <div id="reset-proceed-btns" v-if="allowedSeats==0">
            <div>
                <a @click="resetSeats()">Reset</a>
            </div>
            <div>
                <button @click="beginCheckout()">Proceed to checkout</button>
            </div>
        </div>
    </div>
</Transition>
</template>

<script>
export default {
    name: "MovieSeating",
    props: {
        showId : String,
    },
    data() {
        return {
            selectedSeats : [],
            allowedSeats : this.$store.state.checkout.totalTickets,
        }
    },
    methods: {
        beginCheckout() {
            let bookingPayload = {
                "userID" : this.$store.state.site.id,
                "movieID" : this.$store.state.checkout.movieId,
                "showID" : this.showId,
                "tickets" : {
                    "child" : this.$store.state.checkout.childTickets,
                    "adult" : this.$store.state.checkout.adultTickets,
                    "senior" : this.$store.state.checkout.seniorTickets
                },
                "bookedSeats" : this.selectedSeats
            }
            // eslint-disable-next-line
            const sendSeatChart = async () => {
                await fetch("http://127.0.0.1:8084/api/test/"+ this.$store.state.site.id +"/validatebooking", {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(bookingPayload)
                })
                .then((res) => res.json())
                .then((s) => {
                    console.log("testing: "+ JSON.stringify(s));
                    this.$store.commit("checkout/PARSE_PRICE", s)
                })
                .catch((err) => {console.log("Err: " + err);})
            }
            this.$store.state.checkout.seats = this.selectedSeats
            sendSeatChart()
            this.$router.push({path: "/checkout/" + this.showId + "/payment"})
        },
        updateSeats() {
            const getSeating = async () => {
                await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/show-seat-details/" + this.showId, {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    document.getElementById('movie-seating-container').innerHTML = s.seatLayout
                    document.querySelectorAll(".seat").forEach((e) => {
                        e.addEventListener('click', (seat) => {
                            const modifySeating = () => {
                                let index = this.selectedSeats.indexOf(e.getAttribute('id'))
                                if (seat.target.classList.contains("selected")) { // If seat is already selected, remove from array.
                                    e.classList.toggle("selected")
                                    this.allowedSeats++
                                    if (index > -1) this.selectedSeats.splice(index, 1)
                                    console.log("(Deletion)List: " + this.selectedSeats);
                                } else if (!seat.target.classList.contains("seat-sold")) { // seat was never selected, add to array
                                    e.classList.toggle("selected")
                                    this.allowedSeats--
                                    if (index == -1) this.selectedSeats.push(e.getAttribute('id'))
                                    console.log("(Push)List: " + this.selectedSeats);
                                }
                            }

                            if (this.verifyMax()) {
                                modifySeating()
                            }
                        })
                    })
                })
                .catch((err) => {console.log("Err: " + err);})
            }
            getSeating()
        },
        resetSeats() {
            this.selectedSeats = []
            this.allowedSeats = this.$store.state.checkout.totalTickets
            document.querySelectorAll(".seat").forEach((e) => {
                e.classList.remove("selected")
            })
        },
        verifyMax() {
            if (this.selectedSeats.length == this.$store.state.checkout.totalTickets) {
                return false
            } else {
                return true
            }
        },
        ifSoldOut() {
            return document.querySelectorAll('.seat-sold').length == 40
        }
    },
    mounted() {
        this.updateSeats()
    },
    
}
</script>

<style scoped>
    a {
        font-size: 1.1em;
        cursor: pointer;
        color: #FBFFF1;
        margin: 15px 10px;
        animation: fade 2s infinite;
    }

    @keyframes fade {
        100% {
            opacity: 0;
        }

        50% {
            opacity: 1;
        }

        0% {
            opacity: 0;
        }
    }

    #reset-proceed-btns{
        margin-top: 20px;
    }

    .v-enter-active,
    .v-leave-active {
        transition: opacity 0.5s ease;
    }

    .v-enter-from,
    .v-leave-to {
        opacity: 0;
    }

    button {
        border: solid #3C3744 10px;
        border-radius: 20px;
        background-color: #3C3744;
        color: #FBFFF1;
        margin: 10px 10px;
        transition: opacity 0.3s ease-in-out;
    }

    button:hover {
        opacity: 0.7;
    }
</style>

<style>
    #theatre-seats {
        display: flex;
        flex-direction: column;
    }

    .seatRow {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .seat {
        background-color: #FBFFF1;
        height: 46px;
        width: 52px;
        margin: 5px 10px;
        font-size: 50px;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        transition: transform 0.2s ease-in-out;
    }
    
    .seat.selected {
        background-color: #3138fd;
    }

    .seat-sold {
        height: 46px;
        width: 52px;
        margin: 5px 10px;
        font-size: 50px;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        transition: transform 0.2s ease-in-out;
        background-color: #3C3744;
    }

    .seat:nth-of-type(2) {
        margin-right: 18px;
    }

    .seat:nth-last-of-type(2) {
        margin-left: 18px;
    }

    .seat:not(.sold):hover {
        cursor: pointer;
        transform: scale(1.2);
    }

    .showcase .seat:not(.sold):hover {
        cursor: default;
        transform: scale(1);
    }
</style>