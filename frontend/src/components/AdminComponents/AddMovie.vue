<template>
    <div id="add-movie-modal" class="modal" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Movie</h5>
                </div>

                <div class="modal-body"> 
                    <form>
                        <div id="row">
                            <div id="col">
                                <input type="text">
                                <label>Movie Name</label>
                            </div>

                            <div id="col">
                                <input type="text">
                                <label>Release Date</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <select>
                                    <option disabled value selected>Select Genre</option>
                                    <option value="Action">Action</option>
                                    <option value="Comedy">Comedy</option>
                                    <option value="Thriller">Thriller</option>
                                    <option value="Horror">Horror</option>
                                    <option value="Other">Other</option>
                                </select>
                                <label>Genre</label>
                            </div>

                            <div id="col">
                                <select id="dropdown" name="dropdownRating">
                                    <option disabled value selected>Select Rating</option>
                                    <option value="g">G</option>
                                    <option value="pg">PG</option>
                                    <option value="pg13">PG-13</option>
                                    <option value="r">R</option>
                                </select>
                                <label>Rating</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input type="text">
                                <label>Cast</label>
                            </div>

                            <div id="col">
                                <input type="text">
                                <label>Director</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input type="text">
                                <label>Executive Producer</label>
                            </div>

                            <div id="col">
                                <input type="text">
                                <label>Trailer URL</label>
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
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-primary">Add Movie</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddMovie",
}
</script>

<style scoped>
    #add-movie-modal {
        color: white;
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