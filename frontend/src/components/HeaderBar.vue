<template>
    <div class="nav-bar" id="nav-bar">
        <div id="nav-content">
            <!-- Left Side -->
            <!-- Home -->
            <router-link id="nav-element" to="/home"><i class="fa-solid fa-house"></i></router-link>
            
            <!-- Shows -->
            <router-link id="nav-element" to="/movies/list"><i class="fa-solid fa-ticket"></i></router-link>

            <!-- Right Side -->
            <!-- Logout -->
            <a v-show="isLoggedIn()" @click="logOut()" id="nav-element" style="float:right;"><i class="fa-solid fa-right-from-bracket"></i></a>

            <!-- Login/Account -->
            <a id="nav-element" v-if="isLoggedIn()" @click=sendUser() style="float:right;"><i class="fa-solid fa-user"></i></a>
            <a id="nav-element" v-else @click=sendUser() style="float:right;"><i class="fa-regular fa-user"></i></a>

            <!-- Search -->
            <a id="nav-element" style="float:right;"><i @click="search()" class="fa-solid fa-magnifying-glass"></i></a>
            <input id="search-input" style="float:right;" placeholder="Search" v-on:focusout="closeSearch()">

        </div>
    </div>
</template>

<script>
export default {
    name: "HeaderBar",
    props: [''],
    methods: {
        logOut() {
            alert("You have been logged out!")
            this.$router.push({path: "/home"})
            this.$store.commit("site/CLEAR_TOKEN")
        },
        isLoggedIn() {
            if (this.$store.state.site.currentState == 1 || this.$store.state.site.currentState == 2) {
                return true
            } else {
                return false
            }
        },
        sendUser() {
            // TODO: DELETE: this.$store.commit("moduleTest/TEMP_TEST")
            if (this.$store.state.site.currentState == 0) {
                this.$router.push({path: '/login'})
            } else if (this.$store.state.site.currentState == 1) {
                this.$router.push({path: '/user/' + this.$store.state.site.id})
            } else if (this.$store.state.site.currentState == 2) {
                // TODO: Send to admin profile. get user id from JWT token.
                this.$router.push({path: '/admin/console'})
            }
        },
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
    },
}
</script>

<style scoped>
    .nav-bar {
        height: 50px;
        text-align: left;
        padding: 0;;
        /* background-image: url("@/assets/header-icon.png"); */
        background-size: 50px;
        background-repeat: no-repeat;
        background-position-x: center;
        background-color: #302b3795;
        backdrop-filter: blur(10px);
    }

    #nav-content {
        padding: 10px 0;
    }

    #nav-element {
        padding: 0 15px;
        margin: 0 15px;
        text-decoration: none;
        color: #FBFFF1;
        font-size: 20px;
        transition: opacity 0.2s ease-in-out;
        cursor: pointer;
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
        border-bottom: 2px solid #FBFFF1;
        color: #FBFFF1;
    }
</style>