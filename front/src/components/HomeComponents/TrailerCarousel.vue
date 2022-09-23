<template>
    <div id="trailer-carousel" class="carousel slide" data-interval="false">
        <div class="carousel-inner">
            <!-- TODO: Create an array of Trailer objects nested in 'active item' divs -->
            <div class="carousel-item active">
                <MovieTrailer :title="`God of War`" :trailer="`https://www.youtube.com/embed/hfJ4Km46A-0`" />
            </div>

            <div class="carousel-item">
                <MovieTrailer :title="`Elden Ring`" :trailer="`https://www.youtube.com/embed/e5wwSxl0atc`" />
            </div>

            <div class="carousel-item">
                <MovieTrailer :title="`Pokemon Pearl`" :trailer="`https://www.youtube.com/embed/9-qGKAdbVtw`" />
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