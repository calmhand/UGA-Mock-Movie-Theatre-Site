<template>
  <div id="order-summaries-container" >
    <!-- Create a window with an example movie order. -->
    <!-- Showing ticket details and the price of each ticket, and the order total. The user should be able to
    update the order, delete a ticket or to confirm and continue to checkout.  -->
    <h1>Order Summary</h1><br>

    Confirmation Number: 482956748<br>

    Movie: Pearl<br>
    Showtime: 10:00PM<br>

    Full Name: Lorem Ipsum<br>
    Email: lorem@ipsum.com<br>
    Address: 104 Caldwell Hall, Athens, GA, 30602<br>

    CC: ending in 4331<br>

    Ticket Details: Adult . . . x3<br>
    Order total: $36.77<br><br>

    <button>Update Order</button>
    <button>Delete Tickets</button>
    <!-- Link to Checkout page -->
    <!-- <button id="checkout-button">Checkout</button> -->
  </div>
</template>

<script>
export default {
    name: "UserOrders",
    props: ['userId']
}
</script>

<style scoped>
  #order-summaries-container {
    height: 100vh;
  }

  #checkout-button {

  }

  button {
    margin: 0 10px;
  }

</style>