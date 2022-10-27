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
            <i class="fa-solid fa-address-card"></i>
            <div id="col">
              <input id="fullName" type="text" required/>
              <label for="fullName">Full Name</label>
            </div>
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
                <option value='20'>2023</option>
                <option value='21'>2024</option>
                <option value='22'>2025</option>
                <option value='23'>2026</option>
                <option value='24'>2027</option>
              </select>
              <label for="expireMM">Exp. Year</label>
            </div>

            <div id="col">
              <input style="width: 100px;" id="ccNum" name="ccNum" type="text" maxlength="3" required/>
              <label for="ccNum">CC Num</label>
            </div>
          </div>

          <div id="row">

          </div>
          <!-- TODO: Implement saveCard method. -->
        <button>Save Card</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PaymentInfo',
  methods: {
    saveCard() {
      let cardNum = document.querySelector("#cardNum")
      let expirationMonth = document.querySelector("#expireMM")
      let expirationYear = document.querySelector("#expireYY")
      let ccNum = document.querySelector("#ccNum")
      // let fullName = document.querySelector("#fullName")

      let cardPayload = {
        "cardnumber" : cardNum,
        "ccnumber" : ccNum,
        "cardexpiry" : expirationMonth + "/" + expirationYear,
      }

      fetch("", {
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
        font-size: 25px;
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