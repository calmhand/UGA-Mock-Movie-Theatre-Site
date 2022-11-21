<template>
  <div class="login-container">

    <div id="form-container">
      <form>
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
        <button type="button" @click="parseLoginForm()" id="create-acc-btn">
          <i class="fa-solid fa-right-to-bracket"></i>
        </button>
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
    parseLoginForm() {
      let email = document.querySelector("#loginEmail").value
      let pass = document.querySelector("#loginPassword").value
      let loginPayload = {
        "username" : email,
        "password" : pass
      }

      const getProfile = async () => {
        await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/getprofile", {
          method: "GET",
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        })
        .then((res) => res.json())
        .then((data) => {
          console.log("Successfully retrieved profile: " + JSON.stringify(data));
          this.$store.commit("users/SET_USER", data)
        })
        .catch((err) => {console.log("err in getProfile: " + err);})
      }

      const login = async (payload) => {
        await fetch("http://127.0.0.1:8084/api/auth/login", {
          method: "POST",
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(payload)
        })
        .then((res) => res.json())
        .then((s) => {
          if (s.status != 401) {
            alert("Login successful!")
            console.log("Succesfully retrieved JWT Token (from LoginPage.vue): " + s);
            this.$store.commit("site/PARSE_TOKEN", s)
            getProfile()
            this.$router.push("/home")
          } else {
            console.log("Unsuccsesful login attempt (from LoginPage.vue): " + JSON.stringify(s));
            alert("Wrong credentials. Try again.")
          }
        })
        .catch((err) => {console.log("Err:" + err);})
      }
      login(loginPayload)
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