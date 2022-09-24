<template>
  <div id="upcoming-shows-container">
    <MoviePoster 
      :title="`The Inspection`" 
      :poster="require(`@/assets/temp_assets/inspection_poster.jpg`)"
      :genre="`Drama`"
      rating="R"
      release="11/18"
    />
    <MoviePoster 
      :title="`Halloween Ends`"
      :poster="require(`@/assets/temp_assets/halloweenends-poster.jpg`)"
      :genre="`Horror`"
      rating="R"
      release="10/14"
    />
    <MoviePoster 
      :title="`Amsterdam`"
      :poster="require(`@/assets/temp_assets/amsterdamposter.jpg`)"
      :genre="`Drama`"
      rating="R"
      release="10/07"
    />
    <MoviePoster 
      :title="`Black Adam`"
      :poster="require(`@/assets/temp_assets/blackadam_poster.jpeg`)"
      :genre="`Action`"
      rating="PG-13"
      release="10/21"
    />
    <MoviePoster 
      :title="`Black Panther 2`"
      :poster="require(`@/assets/temp_assets/blackpanther-poster.jpg`)"
      :genre="`Action`"
      rating="PG-13"
      release="11/11"
    />
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