<template>
  <div id="film-container">
    <img id="poster-image" :src="require(`@/assets/temp_assets/${poster}`)"/>
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
    margin: 5px 15px;
    color: black;
  }

  #poster-image {
    width: 140px;
  }
</style>