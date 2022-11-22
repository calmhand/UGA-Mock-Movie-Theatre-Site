<template>
  <div id="manage-movies-container">
    <div id="movie-opts">
      <a data-bs-toggle="modal" data-bs-target="#add-movie-modal"><i class="fa-solid fa-plus"></i></a>
      <a @click="getMovies()"><i class="fa-solid fa-arrows-rotate"></i></a>
      <!-- TODO: Implement search for movies? -->
      <a><i class="fa-solid fa-magnifying-glass"></i></a>
    </div>

    <div id="movie-console">
      <table id="manage-movie-table">
        <div id="movies-table-display">
          <tr>
            <th>ID</th>
            <th>Movie Name</th>
            <th>Rating</th>
            <th>Director</th>
            <th>Cast</th>
            <th>Synopsis</th>
            <th>Genre</th>
            <th>Release Date</th>
            <th>Options</th>
          </tr>

          <tr v-for="movie in movies" :key="movie.movieID">
            <td>{{movie.movieID}}</td>
            <td>{{movie.title}}</td>
            <td>{{movie.rating}}</td>
            <td>{{movie.director}}</td>
            <td>{{movie.cast}}</td>
            <td>{{movie.synopsis}}</td>
            <td>{{movie.category}}</td>
            <td>{{movie.releaseDate}}</td>
            <td>
              <button>Details</button>
              <button @click="editMovie(movie.movieID)">Edit</button>
              <button>Remove</button>
            </td>
          </tr>
        </div>

      </table>
    </div>
    <AddMovie />
  </div>
</template>

<script>
import AddMovie from '@/components/AdminComponents/AddMovie.vue'
export default {
  name: "ManageMovies",
  components: {AddMovie},
  data() {
    return {
      movies : [],
    }
  },
  methods: {
    getMovies() {
      let getFilms = async () => {
        await fetch("http://127.0.0.1:8084/api/test/admin/manage-movies", {
          method: "GET",
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
        })
        .then((res) => res.json())
        .then((s) => {
          // console.log("Movies succesfully retrieved." + JSON.stringify(s));
          this.movies = s.movies
        })
        .catch((err) => {console.log("Err: " + err);})
      }
      getFilms()
    },
  },
  mounted() {
    this.getMovies()
  }
}

</script>

<style scoped>
#manage-movies-container {
  display: none;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

#movie-opts {
  width: 100%;
  text-align: right;
}

#movie-console {
  width: 100%;
}

#manage-movie-table {
  background-color: #090b9b33;
  border: 1px solid #FBFFF1;
  margin: 10px;
}

#movies-table-display {
  display: block;
  height: 400px;
  width: 100%;
  overflow-y:scroll;
}

i {
  font-size: 20px;
  margin: 0 10px;
  color: #FBFFF1;
}

a {
  text-decoration: none;
  font-size: 20px;
  transition: opacity 0.2s ease-in-out;
  cursor: pointer;
}

a:hover {
  opacity: 0.7;
}

button {
  width: 80px;
  height: 45px;
  margin: 10px;
  border: solid 4px #FBFFF1;
  border-radius: 10px;
  text-align: center;
  transition: opacity 0.2s ease-in-out;
}

button:hover {
  opacity: 0.7;
}

td, th{
  border: 1px solid #FBFFF1;
  text-align: left;
  padding: 8px;
}
</style>