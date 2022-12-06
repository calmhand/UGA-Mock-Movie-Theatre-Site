<template>
  <div id="movie-poster-container">
    <div @click="sendToMoviePage()" id="film-poster-container">
      <img id="poster-image" :src="poster"/>
    </div>
    {{title}} <br>
    Genre: {{genre}} <br>
    Rating: {{rating}} <br>
    Release: {{release}}
  </div>
</template>

<script>
export default {
  name: "MoviePoster",
  props: ['title', `poster`, `genre`, `release`, `rating`, `id`, `trailer`, `movieObj`, `upcoming`],
  methods: {
    sendToMoviePage() {
      if (!this.upcoming) {
        this.$router.push({path: "/movies/"+ this.id + "/" + this.title +"/info"})
      }
    }
  }
}
</script>

<style scoped>
  #movie-poster-container {
    margin: 15px;
  }
  #film-poster-container {
    height: 250px;
    width: 150px;
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