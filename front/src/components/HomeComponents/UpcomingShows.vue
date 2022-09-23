<template>
  <div id="upcoming-shows-container">
    <MoviePoster />
    <MoviePoster />
    <MoviePoster />
    <MoviePoster />
    <MoviePoster />
    <MoviePoster />
    <MoviePoster />
  </div>
</template>

<script>
import MoviePoster from '@/components/MovieComponents/MoviePoster.vue';
export default {
    name: "UpcomingShows",
    components: {MoviePoster}
}
</script>

<style scoped>
    #upcoming-shows-container {
        display: flex;
        justify-content: center;
        flex-direction: row;
        flex-wrap: wrap;
        padding: 10px;
    }
</style>