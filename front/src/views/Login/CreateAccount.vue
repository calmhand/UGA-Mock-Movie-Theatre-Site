<template>
  <div class="create_container">
    <div class="create_form_container">
        <form id="create-account-form">
            <!-- TODO: Create validation checks for passwords. -->
            <h3>Personal Details</h3>
            <hr>

            <div id="row">
                <i class="fa-regular fa-user"></i>
                <div id="col">
                    <input id="firstName" type="text" required/>
                    <label for="firstName">First Name</label>
                </div>

                <div id="col">
                    <input id="lastName" type="text" required/>
                    <label for="lastName">Last Name</label>
                </div>
            </div>

            <div id="row">
                <i class="fa-solid fa-at"></i>
                <div id="col">
                    <input id="userName" type="text"/>
                    <label for="userName">Username</label>
                </div>
            </div>

            <div id="row">
                <i class="fa-solid fa-mobile-screen"></i>
                <div id="col">
                    <input id="phone" type="tel" maxlength="10" required/>
                    <label for="phone">Phone Number</label>
                </div>
            </div>

            <h3>Account Details</h3>
            <hr>

            <div id="row">
                <i class="fa-regular fa-envelope"></i>
                <div id="col">
                    <input id="email" type="email" required/>
                    <label for="email">Email</label>
                </div>

                <div id="col">
                    <input id="email" type="email" required/>
                    <label for="email">Confirm Email</label>
                </div>
            </div>

            <div id="row">
                <i class="fa-solid fa-key"></i>
                <div id="col">
                    <input id="password" type="password" required/>
                    <label for="password">Password</label>
                </div>

                <div id="col">
                    <input id="confirmPass" type="password" required/>
                    <label for="confirmPass">Confirm Password</label>
                </div>
            </div>

            <div id="row">
                <i class="fa-regular fa-map"></i>
                <div id="col">
                    <input id="address" type="text"/>
                    <label for="address">Street Address</label>
                </div>

                <div id="col">
                    <input id="zip" type="text" maxlength="5"/>
                    <label for="zip">Zipcode</label>
                </div>

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
            <router-link id="create-account-btn" to="/login/confirmation">Create Account</router-link>
        </form>
        <div id="movie-image"></div>
    </div>
  </div>
</template>

<script>
export default {
    name: "CreateAccount",
    methods: {
        
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
        height: 100vh;
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
        font-size: 20px;
        text-align: center;
        color: white;
        border: solid 2px white;
        border-radius: 20px;
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
        color: white;
    }

    input {
        width: 200px;
        height: 50px;
        background-color: transparent;
        font-size: 25px;
        border: none;
        border-bottom: solid 4px white;
        outline: none;
        color: white;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 4px white;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
    }

    select {
        width: 150px;
        height: 50px;
        color: white;
        background-color: transparent;
        border: none;
        border-bottom: solid 4px white;
    }
</style>