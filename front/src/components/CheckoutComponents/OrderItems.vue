<template>
  <div id="order-container">
    <div id="orders-content">
        <h2>Order</h2>
        <h5>Movie</h5>
        <span>Pearl</span><br>

        <h5>Showtime</h5>
        <span>10:00PM</span><br>

        <h5>Tickets</h5>
        <span>Child . . . x0</span>
        <span>Adult . . . x3</span>
        <span>Senior . . . x0</span><br>

        <h5>Total</h5>
        <span>Ticket Sum: $34.42</span>
        <span>Tax: $2.35</span>
        <span>Order Total: $36.77</span><br>
        <router-link to="/checkout/order-confirmed"><button form="checkout-form">Order</button></router-link>
        <br>
        <router-link to="/home">Cancel</router-link>
    </div>
  </div>
</template>

<script>
export default {
    name: "OrderItems",
}
</script>

<style scoped>
    #order-container {
        display: flex;
        flex-wrap: wrap;
        align-content: center;
        flex: 50%;
        justify-content: center;
    }

    #orders-content {
        /* background-color: white; */
        padding: 50px;
        width: 40%;
    }

    h5 {
        color: black;
        text-decoration: underline;
    }

    span {
        display: block;
    }

    button {
        width: 100px;
        animation: highlight 1s infinite;
    }
</style>