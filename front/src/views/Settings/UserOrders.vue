<template>
  <div id="order-summaries-container" >
    <!-- Create a window with an example movie order. -->
    <!-- Showing ticket details and the price of each ticket, and the order total. The user should be able to
    update the order, delete a ticket or to confirm and continue to checkout.  -->
    <h1>Order Summary</h1><br>

    Ticket Details:<br>
    Ticket Prices:<br>
    Order total:<br><br>

    <button>Update Order</button>
    <button>Delete Tickets</button>
    <!-- Link to Checkout page -->
    <button id="checkout-button">Checkout</button>
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
    animation: highlight 1s infinite; /* TODO: DELETE AFTER DEMO */
  }

</style>