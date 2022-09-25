<template>
  <div class="homepage">
    <div id="search-container">
      <input placeholder="Pearl"><router-link id="search-button" to="/movies/list">Search</router-link>
    </div>

    <!-- scrollable display for movie trailers? -->
    <div>
      <h1>TRAILERS</h1><br>
      <TrailerCarousel />
    </div>

    <!-- Scrollable? Upcoming movies -->
    <h1>UPCOMING MOVIES</h1><br>
    <UpcomingShows />
    
    <!-- Scrollable? Movies currently showing. -->
    <div>
      <h1>NOW PLAYING</h1><br>
      <CurrentShows />
    </div>
  </div>
</template>

<script>
import TrailerCarousel from '@/components/HomeComponents/TrailerCarousel.vue'
import UpcomingShows from '@/components/HomeComponents/UpcomingShows.vue'
import CurrentShows from '@/components/HomeComponents/CurrentShows.vue'

export default {
  name: 'HomePage',
  components: {
    TrailerCarousel, UpcomingShows, CurrentShows
  },
  methods: {

  }
}
</script>

<style scoped>
  .homepage {
    margin: 10px; 
  }

  h1 {
    margin: 0;
    color: white;
    text-decoration: underline;
  }

  #search-button {
    text-decoration: none;
    color: white;
    margin: 0 10px;
  }
</style>