<template>
  <div id="current-shows-container">
    <MoviePoster v-for="movie in currentFilms.slice(0, 5)" :key="movie.movieID"
      :id="movie.movieID"
      :title="movie.title"
      :genre="movie.category"
      :rating="movie.rating"
      :poster="movie.posterURL"
      :trailer="movie.trailerURL"
      :release="movie.releaseDate"
      :movieObj="movie"
      :upcoming="false"
    />
  </div>
</template>

<script>
import MoviePoster from '@/components/MovieComponents/MoviePoster.vue';
export default {
  name: "CurrentShows",
  components: {MoviePoster},
  data() {
    return {
      currentFilms : []
    }
  },
  methods: {
    async getCurrentFilms() {
      await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/home", {
          method: "GET",
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
      })
      .then((res) => res.json())
      .then((s) => {
        this.currentFilms = s.currentMoviesList
      })
    }
  },
  mounted() {
    this.getCurrentFilms()
  }
}
</script>

<style scoped>
    #current-shows-container {
        display: flex;
        justify-content: center;
        flex-direction: row;
        flex-wrap: wrap;
        padding: 10px;
    }
</style>