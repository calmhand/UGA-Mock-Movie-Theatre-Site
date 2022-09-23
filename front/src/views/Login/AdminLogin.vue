<template>
  <div id="admin-login-container">
    <!-- Create a form with user and pass inputs for admin login. -->
    ADMIN LOGIN
    <router-link to="/admin/home">Login</router-link>
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
</style>