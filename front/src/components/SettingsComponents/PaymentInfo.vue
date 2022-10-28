<template>
  <div id="payment-info-container">
    <div id="payment-info">
      
      <div style="width: 100%;">
        <h3>
          Payment Info
          <i class="fa-brands fa-cc-visa"></i>
          <i class="fa-brands fa-cc-mastercard"></i>
          <i class="fa-brands fa-cc-discover"></i>
          <i class="fa-brands fa-cc-jcb"></i>
          <i class="fa-brands fa-cc-amex"></i>
        </h3>
        <hr>
      </div>
      <form>
        <div id="row">
            <!-- <i class="fa-solid fa-address-card"></i>
            <div id="col">
              <input id="fullName" type="text" required/>
              <label for="fullName">Full Name</label>
            </div> -->
          </div>

          <div id="row">
            <i class="fa-solid fa-credit-card"></i>
            <div id="col">
              <input id="cardNum" type="text" maxlength="16" required/>
              <label for="cardNum">Card Number</label>
            </div>
            <div id="col">
              <select name='expireMM' id='expireMM'>
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
              <label for="expireMM">Exp. Month</label>
            </div>
            <div id="col">
              <select name='expireYY' id='expireYY'>
                <option value=''>YY</option>
                <option value='23'>2023</option>
                <option value='24'>2024</option>
                <option value='25'>2025</option>
                <option value='26'>2026</option>
                <option value='27'>2027</option>
              </select>
              <label for="expireMM">Exp. Year</label>
            </div>

            <div id="col">
              <input style="width: 100px;" id="ccNum" name="ccNum" type="text" maxlength="3" required/>
              <label for="ccNum">CC Num</label>
            </div>
          </div>

          <!-- Street Row -->
            <div id="row">
                <i class="fa-regular fa-map"></i>
                <div id="col">
                    <input id="billAddress" type="text"/>
                    <label for="billAddress">Billing Address</label>
                </div>

                <div id="col">
                    <input id="billApt" type="text" style="width: 75px;"/>
                    <label for="billApt">Apt Num.</label>
                </div>
            </div>

            <!-- Zip/City/State Row -->
            <div id="row">
                <i class="fa-solid fa-location-dot"></i>
                <div id="col">
                    <input id="billZip" type="text" maxlength="5"/>
                    <label for="billZip">ZIP Code</label>
                </div>

                <div id="col">
                    <input id="billCity" type="text"/>
                    <label for="billCity">City</label>
                </div>

                <div id="col">
                    <select id="billState">
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
                    <label for="billState">State</label>
                </div>
            </div>
      </form>
        <div id="row">
          <button @click="saveCard()">Save Card</button>
          <button style="margin: 0 10px;" @click="getCards()">See Cards</button>
        </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PaymentInfo',
  methods: {
    async saveCard() {
      let cardNum = document.querySelector("#cardNum").value
      let expirationMonth = document.querySelector("#expireMM").value
      let expirationYear = document.querySelector("#expireYY").value
      let street = document.querySelector("#billAddress").value
      let apt = document.querySelector("#billApt").value
      let zip = document.querySelector("#billZip").value
      let city = document.querySelector("#billCity").value
      let state = document.querySelector("#billState").value

      let cardPayload = {
        "userID" : this.$store.state.id,
        "cardNumber" : cardNum,
        "cardExpiry" : expirationMonth + "/" + expirationYear,
        "billingAddress" : {
          "street" : street,
          "apt" : apt,
          "city" : city,
          "state" : state,
          "zipcode" : zip
        }
      }

      await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.id + "/addpayment", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cardPayload)
      })
      .then((res) => res.json())
      .then((result) => {console.log("success:" + result);})
      .catch((err) => {console.log("Err: " + err);})
    },
    async getCards() {
      await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.id + "/getpaymentCards", {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
      })
      .then((res) => res.json())
      .then((result) => {
        let primaryCard = JSON.stringify(result[0])
        for (let i = 0; i < result.length; i++) {
          this.showCard(JSON.stringify(result[i]))
        }
        // {"cardID":2,"userID":40,"cardNumber":"1234849234134218","cardExpiry":"04/25","billingAddress":{"street":"1968 Lakeview Bend Way","apt":"","city":"Buford","state":"GA","zipcode":"30519"}}
        console.log(primaryCard);
        document.querySelector("#cardNum").placeholder = JSON.parse(primaryCard).cardNumber
        // document.querySelector("#expireMM").placeholder = JSON.parse(primaryCard)["cardExpiry"].splice(0,1)
        // document.querySelector("#expireYY").value = JSON.parse(primaryCard)["cardExpiry"].splice(3,4)
        document.querySelector("#billAddress").placeholder = JSON.parse(primaryCard)["billingAddress"]["street"]
        document.querySelector("#billApt").placeholder = JSON.parse(primaryCard)["billingAddress"]["apt"]
        document.querySelector("#billZip").placeholder = JSON.parse(primaryCard)["billingAddress"]["zipcode"]
        document.querySelector("#billCity").placeholder = JSON.parse(primaryCard)["billingAddress"]["city"]
        document.querySelector("#billState").value = JSON.parse(primaryCard)["billingAddress"]["state"]
      })
      .catch((err) => {console.log("Err: No Cards: " + err);})
    },
    showCard(card) {
      alert(card)
    }
    
  }
}
</script>

<style scoped>
  #payment-info-container {
    display: none;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
    text-align: left;
  }

  #payment-info {
    padding: 25px;
    display: flex;
    flex-direction: column;
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

    h3 {
        margin-top: 25px;
    }

    hr {
        margin: 0;
    }

    i {
        font-size: 25px;
        margin: 0 10px;
        height: 20px;
        width: 20px;
    }

    label {
        font-size: 20px;
        padding-right: 10px;
        color: #FBFFF1;
    }

    input {
        width: 200px;
        height: 50px;
        background-color: transparent;
        font-size: 15px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: #FBFFF1;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 4px #FBFFF1;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
    }

    button {
        padding: 5px;
        margin: 10px 0;
        width: 175px;
        text-decoration: none;
        font-size: 20px;
        text-align: center;
        color: #FBFFF1;
        background-color: transparent;
        border: solid 2px #FBFFF1;
        border-radius: 20px;
        transition: opacity 0.2s ease-in-out;
    }

    button:hover {
        opacity: 0.6;
    }

    select {
        width: 100px;
        height: 50px;
        color: #FBFFF1;
        background-color: transparent;
        border: none;
        border-bottom: solid 4px #FBFFF1;
    }
</style>