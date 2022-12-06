<template>
  <div id="order-info-container">
    <div style="width: 100%;">
        <h3>Orders</h3>
        <hr>
    </div>
    <div id="orders-table">
        <div v-if="orders.length == 0">No orders linked this account.</div>
        <CustomerOrder v-for="order in orders" :key="order.bookingID"
            :orderID="order.bookingID"
            :orderDate="order.bookingTime"
            :movieName="order.movie"
            :bookedShow="order.show"
            :bookedSeats="order.bookedSeats"
            :paymentInfo="order.transaction"
            :promotion="order.promotion"
        />
    </div>
  </div>
</template>

<script>
import CustomerOrder from '@/components/SettingsComponents/CustomerOrder.vue'

export default {
    name: "OrderInfo",
    components: {CustomerOrder},
    data() {
        return {
            orders : [],
        }
    },
    methods: {
        getOrders() {
            const fetchOrders = async () => {
                await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/getBookings", {
                    method: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    this.orders = s.bookings
                })
                .catch((err) => {console.log("err: " + err);})
            }
            fetchOrders()
        }
    },
    mounted() {
        this.getOrders()
    }
}
</script>

<style scoped>
    #order-info-container {
        display: none;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        text-align: left;
    }

    #orders-table {
        border: 4px solid #FBFFF1;
        border-radius: 10px;
        height: 100%;
        width: 100%;
        overflow-y: scroll;
    }

    #row {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 15px;
    }
</style>