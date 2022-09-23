<template>
  <div class="homepage">
    <input><router-link to="/movies/list">Search</router-link>

    <!-- scrollable display for movie trailers? -->
    <div>
      <span>Trailers</span><br>
      <TrailerCarousel />
    </div>

    <!-- Scrollable? Upcoming movies -->
    <span>Upcoming Movies</span><br>
    <UpcomingShows />
    
    <!-- Scrollable? Movies currently showing. -->
    <div>
      <span>Now Playing</span><br>
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

</style>