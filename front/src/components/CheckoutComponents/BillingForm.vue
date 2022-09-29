<template>
    <div id="billing-form-container">
        <div id="form-container">
            <form id="checkout-form">
                <div id="bill-pay-container">

                    <div id="billing-section">
                        <h3>Billing Address</h3>

                        <label for="fname">Full Name</label>
                        <input id="fname" name="fname" type="text" placeholder="Lorem Ipsum">
                        
                        <label for="email">Email</label>
                        <input id="email" name="email" type="text" placeholder="lorem@ipsum.com">

                        <label for="adr">Address</label>
                        <input id="adr" name="address" type="text" placeholder="104 Caldwell Hall">

                        <label for="city">City</label>
                        <input id="city" name="city" type="text" placeholder="Athens">

                        <div style="display: flex;">
                            <div style="flex:50%;">
                                <label for="state">State</label>
                                <input id="state" name="state" type="text" placeholder="GA" style="width: 50px;">
                            </div>

                            <div style="flex:50%;">
                                <label for="zip">Zipcode</label>
                                <input id="zip" name="zip" type="text" placeholder="30602" style="width: 50px;">
                            </div>
                        </div>
                    </div>

                    <div id="payment-section">
                        <h3>Payment</h3>

                        <label for="ccname">Name on Card</label>
                        <input id="ccname" name="ccname" type="text" placeholder="Lorem Ipsum">

                        <label for="ccnum">Card Number</label>
                        <input id="ccnum" name="ccnum" type="text" placeholder="1234-5678-7890-4321">

                        <label for="expmonth">Expiration Month</label>
                        <input id="expmonth" name="expmonth" type="text" placeholder="10">

                        <label for="expyear">Expiration Year</label>
                        <input id="expyear" name="expyear" type="text" placeholder="2025">

                        <label for="cvv">CVV</label>
                        <input id="cvv" name="cvv" type="text" placeholder="302">
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
export default {
    name: "BillingForm",
}
</script>

<style scoped>

    #billing-form-container {
        flex: 50%;
        display: flex;
        flex-wrap: wrap;
        align-content: center;
        justify-content: center;
    }

    #form-container {
        /* background-color: black; */
        padding: 50px;
    }

    #bill-pay-container {
        display: flex;
    }

    #billing-section {
        flex: 50%;
        text-align: left;
        margin: 0 25px;
    }

    #payment-section {
        flex: 50%;
        text-align: left;
        margin: 0 25px;
    }

    #row {
        flex: 50%;
    }

    label {
        display: block;
    }



</style>