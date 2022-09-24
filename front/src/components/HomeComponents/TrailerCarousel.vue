<template>
    <div id="trailer-carousel" class="carousel slide" data-interval="false">
        <div class="carousel-inner">
            <!-- TODO: Create an array of Trailer objects nested in 'active item' divs -->
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
    </div> 
</template>

<script>
import MovieTrailer from '@/components/MovieComponents/MovieTrailer.vue'

export default {
    components: {MovieTrailer}
}
</script>

<style scoped>
    
</style>