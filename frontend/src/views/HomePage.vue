<template>
  <div class="homepage">
    <TrailerCarousel />
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

  },
  beforeMount() {
    this.$store.commit("movie/GET_CURRENT_MOVIES")
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