<template>
  <div id="admin-login-container">
    <div id="form-container">
      <div>
        <h3><i class="fa-solid fa-user-gear"></i>Admin Login</h3>
        <hr>
        <form>
          <div id="col">
            <input name="adminUser" type="username" id="user-input" autofocus required>
            <label for="adminUser"><i class="fa-solid fa-at"></i>Username</label>
          </div>

          <div id="col">
            <input name="adminPass" type="password" id="pass-input" required>
            <label for="adminPass"><i class="fa-solid fa-key"></i>Password</label>
          </div>

            <button @click="loginAdmin()" type="button" id="login-button">
              <i class="fa-solid fa-right-to-bracket"></i>
            </button>
        </form>
      </div>
    </div>
  </div>
  <AlertModal :id="`alert-admin-login-modal`" :errorTitle="`Admin Login Error`" :message="`Bad credentials. Please enter the correct information or contact IT department.`"/>
  <button id="alert-admin-login-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-admin-login-modal"></button>
</template>

<script>
import AlertModal from '@/components/AlertModal.vue'

export default {
    name: "AdminLogin",
    components: {AlertModal},
    methods: {
      loginAdmin() {
        let username = document.querySelector("#user-input").value
        let password = document.querySelector("#pass-input").value

        let adminPayload = {
          "username" : username,
          "password" : password
        }

        let adminLogin = async () => {
          await fetch("http://127.0.0.1:8084/api/auth/login", {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(adminPayload)
          })
          .then((res) => res.json())
          .then((s) => {
            if (s.status != 401 && s.roles.length == 3) {
              this.$store.commit("site/UPDATE_STATE", "ADMIN")
              this.$store.commit("site/PARSE_TOKEN", s)
              this.$router.push({path : "/admin/console"})
              console.log('Admin Login Success: ', s);
            } else {
              console.log("Unsuccsesful login attempt (from LoginPage.vue): " + JSON.stringify(s));
              document.querySelector("#alert-admin-login-btn").click()
            }
          })
          .catch((err) => console.log('err: ', err))
        }

        adminLogin()
      },
    },
    beforeMount() {
        // if (this.$store.state.currentState == 1) {
        //     alert("Must be logged in.")
        //     this.$router.push({path: "/login"})
        // }
    }
}
</script>

<style scoped>
  #admin-login-container {
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  #form-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 400px;
    width: 500px;
    margin: 0 10px;
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

  i {
    font-size: 20px;
    margin: 0 10px;
  }

  a {
    text-decoration: none;
    font-size: 20px;
    transition: opacity 0.2s ease-in-out;
  }

  a:hover {
    opacity: 0.7;
  }
  
  form {
    width: 400px;
  }

  label {
    font-size: 20px;
    padding-right: 10px;
    text-align: left;
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

  button {
    width: 150px;
    height: 45px;
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