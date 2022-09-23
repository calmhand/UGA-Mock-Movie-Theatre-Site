<template>
  <div>
    <span>{{title}}</span><br>
    <iframe height="260px" width="530px" :src="trailer" encrypted-media picture-in-picture allowfullscreen></iframe>
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

<style>

</style>