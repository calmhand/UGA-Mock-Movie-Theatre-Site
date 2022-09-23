<template>
  <div class="create_container">
    <div class="create_form_container">
        <form id="create-account-form">
            <!-- TODO: Remove placeholders when implementing. -->
            <label>Username</label>
            <input type="text" placeholder="lorem"/><br>

            <label>Email</label>
            <input type="email" placeholder="lorem@ipsum.com"/><br>

            <label>Password</label>
            <input type="password" placeholder="***"/><br>

            <label>Re-enter Password</label>
            <input type="password" placeholder="***"/><br>

            <label>Street Address</label>
            <input type="text" placeholder="104 Caldwell Hall"/>

            <label>Zipcode</label>
            <input type="number" placeholder="30602"/><br>

            <label>City</label>
            <input type="text" placeholder="Athens"/>

            <label>State</label>
            <select >
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
            <br>

            <router-link to="/login/confirmation">Create Account</router-link>
        </form>
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
    .create_container {
        height: 100vh;
    }

    .create_form_container {
        border: 1px solid white;
    }

    #create-account-form {
        border: 1px solid green;
        margin: 10px;
        text-align: left;
    }

    label {
        font-size: 25px;
        padding-right: 10px;
    }

    input {
        width: 200px;
        height: 50px;
        border: solid 4px white;
        border-radius: 10px;
        margin: 15px;
    }

    select {
        width: 50px;
        height: 50px;
        border: solid 4px white;
        border-radius: 10px;
        margin: 15px;
    }
</style>