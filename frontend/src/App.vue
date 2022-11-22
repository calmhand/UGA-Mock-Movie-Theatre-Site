<template>
  <div id="main-window">
    <HeaderBar />
    <router-view />
    <FooterInfo/>
  </div>
</template>

<script>
  import HeaderBar from "@/components/HeaderBar.vue"
  import FooterInfo from "@/components/FooterInfo.vue"

  export default {
    name: "App",
    components: {FooterInfo, HeaderBar},
    methods: {

    },
    data() {
      return {
        
      }
    },
  }
</script>

<style>
/* SITE WIDE COLORS 
  BLACK COFFEE - #3C3744 - BACKGROUND (GRADIENT)
  DUKE BLUE - #090C9B = BACKGROUND (GRADIENT)
  TRUE BLUE - #3088BE - LINKS
  LIGHT STEEL BLUE - #B4C5E4 - ETC
  IVORY - #FBFFF1 = REGULAR TEXT, BUTTONS
*/

@font-face {
  font-family: robo;
  src: url(@/assets/Roboto_Condensed/RobotoCondensed-Regular.ttf);
}

@font-face {
  font-family: bold-robo;
  src: url(@/assets/Roboto_Condensed/RobotoCondensed-BoldItalic.ttf)
}

#app {
  font-family: robo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #FBFFF1;
}

nav {
  padding: 30px;
}

a {
  font-weight: bold;
  color: #3066BE;
}

a.router-link-exact-active {
  color: #42b983;
}

#main-window {
  min-height: 100vh;
  background-image: linear-gradient(160deg, #090C9B, #3C3744);
}
</style>
