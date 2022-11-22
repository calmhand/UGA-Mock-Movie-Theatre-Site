<template>
    <div id="genres-container">
        <GenresBar />
    </div>
    <hr>
    <h1>Showing results for: "{{this.genre}}"</h1>
    <h1 v-if="genreResults.length==0" style="color: red;">No movies of this genre were found!</h1>
    <div id="movie-genre-container">
        <MoviePoster v-for="movie in genreResults" :key="movie.movieID"
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
import GenresBar from '@/components/MovieComponents/GenresBar.vue'
import MoviePoster from '@/components/MovieComponents/MoviePoster.vue';
export default {
    name: "MovieSearchPage",
    props: ['genre'],
    components: {GenresBar, MoviePoster},
    data() {
      return {
        genreResults : []
      }
    },
    methods: {
        async populateGenrePage() {
          await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/movies-genre/" + this.genre, {
              method: "GET",
              headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
              },
          })
          .then((res) => res.json())
          .then((s) => {
            this.genreResults = s.movies
          })
          .catch((err) => {console.log("Err: " + err);})
      }
    },
    mounted() {
        this.populateGenrePage()
    },
    beforeUpdate() {
        this.populateGenrePage()
    }
}
</script>
    
<style scoped>
#movie-genre-container {
    height: 100vh;
    display: flex;
    flex-wrap: wrap;
    padding: 50px;
}

hr {
    margin: 0;
}
</style>