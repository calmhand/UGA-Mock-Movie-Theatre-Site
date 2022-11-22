<template>
    <div id="add-show-modal" class="modal fade" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Showtime</h5>
                </div>

                <div class="modal-body"> 
                    <form id="add-showtime-form">
                        <div id="row">
                            <div id="col">
                                <select id="add-show-movie-dropdown" name="dropdownMovieName">
                                    <option disabled value selected>Select a Movie</option>
                                    <option v-for="movie in movies" :key="movie.movieID" :value="movie.movieID">
                                        {{movie.title}}
                                    </option>
                                </select>
                                <label>Movie Name</label>
                            </div>

                            <div id="col">
                                <select id="showroom-dropdown">
                                    <option disabled value selected>Select Room</option>
                                    <option value="MAX-RELAX">Max Relax</option>
                                    <option value="REAL-3D">Real 3D</option>
                                    <option value="SCREEN-PLAY">Screen Play</option>
                                    <option value="SCREEN-X">Screen X</option>
                                </select>
                                <label>Show Room</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="add-showtime-date" type="date">
                                <label>Show Date</label>
                            </div>

                            <div id="col">
                                <select id="showtime-dropdown">
                                    <option disabled value selected>Select Showtime</option>
                                    <option value="09:00">9:00 AM</option>
                                    <option value="13:00">1:00 PM</option>
                                    <option value="18:00">6:00 PM</option>
                                    <option value="22:00">10:00 PM</option>
                                </select>
                                <label>Show Time</label>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button id="close-add-shows-btn" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <!-- TODO: Implement AddShowtime Button. -->
                    <button @click="addShowTime()" type="button" class="btn btn-primary">Add Showtime</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddShowtime",
    data() {
        return {
            movies : []
        }
    },
    methods: {
        addShowTime() {
            let movID = parseInt(document.querySelector("#add-show-movie-dropdown").value)
            let showtime = document.querySelector("#showtime-dropdown").value
            let showDate = document.querySelector("#add-showtime-date").value
            let room = document.querySelector("#showroom-dropdown").value

            let showPayload = {
                "movieID" : movID,
                "showRoom" : room,
                "showDate" : showDate,
                "showTimeSlot" : showtime
            }
            console.log(JSON.stringify(showPayload));
            let addShow = async () => {
                await fetch("http://127.0.0.1:8084/api/test/admin/manage-shows/addshow", {
                    method: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(showPayload)
                })
                .then((res) => res.json())
                .then((s) => {
                    console.log("Showtime Added: " + JSON.stringify(s));

                    document.getElementById("close-add-shows-btn").click()
                    document.getElementById("add-showtime-form").reset()
                })
            }
            addShow()
        },
        async fetchMovies() {
            await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/home", {
                method: "GET",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            })
            .then((res) => res.json())
            .then((s) => {
                this.movies = s.currentMoviesList
            })
        },
    },
    mounted() {
        this.fetchMovies()
    }
}
</script>

<style scoped>
    #add-movie-modal {
        color: #FBFFF1;
    }
    
    .modal-content {
        background-color: #090b9bd7;
    }

    #row {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 15px;
    }

    form {
        width: 100%;
        text-align: left;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        align-content: center;
        overflow-y: auto;
    }

    label {
        font-size: 17px;
        padding-right: 10px;
        text-align: left;
    }

    input {
        height: 50px;
        background-color: transparent;
        font-size: 15px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: white;
        text-align: center;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 4px #FBFFF1;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
    }

    select {
        width: 150px;
        height: 50px;
        color: #FBFFF1;
        background-color: transparent;
        border: none;
        border-bottom: solid 4px #FBFFF1;
    }
</style>