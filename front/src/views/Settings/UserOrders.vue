<template>
  <div id="order-summaries-container" >
    <!-- Create a window with an example movie order. -->
    <!-- Showing ticket details and the price of each ticket, and the order total. The user should be able to
    update the order, delete a ticket or to confirm and continue to checkout.  -->
    orders
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
</style>