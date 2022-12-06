<template>
  <div id="checkout-payment-container">
    <PaymentForm @noCards="alertNoCards()"/>
    <OrderItems :showId="showId" @missingInputs="alertMissingInputs()" @promoSuccess="alertPromo(true)" @promoFail="alertPromo(false)"/>
  </div>
  <AlertModal :id="`alert-payment-modal`" :errorTitle="`Checkout Notice`" :message="alertMsg"/>
  <button id="alert-payment-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-payment-modal"></button>
</template>

<script>
import PaymentForm from '@/components/CheckoutComponents/PaymentForm.vue';
import OrderItems from '@/components/CheckoutComponents/OrderItems.vue';
import AlertModal from '@/components/AlertModal.vue'

export default {
  name: 'BillingPayment',
  components: { PaymentForm, OrderItems, AlertModal },
  props: {
    showId : String
  },
  data() {
    return {
      alertMsg : ""
    }
  },
  methods: {
    alertNoCards() {
      this.alertMsg = "Unable to retrieve a primary card. Your account has no saved cards."
      document.querySelector("#alert-payment-btn").click()
    },
    alertMissingInputs() {
      this.alertMsg = "Unable to purchase. Please enter all inputs."
      document.querySelector("#alert-payment-btn").click()
    },
    alertPromo(bool) {
      if (bool) {
        this.alertMsg = "The promotion has been applied."
        document.querySelector("#alert-payment-btn").click()
      } else {
        this.alertMsg = "Invalid promotion. The promotion has not been applied. Try again."
        document.querySelector("#alert-payment-btn").click()
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
    #checkout-payment-container {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        padding: 50px;
    }
</style>