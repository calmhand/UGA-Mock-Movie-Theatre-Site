<!-- TODO Connect to spring -->
<template>
  <HeaderBar :loginState="this.loginStatus"/>
  <router-view id="main-window"/>
  <FooterInfo/>
</template>

<script>
  import HeaderBar from "@/components/HeaderBar.vue"
  import FooterInfo from "@/components/FooterInfo.vue"

  export default {
    name: "App",
    components: {FooterInfo, HeaderBar},
  }
</script>

<style>
@font-face {
  font-family: robo;
  src: url(@/assets/Roboto_Condensed/RobotoCondensed-Regular.ttf);
}

#app {
  font-family: robo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #b3b3b3;
  background-color: white;
  height: 100vh;
}

nav {
  padding: 30px;
}

a {
  font-weight: bold;
  color: #2c3e50;
}

a.router-link-exact-active {
  color: #42b983;
}

#main-window {
  height: 100%;
}
</style>
