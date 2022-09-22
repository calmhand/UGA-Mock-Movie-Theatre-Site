<template>
  <div class="create_container">
    <div class="create_form_container">
        <form id="create-account-form">
            <!-- TODO: Add placeholders for demonstration. -->
            <label>Username</label>
            <input type="text"/><br>

            <label>Email</label>
            <input type="email"/><br>

            <label>Password</label>
            <input type="password"/><br>

            <label>Re-enter Password</label>
            <input type="password"/><br>

            <label>Street Address</label>
            <input type="text"/>

            <label>Zipcode</label>
            <input type="number"/>

            <label>State</label>
            <select>
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

            <input value="Create Account" type="submit"/>
        </form>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
    .create_container {
        height: 100%;
        background-color: black;
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
        height: 25px;
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