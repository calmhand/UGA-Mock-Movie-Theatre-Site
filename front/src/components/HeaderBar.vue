<template>
    <div class="nav-bar" id="nav-bar">
        <div id="nav-content">
            <!-- Right Side -->
            <!-- Home -->
            <router-link id="nav-element" to="/home"><i class="fa-solid fa-house"></i></router-link>
            
            <!-- Shows -->
            <router-link id="nav-element" to="/movies/list"><i class="fa-solid fa-ticket"></i></router-link>

            <!-- Left Side --> <!-- TODO: Make site automatically update header based on user's state? -->
            <!-- Login/Account -->
            <router-link id="nav-element" style="float:right;" to="/login"><i class="fa-regular fa-user"></i></router-link>
            <!-- Search -->
            <router-link id="nav-element" style="float:right;" to="/home"><i @click="search()" class="fa-solid fa-magnifying-glass"></i></router-link>
            <input id="search-input" style="float:right;" placeholder="Search" v-on:focusout="closeSearch()">

        </div>
    </div>
</template>

<script>
export default {
    name: "HeaderBar",
    props: [''],
    methods: {
        search() {
            let searchBar = document.querySelector('#search-input')
            if (searchBar.style.opacity == '1') {
                // TODO: Implement Search Function
                console.log('initiate search');
            } else {
                searchBar.style.opacity = '1'
                searchBar.style.pointerEvents = 'auto'
            }
        },
        closeSearch() {
            let searchBar = document.querySelector('#search-input')
            // Input auto closes when not in focus.
            searchBar.style.opacity = '0'
            searchBar.style.pointerEvents = 'none'
        }
    }
}
</script>

<style scoped>
    .nav-bar {
        height: 50px;
        text-align: left;
        padding: 0;
        background-image: url("@/assets/header-icon.png");
        background-size: 50px;
        background-repeat: no-repeat;
        background-position-x: center;
        background-color: black;
        opacity: 0.9;
        backdrop-filter: blur(10px);
    }

    #nav-content {
        padding: 10px 0;
    }

    #nav-element {
        padding: 0 15px;
        margin: 0 15px;
        text-decoration: none;
        color: white;
        font-size: 20px;
        transition: opacity 0.2s ease-in-out;
    }

    #nav-element:hover {
        opacity: 0.5;
    }

    #search-input {
        border: none;
        outline: none;
        pointer-events: none;
        opacity: 0;
        transition: opacity 0.3s ease-in-out;

        margin: 0 15px;
        background-color: transparent;
        border-bottom: 2px solid white;
        color: white;
    }
</style>