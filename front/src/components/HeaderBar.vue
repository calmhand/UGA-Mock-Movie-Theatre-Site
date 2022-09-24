<template>
    <div class="nav-bar" id="nav-bar">
        <div id="nav-content">
            <!-- Right Side -->
            <router-link id="nav-element" to="/home">Home</router-link>
            <router-link id="nav-element" to="/movies/list">Movies</router-link>

            <!-- Left Side -->
            <!-- <router-link id="nav-element" style="float:right;" to="/test">Showtimes</router-link> -->

            <!-- <router-link v-if=loginState id="nav-element" style="float:right;" to="/settings">Account</router-link> -->
            <router-link id="nav-element" style="float:right;" to="/login">Login</router-link>  <!-- TODO: Make site automatically update header based on user's state. -->
            <a href=""></a>
        </div>
    </div>
</template>

<script>
export default {
    name: "HeaderBar",
    props: ['']
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
        text-decoration: none;
        color: white;
        font-size: 20px;
        transition: opacity 0.2s ease-in-out;
        animation: highlight 1s infinite;
    }

    #nav-element:hover {
        opacity: 0.5;
    }
</style>