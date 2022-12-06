<template>
  <div id="main-window">
    <HeaderBar />
    <router-view />
    <!-- <FooterInfo/> -->
  </div>
  <AlertModal :id="`alert-site-state-modal`" :errorTitle="`State Error`" :message="`Inaccessible page. Please login as correct user.`"/>
  <button id="alert-site-state-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-site-state-modal"></button>
</template>

<script>
import HeaderBar from "@/components/HeaderBar.vue"
import FooterInfo from "@/components/FooterInfo.vue"
import AlertModal from '@/components/AlertModal.vue'

export default {
  name: "App",
  // eslint-disable-next-line
  components: {FooterInfo, HeaderBar, AlertModal},
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

html {
  height: 100%;
}

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
  /* background-image: linear-gradient(160deg, black, red, blue); */
  background: linear-gradient(139deg, #3C3744, #090C9B, #7376f3);
  background-size: 700% 700%;
  animation: animated-bg 120s ease infinite;
}

@keyframes animated-bg {
    0%{background-position:0% 50%}
    50%{background-position:100% 50%}
    100%{background-position:0% 50%}
}
</style>
