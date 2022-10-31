<template>
  <div id="addr-bill-container">
    <BillingForm/>
    <OrderItems />
  </div>
</template>

<script>
import BillingForm from '@/components/CheckoutComponents/BillingForm.vue';
import OrderItems from '@/components/CheckoutComponents/OrderItems.vue';
export default {
  name: 'AddressBilling',
  components: { BillingForm, OrderItems }
}
</script>

<style scoped>
    #addr-bill-container {
        height: 100vh;
        display: flex;
        flex-direction: row;
    }


</style>