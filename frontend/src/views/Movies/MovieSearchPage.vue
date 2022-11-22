<template>
    <h1>Showing results for: "{{this.query}}"</h1>
    <h1 v-if="searchResults.length==0" style="color: red;">No movies by that name were found!</h1>
    <div id="search-movies-container">
        <MoviePoster v-for="movie in searchResults" :key="movie.movieID"
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
    name: "MovieSearchPage",
    props: ['query'],
    components: {MoviePoster},
    data() {
      return {
        searchResults : []
      }
    },
    methods: {
        async populateSearchPage() {
          await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/movies-title/" + this.query, {
              method: "GET",
              headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
              },
          })
          .then((res) => res.json())
          .then((s) => {
            this.searchResults = s.movies
          })
      }
    },
    mounted() {
      this.populateSearchPage()
    },
    beforeUpdate() {
        this.populateSearchPage()
    }
}
</script>
    
<style scoped>
  #search-movies-container {
    height: 100vh;
    display: flex;
    flex-wrap: wrap;
    padding: 50px;
  }

</style>