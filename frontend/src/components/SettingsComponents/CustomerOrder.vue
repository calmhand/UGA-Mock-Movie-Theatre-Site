<template>
  <div id="customer-order-container">
    <div id="row">
         <div id="col">
            <h4>{{orderID}}</h4>
            <label>Order ID</label>
        </div>
        <div id="col">
            <h4>{{orderDate}}</h4>
            <label>Date of Purchase</label>
        </div>
    </div>
    <hr>
    <div id="row">
        <div id="col">
            <h5 style="font-size: 20px; color: #B4C5E4;">{{movieName}}</h5>
            <label>Movie</label>
        </div>
        <div id="col">
            <h4>{{bookedShow.showRoom}}</h4>
            <label>Theatre</label>
        </div>
        <div id="col">
            <h4>{{bookedSeats.toString()}}</h4>
            <label>Seats</label>
        </div>
        <div id="col">
            <h4>{{bookedShow.showDate}}</h4>
            <label>Date</label>
        </div>
        <div id="col">
            <h4>{{bookedShow.showTimeSlot}}</h4>
            <label>Time</label>
        </div>
    </div>
    <hr>
    <div id="row">
        <div id="col">
            <h4>${{Number(paymentInfo.transactionAmount).toFixed(2)}}</h4>
            <label>Total Due</label>
        </div>
        <div id="col" v-if="!(promotion === '')">
            <h4>{{promotion.promocode}}</h4>
            <label>Promotion</label>
        </div>
        <div id="col">
            <h4>{{paymentInfo.transactionDetails.cardNumber}}</h4>
            <label>Card</label>
        </div>
        <div id="col">
            <h4 style="font-size: 15px;">{{paymentInfo.billingAddress.street}}</h4>
            <label>Billing Address</label>
        </div>
        <div id="col" v-if="!(paymentInfo.billingAddress.apt.length == 0)">
            <h4>{{paymentInfo.billingAddress.apt}}</h4>
            <label>Apt</label>
        </div>
        <div id="col">
            <h4>{{paymentInfo.billingAddress.city}}</h4>
            <label>City</label>
        </div>
        <div id="col">
            <h4>{{paymentInfo.billingAddress.state}}</h4>
            <label>State</label>
        </div>
        <div id="col">
            <h4>{{paymentInfo.billingAddress.zipcode}}</h4>
            <label>Zip Code</label>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "CustomerOrder",
    props: ['orderID', 'orderDate', 'movieName', 'bookedShow', 'bookedSeats', 'paymentInfo', 'promotion',],

}
</script>

<style scoped>
    #customer-order-container {
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        border-bottom: solid 2px #FBFFF1;
        padding: 25px;
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