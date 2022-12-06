<template>
    <div id="ticketing-container">
        <div id="ticket-background">
            <h5 style="font-size: 2em;"><strong><i style="margin: 0 10px;" class="fa-solid fa-ticket"></i>Select Tickets<i style="margin: 0 10px;" class="fa-solid fa-ticket"></i></strong></h5>
            <hr>
            <div id="row">
                <form id="ticketing-form">
                    <div id="row">
                        <div id="col">
                            <h4><strong>Child</strong></h4>
                            <h5>${{this.$store.state.checkout.childPrice}}</h5>
                            <input id="select-amount-child" type="number" min="0" max="40" placeholder="0">
                            <label>Ticket(s)</label>
                        </div>

                        <div id="col">
                            <h4><strong>Adult</strong></h4>
                            <h5>${{this.$store.state.checkout.adultPrice}}</h5>
                            <input id="select-amount-adult" type="number" min="0" max="40" placeholder="0">
                            <label>Ticket(s)</label>
                        </div>

                        <div id="col">
                            <h4><strong>Senior</strong></h4>
                            <h5>${{this.$store.state.checkout.seniorPrice}}</h5>
                            <input id="select-amount-senior" type="number" min="0" max="40" placeholder="0">
                            <label>Ticket(s)</label>
                        </div>
                    </div>
                </form>
            </div>
            <div id="row">
                <button @click="beginSeating()">
                    Proceed to seating
                </button>
            </div>
        </div>
    </div>
    <AlertModal :id="`alert-tickets-modal`" :errorTitle="`Ticket Error`" :message="ticketError"/>
    <button id="alert-tickets-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-tickets-modal"></button>
</template>

<script>
import AlertModal from '@/components/AlertModal.vue'

export default {
    name: "SelectTickets",
    components: {AlertModal},
    props: {
        showId : String,
    },
    data() {
        return {
            ticketData : {},
            ticketError : ""
        }
    },
    methods: {
        beginSeating() {
            let childAmount = Number(document.querySelector("#select-amount-child").value)
            let adultAmount = Number(document.querySelector("#select-amount-adult").value)
            let seniorAmount = Number(document.querySelector("#select-amount-senior").value)

            if (this.verifyTickets(childAmount, adultAmount, seniorAmount)) {
                let tickets = {
                    "child" : childAmount,
                    "adult" : adultAmount,
                    "senior" : seniorAmount
                }
                this.ticketData = tickets
                this.$router.push({path: "/checkout/" + this.showId + "/seating"})
            }

        },
        verifyTickets(kid, adult, old) {
            if ((kid + adult + old) == 0) {
                this.ticketError = "No tickets are selected."
                document.querySelector("#alert-tickets-btn").click()
                return false
            } else if ((kid + adult + old) > 40) {
                this.ticketError = "Too many tickets were selected!"
                document.querySelector("#alert-tickets-btn").click()
                return false
            } else {
                this.$store.state.checkout.adultTickets = adult
                this.$store.state.checkout.childTickets = kid
                this.$store.state.checkout.seniorTickets = old
                this.$store.state.checkout.totalTickets = kid + adult + old
                return true
            }
        }
    },
    mounted() {
        if (this.$store.state.site.currentState == 0) {
            document.querySelector("#alert-site-state-btn").click()
            this.$router.push({path: "/login"})
        }
    }
}
</script>

<style scoped>
    #ticketing-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        padding: 50px;
        min-height: 100vh;
        color: #FBFFF1;
    }

    #ticket-background {
        background-color: rgba(0, 0, 0, 0.5); 
        border-radius: 10px;
        margin: 0 10px;
        align-items: center;
        justify-content: center;
        display: flex;
        flex-direction: column;
        padding: 50px;
    }

    #row {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 5vw;
    }

    h4 {
        width: 5vw;
    }

    label {
        font-size: 17px;
    }

    input {
        height: 50px;
        width: 5vw;
        background-color: transparent;
        font-size: 15px;
        border: none;
        text-align: center;
        color: #FBFFF1;
        border-bottom: solid 2px #FBFFF1;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 2px #FBFFF1;
    }

    input::placeholder {
        color: #FBFFF1;
    }

    button {
        border: solid #3C3744 10px;
        border-radius: 20px;
        background-color: #3C3744;
        color: #FBFFF1;
        margin: 20px 10px;
        transition: opacity 0.3s ease-in-out;
    }

    button:hover {
        opacity: 0.7;
    }
</style>