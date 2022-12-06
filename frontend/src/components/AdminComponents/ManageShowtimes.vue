<template>
    <div id="manage-shows-container">
        <div id="show-opts">
          <a @click="this.$store.commit(`movie/GET_ALL_MOVIES`)" data-bs-toggle="modal" data-bs-target="#add-show-modal"><i class="fa-solid fa-plus"></i></a>
          <a @click="getShowtimes()"><i class="fa-solid fa-arrows-rotate"></i></a>
        </div>
        <div v-if="!shows.length == 0" id="showtime-console">
          <div id="manage-shows-table">
            <div id="show-obj" v-for="show in shows" :key="show.showID">
              <div id="row">
                <div id="col">
                  <h4>{{show.movieID}}</h4>
                  <label>Movie ID</label>
                </div>

                <div id="col">
                  <h4>{{show.showID}}</h4>
                  <label>Show ID</label>
                </div>

                <div id="col">
                  <h4>{{show.showRoom}}</h4>
                  <label>Theatre</label>
                </div>
              </div>
              <hr>
              <div id="row">
                <div id="col">
                  <h4>{{show.showDate}}</h4>
                  <label>Date</label>
                </div>

                <div id="col">
                  <h4>{{show.showTimeSlot}}</h4>
                  <label>Time</label>
                </div>
              </div>
            </div>              
          </div>
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
        getShows()
      },
    },
    mounted() {
      this.$store.commit(`movie/GET_ALL_MOVIES`)
      this.getShowtimes()
    }
}
</script>

<style scoped>
#manage-shows-container {
    display: none;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
}

#show-opts {
  width: 100%;
  text-align: right;
}

#manage-shows-table {
  background-color: #090b9b33;
  border: 4px solid #FBFFF1;
  border-radius: 10px;
  height: 85vh;
  width: 100%;
  padding: 50px;
  overflow-y: scroll;
}

#show-obj {
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  border-bottom: solid 2px #FBFFF1;
  padding: 25px;
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