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
    height: 275px;
    width: 175px;
    margin: 5px 35px;
    color: black;
  }

  #poster-image {
    height: inherit;
    width: inherit;
    border: solid 2px black;
    transition: opacity 0.2s ease-in-out;
  }

  #poster-image:hover {
    cursor: pointer;
    opacity: 0.6;
  }
</style>