<template>
  <div class="homepage">
    <!-- scrollable display for movie trailers? -->
    <div id="trailer-container">
      <TrailerCarousel />
    </div>

    <ShowsContainer />

  </div>
</template>

<script>
import TrailerCarousel from '@/components/HomeComponents/TrailerCarousel.vue'
import ShowsContainer from '@/components/HomeComponents/ShowsContainer.vue'

export default {
  name: 'HomePage',
  components: {
    // eslint-disable-next-line
    TrailerCarousel, ShowsContainer
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

</style>