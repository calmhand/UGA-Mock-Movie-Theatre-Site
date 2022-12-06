<template>
  <div id="confirm-page">
    <div id="order-info-container">
      <h1><strong>Order Confirmation</strong></h1>
      <div id="row">
        <div id="col">
          <span>{{this.orderID}}</span>
          <label>Confirmation Number</label>
        </div>
      </div><br>

      <h1><strong>Personal Info</strong></h1>
      <div id="row">
        <div id="col">
          <span>{{this.$store.state.users.firstName}} {{this.$store.state.users.lastName}}</span>
          <label>Full Name</label>
        </div>

        <div id="col">
          <span>{{this.$store.state.users.email}}</span>
          <label>Email</label>
        </div>
      </div><br>

      <h1><strong>Movie Details</strong></h1>
      <div id="row">
        <div id="col">
          <span>{{this.$store.state.checkout.movieTitle}}</span>
          <label>Movie</label>
        </div>

        <div id="col">
          <span>{{this.$store.state.checkout.showDate}} @ {{this.$store.state.checkout.timeSlot}}</span>
          <label>Date and Showtime</label>
        </div>

        <div id="col">
          <span>{{this.$store.state.checkout.seats.toString()}}</span>
          <label>Seats</label>
        </div>

        <div id="col">
          <span>{{this.$store.state.checkout.theatre}}</span>
          <label>Theatre</label>
        </div>

        <div id="col">
          <span>
            Child - {{this.$store.state.checkout.childTickets}};
            Adult - {{this.$store.state.checkout.adultTickets}};
            Senior - {{this.$store.state.checkout.seniorTickets}}
          </span>
          <label>Tickets</label>
        </div>
      </div><br>

      <h1><strong>Price</strong></h1>
      <div id="row">
        <div id="col">
          <span>${{Number(total).toFixed(2)}}</span>
          <label>Total</label>
        </div>
      </div><br>
      <h2>To view the details of your order, access your <a id="link-to-account" @click="sendToProfile()">account settings</a>.</h2>
    </div>
  </div>
</template>

<script>
export default {
  name: "OrderConfirmed",
  data() {
    return {
      order : {},
      orderID : 0,
      total : 0,
    }
  },
  methods: {
    sendToProfile() {
      this.$router.push({path:'/user/' + this.$store.state.site.id})
    },
    parseOrder() {
      this.orderID = this.order.bookingID
      this.total = this.order.total
    }
  },
  mounted() {
    if (this.$store.state.site.currentState == 0) {
        document.querySelector("#alert-site-state-btn").click()
        this.$router.push({path: "/login"})
    } else {
      this.order = this.$store.state.checkout.orderConfirm
      this.parseOrder()
    }
  },
  unmounted() {
    this.$store.commit("checkout/CLEAR_CHECKOUT_STORE")
  }
}
</script>

<style scoped>
  #confirm-page {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }

  #order-info-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
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
      margin: 0 15px;
  }

  h2 > #link-to-account {
    text-decoration: underline;
    color: #3088BE;
    cursor: pointer;
    opacity: 1;
    transition: opacity 0.2s ease-in-out;
  }

  #link-to-account:hover {
    opacity: 0.5;
  }

  label {
      font-size: 17px;
      border-top: solid 2px white;
  }
</style>