<template>
  <HeaderBar/>
  <router-view/>
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
#app {
  font-family: robo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #b3b3b3;
  background-color: white;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

@font-face {
  font-family: robo;
  src: url(@/assets/Roboto_Condensed/RobotoCondensed-Regular.ttf);
}
</style>
