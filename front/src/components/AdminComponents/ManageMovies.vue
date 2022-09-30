<template>
  <div class="manage-movies-container">
    <div id="allmovies-container">
      <h1>Movies</h1>
      <table>
        <tr>
          <th>Movie name</th>
          <th>Cast</th>
          <th>Genre</th>
          <th>Release Date</th>
          <th>Options</th>
        </tr>
        <tr>
          <td>Top Gun</td>
          <td>Tom cruise, Monica Barbaro</td>
          <td>Action</td>
          <td>09/20/2022</td>
          <td>
            <button>View</button>
            <button>Edit</button>
            <button>Delete</button>
          </td>
        </tr>
        <tr>
          <td>Bullet Train</td>
          <td>Brad Pit, Joe King</td>
          <td>Thriller</td>
          <td>09/23/2022</td>
          <td>
            <button>View</button>
            <button>Edit</button>
            <button>Delete</button>
          </td>
        </tr>
      </table>
    </div>
    <div id="addmovie-container">
      <button @click="openAddMovieForm()">Add Movie</button>
      <form id="add-movie-form">

        <div class="labels">
          <label for="movie">Movie Name</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="movie">
        </div>

        <div class="labels">
          <label for="cast">Cast</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="cast">
        </div>

        <div class="labels">
          <label for="dropdownGenre">Genre</label>
        </div>
        <div class="input-tab">
          <select id="dropdown" name="dropdownGenre">
            <option disabled value selected>Select a Genre</option>
            <option value="Action">Action</option>
            <option value="Comedy">Comedy</option>
            <option value="Thriller">Thriller</option>
            <option value="Horror">Horror</option>
            <option value="Other">Other</option>
          </select>
        </div>

        <div class="labels">
          <label for="director">Director</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="director">
        </div>

        <div class="labels">
          <label for="producer">Producer</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="producer">
        </div>

        <div class="labels">
          <label for="synopsis">Synopsis</label>
        </div>
        <div class="input-tab">
          <input class="input-field" id="synopsis" type="text" name="synopsis">
        </div>

        <div class="labels">
          <label for="trailer">Trailer URL</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="trailer">
        </div>

        <div class="labels">
          <label for="dropdownRating">Movie Rating</label>
        </div>
        <div class="input-tab">
          <select id="dropdown" name="dropdownRating">
            <option disabled value selected>Select Rating</option>
            <option value="g">G</option>
            <option value="pg">PG</option>
            <option value="pg13">PG-13</option>
            <option value="r">R</option>
          </select>
        </div>

        <div class="submission">
          <button type="submit" @click="saveMovie()">Save</button>
          <button @click="closeAddMovieForm()">Cancel</button>
        </div>

      </form>
    </div>

    <div id="allshows-container">
      <h1>Shows</h1>
      <table>
        <tr>
          <th>Movie name</th>
          <th>Hall</th>
          <th>price</th>
          <th>Booking Fee</th>
          <th>Show Date</th>
          <th>Show Time</th>
          <th>Options</th>
        </tr>
        <tr>
          <td>Top Gun</td>
          <td>3</td>
          <td>$15</td>
          <td>2%</td>
          <td>09/30/2022</td>
          <td>9:30 AM</td>
          <td><button>Edit</button>
            <button>Delete</button>
          </td>
        </tr>
        <tr>
          <td>Top Gun</td>
          <td>1</td>
          <td>$18</td>
          <td>2%</td>
          <td>09/30/2022</td>
          <td>4:30 PM</td>
          <td><button>Edit</button>
            <button>Delete</button>
          </td>
        </tr>
      </table>
    </div>
    <div id="addshow-container">
      <button @click="openAddShowForm()">Add Show</button>
      <form id="add-show-form">
        <div class="labels">
          <label for="dropdownMovieName">Movie Name</label>
        </div>
        <div class="input-tab">
          <select id="dropdown" name="dropdownMovieName">
            <option disabled value selected>Select a Movie</option>
            <option value="Top Gun">Top Gun</option>
            <option value="Bullet Train">Bullet Train</option>
          </select>
        </div>

        <div class="labels">
          <label for="hall">Hall</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="number" name="hall">
        </div>

        <div class="labels">
          <label for="price">price</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="number" name="price">
        </div>

        <div class="labels">
          <label for="bookingFee">Booking Fee</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="number" name="bookingFee">
        </div>

        <div class="labels">
          <label>Date</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="date">
        </div>

        <div class="labels">
          <label>Time</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="time">
        </div>
        <div class="submission">
          <button type="submit" @click="saveshow()">Save</button>
          <button @click="closeAddShowForm()">Cancel</button>
        </div>
      </form>

    </div>
  </div>
</template>

<script>
export default {
  name: "ManageMovies",
  props: [''],
  methods: {
    openAddMovieForm() {
      document.getElementById("add-movie-form").style.display = "block";
    },
    closeAddMovieForm() {
      document.getElementById("add-movie-form").style.display = "none";
      //clear form
    },
    saveMovie(){
      document.getElementById("add-movie-form").style.display = "none";
      //do something
    },
    openAddShowForm() {
      document.getElementById("add-show-form").style.display = "block";
    },
    closeAddShowForm() {
      document.getElementById("add-show-form").style.display = "none";
      //clear form
    },
    saveShow(){
      document.getElementById("add-show-form").style.display = "none";
      //do something
    },
    loadMovies() {
      // api to call all movies and load the table
    },
    loadshows() {
      // api to call all shows and load the table
    },

  }
}

</script>

<style scoped>
#add-movie-form {
  margin: 0 auto;
  width: 100%;
  padding: 10px;
  display: none;
}

#add-show-form {
  margin: 0 auto;
  width: 100%;
  padding: 10px;
  display: none;
}

#addmovie-container {
  width: 100%;
}

.labels {
  display: inline-block;
  text-align: right;
  width: 40%;
  vertical-align: top;
  margin-top: 20px;
}

.input-tab {
  display: inline-block;
  text-align: left;
  width: 50%;
  margin-left: 10px;
}

.input-field {
  display: inline-block;
  width: 50%;
  padding: 5px;
  margin: 18px 0 0 10px;
  border: 1px solid #e67e22;
  border-radius: 4px;
  font-family: inherit;
  font-size: 15px;
  font-weight: bold;
}

#dropdown {
  width: 50%;
  padding: 5px;
  margin: 18px 0 0px 10px;
  border: 1px solid #e67e22;
  border-radius: 3px;
  font-family: inherit;
  font-size: 15px;
}

#synopsis{
  height: 100px;
}

button{
  margin: 5px;
  background-color: #e67e22;
  border-radius: 4px;
  color: white;
  font-size: 1em;
  font-weight: bold;
  font-family: inherit;
  padding: 10px 15px;
  border: 1px solid;
}

.submission{
  margin: 10px 0px 0px 60px;
}

button:hover {
  background-color: #bf6516;
}

h1 {
  text-align: left;
  font-size: 25px;
}

table {
  font-family: arial, sans-serif;
  color: black;
  border-collapse: collapse;
  width: 100%;
}

td,
th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr {
  background-color: white;
}
</style>