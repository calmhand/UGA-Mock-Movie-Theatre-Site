<template>
    <div id="manage-shows-container">
        <div id="show-opts">
          <select id="select-movie-for-shows" name="" style="text-align: left;">
              <option disabled value selected>Select a Movie</option>
              <option v-for="movie in movies" :key="movie.movieID" :value="movie.movieID">
                  {{movie.title}}
              </option>
          </select>
          <a @click="this.$store.commit(`movie/GET_ALL_MOVIES`)" data-bs-toggle="modal" data-bs-target="#add-show-modal"><i class="fa-solid fa-plus"></i></a>
          <a @click="getShowtimes()"><i class="fa-solid fa-arrows-rotate"></i></a>
          <!-- TODO: Implement search for showtimes? -->
          <a><i class="fa-solid fa-magnifying-glass"></i></a>
        </div>
        <div id="showtime-console">
            <table id="manage-shows-table">
                <tr>
                    <th>Movie ID</th>
                    <th>Show ID</th>
                    <th>Room</th>
                    <th>Show Date</th>
                    <th>Show Time</th>
                    <th>Options</th>
                </tr>

                <tr v-for="show in shows" :key="show.showID">
                  <td>{{show.movieID}}</td>
                  <td>{{show.showID}}</td>
                  <td>{{show.showRoom}}</td>
                  <td>{{show.showDate}}</td>
                  <td>{{show.showTimeSlot}}</td>
                  <td>
                      <button>Edit</button>
                      <button>Delete</button>
                  </td>
                </tr>
                
            </table>
        </div>
        <AddShowtime />
    </div>
</template>

<script>
import AddShowtime from '@/components/AdminComponents/AddShowtime.vue'
export default {
    name: "ManageShowtimes",
    components: {AddShowtime,},
    data() {
      return {
        movies : this.$store.state.movie.allMovies,
        shows : []
      }
    },
    methods: {
      getShowtimes() {
        let getShows = async () => {
          await fetch("http://127.0.0.1:8084/api/test/admin/manage-shows/", {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
          })
          .then((res) => res.json())
          .then((s) => {
            this.shows = s.shows
            console.log("Showtimes successfully retrieved." + JSON.stringify(s));
          })
          .catch((err) => {console.log("Err: " + err);})
        }
        getShows(parseInt(document.querySelector("#select-movie-for-shows").value))
      }
    },
    mounted() {
      // this.getShowtime()
    }
}
</script>

<style scoped>
#manage-shows-container {
    display: none;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

#showtime-console {
    width: 100%;
}

#show-opts {
  width: 100%;
  text-align: right;
}

#manage-shows-table {
    background-color: #090b9b33;
    border: 1px solid #FBFFF1;
    margin: 10px;
    display: block;
    height: 400px;
    width: 100%;
    overflow-y:scroll;
}

td, th {
  border: 1px solid #FBFFF1;
  text-align: left;
  padding: 8px;
}

button {
  width: 100px;
  height: 45px;
  margin: 0 10px;
  border: solid 4px #FBFFF1;
  border-radius: 10px;
  text-align: center;
  transition: opacity 0.2s ease-in-out;
}

button:hover {
  opacity: 0.7;
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

i {
  font-size: 20px;
  margin: 0 10px;
  color: #FBFFF1;
}

select {
    width: 150px;
    height: 50px;
    color: #FBFFF1;
    background-color: transparent;
    border: none;
    /* border-bottom: solid 4px #FBFFF1; */
}
</style>