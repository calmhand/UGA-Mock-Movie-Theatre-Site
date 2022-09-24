<template>
  <div id="movies-container">
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

    <MoviePoster id="pearl-poster"
      :title="`Pearl`" 
      :poster="require(`@/assets/temp_assets/pearl-poster.jpg`)"
      :genre="`Horror`"
      rating="R"
      release="09/16"
      @click="seeMovieDetails('Pearl')"
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
    name: "MoviePage",
    components: {MoviePoster},
    methods: {
        seeMovieDetails(id) {
            console.log(id);
            this.$router.push({name: 'MovieDetails', params:{movieId:`${id}`}})
        }
    }
}
</script>
    
<style scoped>
  #movies-container {
    height: 100vh;
    display: flex;
  }

  #pearl-poster {
    animation: highlight 1s infinite; /* TODO: Delete after demo*/
  }

</style>