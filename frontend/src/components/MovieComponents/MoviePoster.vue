<template>
  <div>
    <div id="film-poster-container">
      <img id="poster-image" :src="poster"/>
    </div>
    {{title}} | {{genre}} <br>
    Rating: {{rating}} <br>
    Release: {{release}}
  </div>
</template>

<script>


export default {
  name: "MoviePoster",
  props: ['title', `poster`, `genre`, `release`, `rating`]
}
</script>

<style scoped>
  #film-poster-container {
    height: 250px;
    width: 150px;
    margin: 5px 30px;
    color: black;
  }

  #poster-image {
    width: 150px;
    height: 250px;
    border: solid 2px black;
    transition: opacity 0.2s ease-in-out;
  }

  #poster-image:hover {
    cursor: pointer;
    opacity: 0.6;
  }
</style>