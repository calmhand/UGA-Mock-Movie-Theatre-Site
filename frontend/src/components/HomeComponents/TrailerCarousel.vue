<template>
    <!-- TODO: Create an array of Trailer objects nested in 'active item' divs -->
    <!-- <div id="trailer-carousel" class="carousel slide" data-interval="false">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <MovieTrailer :title="`The Inspection`" :trailer="`https://www.youtube.com/embed/wSeprzQM6gk`" />
            </div>

            <div class="carousel-item">
                <MovieTrailer :title="`Halloween Ends`" :trailer="`https://www.youtube.com/embed/i_mAWKyfj6c`" />
            </div>

            <div class="carousel-item">
                <MovieTrailer :title="`Amsterdam`" :trailer="`https://www.youtube.com/embed/GLs2xxM0e78`" />
            </div>
        </div>
        
        <button class="carousel-control-prev" type="button" data-bs-target="#trailer-carousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>

        <button class="carousel-control-next" type="button" data-bs-target="#trailer-carousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>  -->
    <div id="temp-carousel" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#temp-carousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#temp-carousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#temp-carousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
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
    // eslint-disable-next-line
    components: {MovieTrailer}
}
</script>

<style scoped>
    #temp-carousel {
        height: 100%;
        width: 100%;
    }
</style>