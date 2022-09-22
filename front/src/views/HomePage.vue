<template>
  <div class="homepage">
    <input><router-link to="/movies/list">Search</router-link>

    <!-- scrollable display for movie trailers? -->
    <div>
      Trailers<br>
      [trailers go here]
    </div>

    <!-- Scrollable? Upcoming movies -->
    <div>
      Upcoming Movies<br>
      <button @click="openMovieDetails()">put movie obj here</button>
    </div>
    
    <!-- Scrollable? Movies currently showing. -->
    <div>
      Movies Showing Now<br>
      <button @click="openMovieDetails()">put movie obj here</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomePage',
  components: {
  },
  methods: {
    openMovieDetails() {
      this.$router.push({name:'MovieDetails', params: {movieName: 'Polar Express'}})
    }
  }
}
</script>

<style scoped>
  .homepage {
    background-color: rgb(255, 255, 255);
  }

</style>