<template>
  <div class="login-container">

    <div id="form-container">
      <form :onsubmit="this.loginUser">
        <h3><i class="fa-solid fa-user"></i> Login</h3>
        <hr>
        <div id="col">
          <input name="loginEmail" type="email" id="loginEmail" required>
          <label for="loginEmail"><i class="fa-solid fa-envelope"></i>Email</label>
        </div>
        <div id="col">
          <input name="loginPassword" type="password" id="loginPassword" required>
          <label for="loginPassword"><i class="fa-solid fa-key"></i>Password</label>
        </div>
        <!-- TODO: Delete after login is implemented. -->
        <button type="button" id="login-button" @click="goToProfile()">
          <i class="fa-solid fa-right-to-bracket"></i>
        </button>
        <!-- TODO: Implement Login -->
        <!-- <button type="submit" id="create-acc-btn">
          <i class="fa-solid fa-right-to-bracket"></i>TESTING
        </button> -->
      </form>
    </div>

    <div id="opt-container">
        <div>
          <h3 style="text-align: center;"><i class="fa-solid fa-lock"></i>Forgot Password?</h3>
          <hr>
          <ForgotPassword/>

          <h3 style="text-align: center;"><i class="fa-solid fa-circle-question"></i>New User?</h3>
          <hr>
          <router-link to="/login/create"><h3 style="text-align: center;">Create Account</h3></router-link>

          <h3 style="text-align: center;"><i class="fa-solid fa-user-gear"></i>Returning Admin?</h3>
          <hr>
          <router-link to="/login/admin"><h3 style="text-align: center;">Admin Login</h3></router-link>
        </div>
    </div>
  </div>
</template>

<script>
import ForgotPassword from '@/components/LoginComponents/ForgotPassword.vue'
export default {
  name: "LoginPage",
  components: {ForgotPassword},
  methods: {
    goToProfile() {
      this.$router.push({name: 'UserProfile', params: {userId: 123}})
    },
    parseLoginForm() {
      let email = document.querySelector("#loginEmail").value
      let pass = document.querySelector("#loginPass").value

      let loginPayload = {
        "email" : email,
        "password" : pass
      }
      this.loginUser(loginPayload)
    },
    loginUser(payload) {
      // fetch here. 
      // upon success: change site state, append store with user creds, push user to profile via router.
      // this.$store.state.currentState = 1
      console.log(payload);
    },
  },
}
</script>

<style scoped>
  .login-container {
    height: 100vh;
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
  }

  #opt-container, #form-container {
    display: flex;
    flex-direction: column;
    height: 400px;
    width: 500px;
    margin: 0 10px;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5);
    border-radius: 10px;
  }

  #col {
      display: flex;
      flex-direction: column;
      margin: 0 15px;
  }

  h3 {
    text-align: left;
  }

  a {
    text-decoration: none;
    font-size: 20px;
    transition: opacity 0.2s ease-in-out;
  }

  a:hover {
    opacity: 0.7;
  }

  i {
    font-size: 20px;
    margin: 0 10px;
  }
  
  hr {
    margin: 0;
    color: #FBFFF1;
  }

  form {
    width: 400px;
  }

  input {
    height: 50px;
    background-color: transparent;
    font-size: 25px;
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
  
  label {
    font-size: 20px;
    padding-right: 10px;
    text-align: left;
  }

  button {
    width: 120px;
    height: 35px;
    border: solid 4px #FBFFF1;
    border-radius: 10px;
    margin-top: 25px;
    text-align: center;
    transition: opacity 0.2s ease-in-out;
  }

  button:hover {
    opacity: 0.7;
  }
</style>