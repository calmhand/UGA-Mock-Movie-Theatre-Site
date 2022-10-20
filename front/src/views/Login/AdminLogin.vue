<template>
  <div id="admin-login-container">
    <!-- Create a form with user and pass inputs for admin login. -->
    <label id="admin-login-label">ADMIN LOGIN</label><br>
    <div class="form-container">
      <form>
        <br>
        <label for="email">Email</label><br>
        <input name="email" type="email" id="email-input" placeholder="johnny@ipsum.com"><br>

        <label for="password">Password</label><br>
        <input name="password" type="password" id="pass-input" placeholder="******"><br>
        <router-link to="/admin/console">
        <button type="button" id="login-button">Login as Admin</button><br><br>
        </router-link>
      </form>
    </div>
    
  </div>
</template>

<script>
export default {
    name: "AdminLogin"
}
</script>

<style scoped>
  #admin-login-container {
    height: 100vh;
  }

  #admin-login-label {
    color: white;
    height: 5vh;
  }

  /* .form-container {
    margin: 0 auto;
    border: solid 2px green;
    display: flex;
    align-items: center;
  } */

  a {
    text-decoration: none;
    font-size: 20px;

  }
  
  form {
    border: solid 1px white;
    width: 400px;
    margin: 10px auto;
    padding: 40px;
  }

  input {
    width: 250px;
    height: 25px;
    border: solid 4px white;
    border-radius: 10px;
    margin: 15px;
  }
  
  label {
    font-size: 30px;
  }

  button {
    width: 150px;
    height: 45px;
    border: solid 4px white;
    border-radius: 10px;
    margin: 15px;

  }
</style>