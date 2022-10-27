<template>
  <div id="address-info-container">
    <div id="address-info">
      <div style="width: 100%;">
          <h3>Address Info</h3>
          <hr>
      </div>
      <form>
        <div id="row">
            <i class="fa-regular fa-map"></i>
            <div id="col">
                <input id="address" type="text"/>
                <label for="address">Street Address</label>
            </div>

            <div id="col">
                <input id="regiApt" type="text" style="width: 75px;"/>
                <label for="regiApt">Apt Num.</label>
            </div>
        </div>

        <div id="row">
          <i class="fa-solid fa-location-dot"></i>
          <div id="col">
              <input id="zip" type="text" maxlength="5"/>
              <label for="zip">Zipcode</label>
          </div>
        </div>
        <div id="row">
          <i class="fa-solid fa-city"></i>
          <div id="col">
              <input id="city" type="text"/>
              <label for="city">City</label>
          </div>

          <div id="col">
              <select id="state">
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
              <label for="state">State</label>
          </div>
        </div>
        <!-- TODO: Implement changeAddress Method -->
        <button>Save Changes</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AddressInfo',
  methods: {
    changeAddress() {
        // let street = document.querySelector('#regiAddress').value
        // let apt = document.querySelector('#regiApt').value
        // let zip = document.querySelector('#regiZip').value
        // let city = document.querySelector('#regiCity').value
        // let state = document.querySelector('#regiState').value
    }
  }
}
</script>

<style scoped>
    #address-info-container {
        display: none;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        text-align: left;
    }

    #address-info {
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
        width: 150px;
        height: 50px;
        color: #FBFFF1;
        background-color: transparent;
        border: none;
        border-bottom: solid 4px #FBFFF1;
    }
</style>