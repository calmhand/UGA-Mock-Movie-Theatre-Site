<template>
  <div id="genre-btn-container">
    <div @click="sendToGenreSearch('ACTION')" id="col">
        <a>Action</a>
        <i class="fa-solid fa-bomb"></i>
    </div>

    <div @click="sendToGenreSearch('ADVENTURE')" id="col">
        <a>Adventure</a>
        <i class="fa-solid fa-shield"></i>
    </div>

    <div @click="sendToGenreSearch('DRAMA')" id="col">
        <a>Drama</a>
        <i class="fa-solid fa-masks-theater"></i>
    </div>

    <div @click="sendToGenreSearch('CRIME')" id="col">
        <a>Crime</a>
        <i class="fa-solid fa-handcuffs"></i>
    </div>

    <div @click="sendToGenreSearch('ROMANCE')" id="col">
        <a>Romance</a>
        <i class="fa-solid fa-heart"></i>
    </div>

    <div @click="sendToGenreSearch('SCIENCE_FICTION')" id="col">
        <a>Sci-Fi</a>
        <i class="fa-solid fa-rocket"></i>
    </div>

    <div @click="sendToGenreSearch('COMEDY')" id="col">
        <a>Comedy</a>
        <i class="fa-solid fa-face-grin-squint-tears"></i>
    </div>

    <div @click="sendToGenreSearch('THRILLER')" id="col">
        <a>Thriller</a>
        <i class="fa-solid fa-burst"></i>
    </div>

    <div @click="sendToGenreSearch('HORROR')" id="col">
        <a>Horror</a>
        <i class="fa-solid fa-ghost"></i>
    </div>
  </div>
</template>

<script>
export default {
    name: "GenresBar",
    methods: {
        sendToGenreSearch(genre) {
            this.$router.push({path:"/movies/filter/" + genre})
        }
    }
}
</script>

<style scoped>
#genre-btn-container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    padding: 25px;
}

#col {
    display: flex;
    flex-direction: column;
    justify-content: center;
    margin: 0 15px;
}

i {
    font-size: 20px;
    margin: 0 10px;
    color: #FBFFF1;
}

a, #col {
    text-decoration: none;
    margin: 0 10px;
    font-size: 20px;
    transition: opacity 0.2s ease-in-out;
    cursor: pointer;
}

a:hover, #col:hover {
    opacity: 0.7;
}
</style>