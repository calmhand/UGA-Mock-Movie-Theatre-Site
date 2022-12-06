<template>
    <div id="add-movie-modal" class="modal fade" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Movie</h5>
                </div>

                <div class="modal-body"> 
                    <form id="add-movie-form">
                        <div id="row">
                            <div id="col">
                                <input id="movie-title" type="text">
                                <label>Movie Name</label>
                            </div>

                            <div id="col">
                                <input id="movie-release-input" type="date">
                                <label>Release Date</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <select id="genre-selector">
                                    <option disabled value selected>Select Genre</option>
                                    <option value="ACTION">Action</option>
                                    <option value="ADVENTURE">Adventure</option>
                                    <option value="DRAMA">Drama</option>
                                    <option value="CRIME">Crime</option>
                                    <option value="ROMANCE">Romance</option>
                                    <option value="SCIENCE_FICTION">Sci-Fi</option>
                                    <option value="COMEDY">Comedy</option>
                                    <option value="THRILLER">Thriller</option>
                                    <option value="HORROR">Horror</option>
                                    <option value="OTHER">Other</option>
                                </select>
                                <label>Genre</label>
                            </div>

                            <div id="col">
                                <select id="rating-selector" name="dropdownRating">
                                    <option disabled value selected>Select Rating</option>
                                    <option value="G">G</option>
                                    <option value="PG">PG</option>
                                    <option value="PG13">PG-13</option>
                                    <option value="R">R</option>
                                </select>
                                <label>Rating</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="movie-cast-input" type="text">
                                <label>Cast</label>
                            </div>

                            <div id="col">
                                <input id="movie-director-input" type="text">
                                <label>Director</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="movie-producer-input" type="text">
                                <label>Executive Producer</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="movie-trailer-url-input" type="text">
                                <label>Trailer URL</label>
                            </div>

                            <div id="col">
                                <input id="movie-poster-url-input" type="text">
                                <label>Poster URL</label>
                            </div>
                        </div>

                        <div>
                            <div id="description-col">
                                <textarea id="add-movie-description" name="add-movie-description"></textarea>
                                <label for="add-movie-description">Description</label>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button id="close-add-movie-modal" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button @click="addMovie()" type="button" class="btn btn-primary">Add Movie</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddMovie",
    methods: {
        addMovie() {
            let title = document.querySelector("#movie-title").value
            let category = document.querySelector("#genre-selector").value
            let rating = document.querySelector("#rating-selector").value
            let release = document.querySelector("#movie-release-input").value
            let director = document.querySelector("#movie-director-input").value
            let producer = document.querySelector("#movie-producer-input").value
            let cast = document.querySelector("#movie-cast-input").value
            let synopsis = document.querySelector("#add-movie-description").value
            let posterURL = document.querySelector("#movie-poster-url-input").value
            let trailerURL = document.querySelector("#movie-trailer-url-input").value

            let moviePayload = {
                "title" : title,
                "category" : category,
                "rating" : rating,
                "director" : director,
                "producer" : producer,
                "cast" : cast,
                "releaseDate" : release,
                "synopsis" : synopsis,
                "posterURL" : posterURL,
                "trailerURL" : trailerURL
            }

            let postFilm = async () => {
                await fetch("http://127.0.0.1:8084/api/test/admin/manage-movies/addmovie", {
                    method: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(moviePayload),
                })
                .then((res) => res.json())
                .then((s) => {
                    console.log("movie added: " + JSON.stringify(s));
                    document.getElementById("close-add-movie-modal").click()
                    document.getElementById("add-movie-form").reset();
                })
                .catch((err) => {console.log("err: " + err);})
            }
            postFilm()
        }
    },
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

    #description-col {
        display: flex;
        flex-direction: column;
        justify-content: center;
        margin: 10px 15px;
    }

    textarea {
        border: none;
        background-color: rgba(0, 0, 0, 0.391);
        border-bottom: solid 4px #FBFFF1;
        color: white;
        font-size: 12px;
        resize: none; 
        width: 100%;
        height: 110px;
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