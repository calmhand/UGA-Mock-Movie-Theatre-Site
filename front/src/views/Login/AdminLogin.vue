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

        <router-link to="/admin/console">
          <button type="button" id="login-button">
            <i class="fa-solid fa-right-to-bracket"></i>
          </button>
        </router-link>
      </form>
      </div>
    </div>
    
  </div>
</template>

<script>
export default {
    name: "AdminLogin",
    beforeMount() {
        if (this.$store.state.currentState == 1) {
            alert("Must be logged in.")
            this.$router.push({path: "/login"})
        }
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