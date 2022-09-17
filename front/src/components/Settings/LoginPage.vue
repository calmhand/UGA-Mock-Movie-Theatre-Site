<template>
  <div class="login-container">
    <div class="form-container">
      <form>
        <br>
        <label for="email">Email</label><br>
        <input name="email" type="email" id="email-input"><br>

        <label for="password">Password</label><br>
        <input name="password" type="password" id="pass-input"><br>
        
        New to the site? <a href="">Create an Account!</a><br><br><!-- TODO: replace with route -->
        <a href="">Admin Login</a> <!-- TODO: DECIDE TO KEEP OR REMOVE -->
      </form>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
  .login-container {
    height: 90vh;
    background-color:black;
  }

  .form-container {
    margin: 0 auto;
  }
  form {
    padding: 30% 0;
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
</style>