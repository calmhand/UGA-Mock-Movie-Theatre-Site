<template>
  <div id="current-shows-container">
    <MoviePoster 
      :title="`Top Gun: Maverick`" 
      :poster="require(`@/assets/temp_assets/topgun-poster.jpg`)"
      :genre="`Action`"
      rating="PG-13"
      release="07/27"
    />

    <MoviePoster 
      :title="`Bullet Train`" 
      :poster="require(`@/assets/temp_assets/bullettrain-poster.jpg`)"
      :genre="`Action`"
      rating="R"
      release="08/05"
    />

    <MoviePoster 
      :title="`On The Come Up`" 
      :poster="require(`@/assets/temp_assets/onthecomeup-poster.jpg`)"
      :genre="`Drama`"
      rating="PG-13"
      release="09/23"
    />

    <MoviePoster 
      :title="`Pearl`" 
      :poster="require(`@/assets/temp_assets/pearl-poster.jpg`)"
      :genre="`Horror`"
      rating="R"
      release="09/16"
    />

    <MoviePoster 
      :title="`The Woman King`" 
      :poster="require(`@/assets/temp_assets/womanking-poster.jpg`)"
      :genre="`Action`"
      rating="PG-13"
      release="09/16"
    />
  </div>
</template>

<script>
import MoviePoster from '@/components/MovieComponents/MoviePoster.vue';
export default {
    name: "CurrentShows",
    components: {MoviePoster}
}
</script>

<style scoped>
    #current-shows-container {
        display: flex;
        justify-content: center;
        flex-direction: row;
        flex-wrap: wrap;
        padding: 10px;
    }

</style>