<template>
  <div  id="trailer-container">
    <iframe height="300px" width="530px" :src="trailer" encrypted-media picture-in-picture allowfullscreen></iframe><br>
    <span>{{title}}</span>
  </div>
</template>

<script>
export default {
    props: {
        title: String,
        trailer: String
    }
}
</script>

<style scoped>
  #trailer-container {
    margin: 10px 0;
  }
</style>