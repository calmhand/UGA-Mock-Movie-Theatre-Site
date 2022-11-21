<template>
    <div id="shows-container">
        <div id="show-display-section">
            <h2 style="display: inline;">Featured Movies</h2>
            <a @click="selectWindow(`upcoming-btn`, `upcoming-container`)" id="upcoming-btn" style="border-bottom: solid 2px #3088BE; opacity: 1;">Upcoming</a>
            <a @click="selectWindow(`playing-btn`, `playing-container`)" id="playing-btn">Now Playing</a>
            <hr/>
        </div>
        <div id="upcoming-container">
            <UpcomingShows />
        </div>
        
        <div id="playing-container" style="display: none;">
            <CurrentShows />
        </div>
    </div>
</template>

<script>
import UpcomingShows from '@/components/HomeComponents/UpcomingShows.vue'
import CurrentShows from '@/components/HomeComponents/CurrentShows.vue'

export default {
    name: "ShowsContainer",
    components: {UpcomingShows, CurrentShows},
    methods: {
        selectWindow(btnID, windowID) {
            const clearStyles = () => {
                let upcoming = document.querySelector("#upcoming-btn").style
                let playing = document.querySelector("#playing-btn").style
                upcoming.borderBottom = "none"
                upcoming.color = "#FBFFF1"
                upcoming.opacity = "0.5"
                playing.borderBottom = "none"
                playing.color = "#FBFFF1"
                playing.opacity = "0.5"

                let upcomingWindow = document.querySelector("#upcoming-container").style
                let playingWindow = document.querySelector("#playing-container").style
                upcomingWindow.display = "none"
                playingWindow.display = "none"
            }

            clearStyles()
            let btn = document.querySelector("#" + btnID)
            let window = document.querySelector("#" + windowID)
            btn.style.borderBottom = "solid 2px #3088BE"
            btn.style.color = "#FBFFF1"
            btn.style.opacity = "1"
            window.style.display = "block"
        }
    }
}
</script>

<style scoped>
    #shows-container {
        display: flex;
        flex-direction: column;
        align-content: center;
        align-items: center;
        justify-content: center;
        background-image: linear-gradient(180deg, black 45%, transparent 100%);
        padding: 50px;
    }

    #show-display-section {
        width: 100%;
        font-family: bold-robo;
        font-size: 1.3em;
        text-align: left;
    }

    #playing-container, #upcoming-container {
        margin: 20px;
        text-align: center;
    }
    
    a {
        float: right;
        margin: 0 10px;
        color: #FBFFF1;
        opacity: 0.5;
        transition: opacity 0.3s ease-in-out;
    }

    a:hover {
        cursor: pointer;
        opacity: 0.6;
    }

    hr {
        margin: 0;
        color: #FBFFF1;
    }
</style>