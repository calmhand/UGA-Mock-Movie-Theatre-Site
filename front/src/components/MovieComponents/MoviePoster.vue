<template>
  <div id="film-container">
    <img :src="poster">
    {{title}}
    {{runtime}} | {{genre}}
    {{release_date}}
    {{rating}}
  </div>
</template>

<script>
export default {
    props: {
        title: String,
        genre: String,
        poster: String,
        runtime: String,
        release_date: String,
        rating: Number
    }
}
</script>

<style scoped>
  #film-container {
    height: 250px;
    width: 150px;
    background-color: white;
    border: solid 2px grey;
    margin: 0 15px;
  }
</style>