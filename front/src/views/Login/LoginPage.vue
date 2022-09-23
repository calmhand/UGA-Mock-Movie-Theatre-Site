<template>
  <div class="login-container">
    <div class="form-container">
      <form>
        <br>
        <label for="email">Email</label><br>
        <input name="email" type="email" id="email-input" placeholder="lorem@ipsum.com"><br>

        <label for="password">Password</label><br>
        <input name="password" type="password" id="pass-input" placeholder="******"><br>
        <!-- TODO: Don't implement yet. Just send to a Customer's profile. -->
        <button type="button" id="login-button" @click="goToProfile()">Login</button><br><br>
        
        New to the site? <router-link to="/login/create">Create an Account!</router-link><br><br>
        <router-link to="/login/admin">Admin Login</router-link> <!-- TODO: DECIDE TO KEEP OR REMOVE -->
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginPage",
  methods: {
    goToProfile() {
      this.$router.push({name: 'UserProfile', params: {userId: 123}})
    }
  },
}
</script>

<style scoped>
  .login-container {
    height: 100vh;
  }

  .form-container {

    margin: 0 auto;
    border: solid 2px green;
    display: flex;
    align-items: center;
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