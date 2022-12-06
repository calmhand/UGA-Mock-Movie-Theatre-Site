<template>
  <div id="manage-movies-container">
    <div id="movie-opts">
      <a data-bs-toggle="modal" data-bs-target="#add-movie-modal"><i class="fa-solid fa-plus"></i></a>
      <a @click="getMovies()"><i class="fa-solid fa-arrows-rotate"></i></a>
    </div>

    <div id="movie-console">
      <div id="manage-movie-table">
        <div id="movie-obj" v-for="movie in movies" :key="movie.movieID">

          <div id="row">
            <div id="col">
              <h4>{{movie.movieID}}</h4>
              <label>Movie ID</label>
            </div>

            <div id="col">
              <h4>{{movie.title}}</h4>
              <label>Title</label>
            </div>

            <div id="col">
              <h4>{{movie.category}}</h4>
              <label>Genre</label>
            </div>

            <div id="col">
              <h4>{{movie.rating}}</h4>
              <label>Rating</label>
            </div>

            <div id="col">
              <h4>{{movie.releaseDate}}</h4>
              <label>Release Date</label>
            </div>
          </div>
          <hr>
          <div id="row">
            <div id="col">
              <h4>{{movie.director}}</h4>
              <label>Director</label>
            </div>
          </div>
          <hr>
          <div id="row">
            <div id="col">
              <div id="col">
                <h4>{{movie.cast}}</h4>
                <label>Cast</label>
              </div>
            </div>
          </div>
          <hr>
          <div id="row">
            <div id="col">
              <h4>Synopsis</h4>
              <small>{{movie.synopsis}}</small>
            </div>
          </div>
          <hr>
          <div id="row">
            Options:
            <button @click="editMovie(movie.movieID)">Edit</button>
          </div>
        </div>
      </div>
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

#manage-movie-table {
  background-color: #090b9b33;
  border: 4px solid #FBFFF1;
  border-radius: 10px;
  padding: 20px;
  height: 80vh;
  width: 100%;
  overflow-y: scroll;
}

#movie-obj {
  border-bottom: solid 2px #FBFFF1;
  padding: 20px;
}

#row {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
}

#col {
    display: flex;
    flex-direction: column;
    margin: 0 15px;
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