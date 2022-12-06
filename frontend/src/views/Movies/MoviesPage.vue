<template>
  <div id="movies-page-container">
    <div id="genres-container">
      <GenresBar />
    </div>
    <hr>
    <div id="movies-container">
      <MoviePoster v-for="movie in currentFilms" :key="movie.movieID"
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
  </div>
</template>

<script>
import GenresBar from '@/components/MovieComponents/GenresBar.vue'
import MoviePoster from '@/components/MovieComponents/MoviePoster.vue';
export default {
    name: "MoviePage",
    props: ['query'],
    components: {GenresBar, MoviePoster},
    data() {
      return {
        currentFilms : []
      }
    },
    methods: {
        async populateMoviePage() {
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
          .catch((err) => {console.log("Err: " + err);})
      }
    },
    mounted() {
      this.populateMoviePage()
    }
}
</script>
    
<style scoped>
  #movies-container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    padding: 50px;
  }

  hr {
    margin: 0;
  }
</style>