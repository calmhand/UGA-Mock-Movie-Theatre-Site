<template>
    <div id="payment-form-container">
        <h3 style="text-align: left; border-bottom: solid 2px #fbfff19b;">Confirm Email</h3>
        <small>The email assigned to your account will be used to deliver a order confirmation.</small>
        <div id="row">
            <i class="fa-regular fa-envelope"></i>
            <div id="col">
                <input name="checkoutEmail" id="checkoutEmail" type="email" disabled :placeholder="this.$store.state.users.email"/>
                <label for="checkoutEmail">Email</label>
            </div>
        </div><br>

        <h3 style="text-align: left; border-bottom: solid 2px #fbfff19b;">Payment</h3>
        <div id="row">
            <form>
                <div id="row">
                    <i class="fa-solid fa-user"></i>
                    <div id="col">
                        <input type="text" id="checkoutName">
                        <label for="checkoutName">Full Name</label>
                    </div>
                </div>

                <div id="row">
                    <i class="fa-solid fa-credit-card"></i>
                    <div id="col">
                        <input id="checkoutCardNum" type="text" maxlength="16" required/>
                        <label for="checkoutCardNum">Card Number</label>
                    </div>
                    <div id="col">
                        <select name='checkoutExpireMM' id='checkoutExpireMM'>
                            <option value=''>MM</option>
                            <option value='01'>January</option>
                            <option value='02'>February</option>
                            <option value='03'>March</option>
                            <option value='04'>April</option>
                            <option value='05'>May</option>
                            <option value='06'>June</option>
                            <option value='07'>July</option>
                            <option value='08'>August</option>
                            <option value='09'>September</option>
                            <option value='10'>October</option>
                            <option value='11'>November</option>
                            <option value='12'>December</option>
                        </select>
                        <label for="checkoutExpireMM">Exp. Month</label>
                    </div>
                    <div id="col">
                        <select name='checkoutExpireYY' id='checkoutExpireYY'>
                            <option value=''>YY</option>
                            <option value='23'>2023</option>
                            <option value='24'>2024</option>
                            <option value='25'>2025</option>
                            <option value='26'>2026</option>
                            <option value='27'>2027</option>
                        </select>
                        <label for="checkoutExpireYY">Exp. Year</label>
                    </div>

                    <div id="col">
                        <input style="width: 100px;" id="ccNumCheckout" name="ccNum" type="text" maxlength="3" required/>
                        <label for="ccNumCheckout">CC Num</label>
                    </div>
                </div>

                <!-- Street Row -->
                <div id="row">
                    <i class="fa-regular fa-map"></i>
                    <div id="col">
                        <input id="checkoutAddress" type="text"/>
                        <label for="checkoutAddress">Billing Address</label>
                    </div>

                    <div id="col">
                        <input id="checkoutApt" type="text" style="width: 75px;"/>
                        <label for="checkoutApt">Apt Num.</label>
                    </div>
                </div>

                <!-- Zip/City/State Row -->
                <div id="row">
                    <i class="fa-solid fa-location-dot"></i>
                    <div id="col">
                        <input id="checkoutZip" type="text" maxlength="5"/>
                        <label for="checkoutZip">ZIP Code</label>
                    </div>

                    <div id="col">
                        <input id="checkoutCity" type="text"/>
                        <label for="checkoutCity">City</label>
                    </div>

                    <div id="col">
                        <select id="checkoutState">
                            <option value="" disabled selected>Select your state</option>
                            <option value="AL">AL</option>
                            <option value="AK">AK</option>
                            <option value="AR">AR</option>
                            <option value="AZ">AZ</option>
                            <option value="CA">CA</option>
                            <option value="CO">CO</option>
                            <option value="CT">CT</option>
                            <option value="DC">DC</option>
                            <option value="DE">DE</option>
                            <option value="FL">FL</option>
                            <option value="GA">GA</option>
                            <option value="HI">HI</option>
                            <option value="IA">IA</option>
                            <option value="ID">ID</option>
                            <option value="IL">IL</option>
                            <option value="IN">IN</option>
                            <option value="KS">KS</option>
                            <option value="KY">KY</option>
                            <option value="LA">LA</option>
                            <option value="MA">MA</option>
                            <option value="MD">MD</option>
                            <option value="ME">ME</option>
                            <option value="MI">MI</option>
                            <option value="MN">MN</option>
                            <option value="MO">MO</option>
                            <option value="MS">MS</option>
                            <option value="MT">MT</option>
                            <option value="NC">NC</option>
                            <option value="NE">NE</option>
                            <option value="NH">NH</option>
                            <option value="NJ">NJ</option>
                            <option value="NM">NM</option>
                            <option value="NV">NV</option>
                            <option value="NY">NY</option>
                            <option value="ND">ND</option>
                            <option value="OH">OH</option>
                            <option value="OK">OK</option>
                            <option value="OR">OR</option>
                            <option value="PA">PA</option>
                            <option value="RI">RI</option>
                            <option value="SC">SC</option>
                            <option value="SD">SD</option>
                            <option value="TN">TN</option>
                            <option value="TX">TX</option>
                            <option value="UT">UT</option>
                            <option value="VT">VT</option>
                            <option value="VA">VA</option>
                            <option value="WA">WA</option>
                            <option value="WI">WI</option>
                            <option value="WV">WV</option>
                            <option value="WY">WY</option>
                        </select>
                        <label for="checkoutState">State</label>
                    </div>
                </div>
            </form>
        </div>
        <button @click="populatePrimaryCard()">Use Primary Card</button>
    </div>
</template>

<script>
export default {
    name: "PaymentForm",
    methods: {
        populatePrimaryCard() {
            const fetchPrimaryCard = async () => {
                await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/getpaymentCards", {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    if (s.length == 0) {
                        this.$emit('noCards')
                    } else {
                        this.fillValues(s[0])
                    }
                })
                .catch((err) => {console.log("Err: No Cards: " + err);})
            }
            fetchPrimaryCard()
        },
        fillValues(c) {
            document.querySelector("#checkoutCardNum").value = c.cardNumber
            document.querySelector("#checkoutExpireMM").value = c.cardExpiry.slice(0,2)
            document.querySelector("#checkoutExpireYY").value = c.cardExpiry.slice(3,5)
            document.querySelector("#checkoutAddress").value = c.billingAddress.street
            document.querySelector("#checkoutApt").value = c.billingAddress.apt
            document.querySelector("#checkoutCity").value = c.billingAddress.city
            document.querySelector("#checkoutZip").value = c.billingAddress.zipcode
            document.querySelector("#checkoutState").value = c.billingAddress.state
        }
    }
}
</script>

<style scoped>
    #payment-form-container {
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        align-content: center;
        justify-content: center;
        margin-right: 50px;
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

    label {
        font-size: 17px;
        padding-right: 10px;
        text-align: left;
    }

    input {
        height: 50px;
        background-color: transparent;
        font-size: 15px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: white;
        text-align: center;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 4px #FBFFF1;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
    }

    input::placeholder {
        color: #FBFFF1;
    }

    select {
        width: 150px;
        height: 50px;
        color: #FBFFF1;
        background-color: transparent;
        border: none;
        border-bottom: solid 4px #FBFFF1;
    }

    i {
        font-size: 25px;
        margin: 0 10px;
        height: 20px;
        width: 20px;
    }

    button {
        border: solid #3C3744 10px;
        border-radius: 20px;
        background-color: #3C3744;
        color: #FBFFF1;
        margin: 10px 10px;
        width: 25%;
        transition: opacity 0.3s ease-in-out;
    }

    button:hover {
        opacity: 0.7;
    }
</style>