<template>
  <div id="confirmpage-container">
    <h3>Order Confirmation</h3>
    <span>Confirmation Number: 482956748</span>
    <div>
      <h2>Payment Info</h2>
      <span> CC: ending in 4331</span>
      <span>Full Name: Lorem Ipsum</span>
      <span>Email: lorem@ipsum.com</span>
      <span>Address: 104 Caldwell Hall, Athens, GA, 30602</span>
    </div>

    <div>
      <h2>Order Info</h2>
      <span>Tickets: Adult . . . x3</span>
      <span>Total: $36.77</span>
      <h2>To modify your order, access account settings.</h2>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
  #confirmpage-container {
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }

  span {
    display: block;
  }
</style>