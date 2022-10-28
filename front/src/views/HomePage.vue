<template>
  <div class="homepage">
    <!-- scrollable display for movie trailers? -->
    <div id="trailer-container">
      <!-- <TrailerCarousel /> -->
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
    // eslint-disable-next-line
    TrailerCarousel, UpcomingShows, CurrentShows
  },
  methods: {

  }
}
</script>

<style scoped>
  .homepage {
    display: flex;
    flex-direction: column;
  }

  h1 {
    margin: 0;
    color: white;
    text-decoration: underline;
  }

  #trailer-container {
    height: 350px;
  }

</style>