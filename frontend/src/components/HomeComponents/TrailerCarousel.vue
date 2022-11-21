<template>
    <!-- TODO: Create an array of Trailer objects nested in 'active item' divs ?-->
    
    <div id="home-trailer-carousel" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#home-trailer-carousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#home-trailer-carousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#home-trailer-carousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            
            <div class="carousel-item active">
                <MovieTrailer :trailerNum="0" />
            </div>
            <div class="carousel-item">
                <MovieTrailer :trailerNum="1" />
            </div>
            <div class="carousel-item">
                <MovieTrailer :trailerNum="2" />
            </div>
        </div>
    </div>
</template>

<script>
import MovieTrailer from '@/components/MovieComponents/MovieTrailer.vue'

export default {
    name: "TrailerCarousel",
    components: {MovieTrailer}
}
</script>

<style scoped>
    #home-trailer-carousel {
        height: 100%;
        width: 100%;
    }
</style>