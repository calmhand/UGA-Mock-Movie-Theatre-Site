<template>
  <div class="create_container">
    <div class="create_form_container">
        <form id="create-account-form">
            <h3>Personal Details</h3>
            <hr>

            <!-- First/Last Names -->
            <div id="row">
                <i class="fa-regular fa-user"></i>
                <div id="col">
                    <input id="regiFirst" type="text" required/>
                    <label for="regiFirst">First Name</label>
                </div>

                <div id="col">
                    <input id="regiLast" type="text" required/>
                    <label for="regiLast">Last Name</label>
                </div>
            </div>

            <div id="row">
                <i class="fa-solid fa-mobile-screen"></i>
                <div id="col">
                    <input id="regiPhone" type="tel" maxlength="10" required/>
                    <label for="regiPhone">Phone Number</label>
                </div>
            </div>

            <h3>Account Details</h3>
            <hr>

            <!-- Email Row -->
            <div id="row">
                <i class="fa-regular fa-envelope"></i>
                <div id="col">
                    <input id="regiEmail" type="email" required/>
                    <label for="regiEmail">Email</label>
                </div>

                <div id="col">
                    <input id="confirmRegiEmail" type="email" required/>
                    <label for="confirmRegiEmail">Confirm Email</label>
                </div>
            </div>
            
            <!-- Password Row -->
            <div id="row">
                <i class="fa-solid fa-key"></i>
                <div id="col">
                    <input id="regiPass" type="password" required/>
                    <label for="regiPass">Password</label>
                </div>

                <div id="col">
                    <input id="confirmRegiPass" type="password" required/>
                    <label for="confirmRegiPass">Confirm Password</label>
                </div>
            </div>

            <!-- Street Row -->
            <div id="row">
                <i class="fa-regular fa-map"></i>
                <div id="col">
                    <input id="regiAddress" type="text"/>
                    <label for="regiAddress">Street Address</label>
                </div>

                <div id="col">
                    <input id="regiApt" type="text" style="width: 75px;"/>
                    <label for="regiApt">Apt Num.</label>
                </div>
            </div>

            <!-- Zip/City/State Row -->
            <div id="row">
                <i class="fa-solid fa-location-dot"></i>
                <div id="col">
                    <input id="regiZip" type="text" maxlength="5"/>
                    <label for="regiZip">ZIP Code</label>
                </div>

                <div id="col">
                    <input id="regiCity" type="text"/>
                    <label for="regiCity">City</label>
                </div>

                <div id="col">
                    <select id="regiState">
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
                    <label for="regiState">State</label>
                </div>
            </div>
            <br><hr>
            <div id="row-promo">
                <div id="col">
                    <label for="isSubscribed"><input id="isSubscribed" type="checkbox" checked="checked"/>Sign-up for promotions?</label>
                </div>
                <!-- <router-link id="create-account-btn" to="/login/confirmation">Next Step</router-link> -->
                <button @click="this.registerUser" id="create-account-btn" type="submit">Create Account</button>
            </div>
        </form>
        <div id="movie-image"></div>
    </div>
  </div>
</template>

<script>
export default {
    name: "CreateAccount",
    methods: {
        async sendPayload(payload) {
            await fetch("http://127.0.0.1:8084/api/auth/register", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(payload)
            })
            .then((res) => res.json())
            .then((result) => {
                alert("Sucessfully registered: Please check email to verify account before logging in.")
                this.$router.push({path : "/login"})
                console.log('success: ', result);
                // this.confirm(result.userID)
            })
            .catch((err) => console.log('err: ', err))
        },
        async confirm(id) {
            await fetch("http://127.0.0.1:8084/" + id + "/confirmemail", {
                method: 'PUT',
                headers: {
                    
                },
            })
            .then((res) => res.json())
            .then((result) => {console.log(result);})
            .catch((err) => {console.log("success: " + err);})
        },
        registerUser() {
            let fname = document.querySelector('#regiFirst').value
            let lname = document.querySelector('#regiLast').value
            let phone = document.querySelector('#regiPhone').value
            let email = document.querySelector('#regiEmail').value
            let pass = document.querySelector('#regiPass').value
            let street = document.querySelector('#regiAddress').value
            let apt = document.querySelector('#regiApt').value
            let zip = document.querySelector('#regiZip').value
            let city = document.querySelector('#regiCity').value
            let state = document.querySelector('#regiState').value
            let isSubbed = document.querySelector('#isSubscribed').checked

            let confirmPass = document.querySelector("#confirmRegiPass").value
            if (!(pass === confirmPass)) {
                alert("Registration Error: Passwords don't match.")
                throw "Err: Password dont match."
            }

            let payload = {
                "firstName" : fname,
                "lastName" : lname,
                "number" : phone,
                "email" : email,
                "password" : pass,
                "isSubscribed" : isSubbed,
                "address" : {
                    "street" : street,
                    "apt" : apt,
                    "city" : city,
                    "state" : state,
                    "zipcode" : zip
                },
                "status" : "ACTIVE",
                "userType" : "CUSTOMER"
            }
            this.sendPayload(payload)
            
            // change route to email confirmation.
        }
    }
}
</script>

<style scoped>
    #movie-image {
        margin: 10px;
        height: 90%;
        width: 25%;
        background-image: url('@/assets/temp_assets/createAccountImg.jpg');
        background-repeat: no-repeat;
        background-size: cover;
        background-position: -375px;
    }

    .create_container {
        height: 120vh;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
    }

    .create_form_container {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;

        height: 90%;
        width: 90%;

        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 10px;
    }

    #create-account-form {
        margin: 10px;
        text-align: left;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
    }

    #create-account-btn {
        padding: 10px;
        margin: 10px 0;
        width: 175px;
        text-decoration: none;
        background-color: transparent;
        font-size: 20px;
        text-align: center;
        color: #FBFFF1;
        border: solid 2px #FBFFF1;
        border-radius: 20px;
        cursor: pointer;
        transition: opacity 0.2s ease-in-out;
    }

    #create-account-btn:hover {
        opacity: 0.6;
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

    #row-promo {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: right;
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
        font-size: 17px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: #FBFFF1;
        transition: border-color 0.2s ease-in-out;
    }

    #isSubscribed {
        height: 15px;
        width: 50px;
        border: solid 3px #FBFFF1;
    }

    input:required {
        border-bottom: solid 4px #FBFFF1;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
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