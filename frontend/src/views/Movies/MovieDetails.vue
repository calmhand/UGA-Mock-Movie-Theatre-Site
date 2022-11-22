<template>
  <div id="movie-details-container">

    <div id="title-poster-container">
      <h3>{{movieObj.title}}</h3>
      <img :src="movieObj.posterURL">
    </div>

    <section id="movie-info">
      <p>"{{movieObj.synopsis}}"</p>
      <h2>Genre: {{movieObj.category}}</h2>
      <h2>Rating: {{movieObj.rating}}</h2>
      <h2>Director: {{movieObj.director}}</h2>
      <h2>Actors: {{movieObj.cast}}</h2>
      <iframe :src="movieObj.trailerURL"></iframe>
    </section>

    <div id="tickets-shows-container">
      <div id="ticket-selectors">
        <!-- TODO: Turn into component? -->
        <form>
          <h1 style="margin: 0;">Tickets</h1>
          Child: $8.30<br>
          Adult: $11.47<br>
          Senior: $9.30
          <div style="display: flex; flex-wrap:wrap; justify-content: center;">
            <div style="margin: 10px">
              <label>Child</label><br>
              <input id="ticket-input" name="child-ticket" type="number" placeholder="0"><br>
            </div>

            <div style="margin: 10px">
              <label>Adult</label><br>
              <input id="ticket-input" name="adult-ticket" type="number" placeholder="3"><br>
            </div>

            <div style="margin: 10px">
              <label>Senior</label><br>
              <input id="ticket-input" name="senior-ticket" type="number" placeholder="0"><br>
            </div>
          </div>
        </form>
      </div>
      <h1>Showtimes</h1>
      <div id="showtime-container">
        <!-- <router-link to="/checkout/seating"><ShowtimeButton id="showtime-button" :time="`10:00`"/></router-link> -->

        <ShowtimeButton v-for="show in showtimes" :key="show.showID" 
          :timeSlot="show.showTimeSlot"
          :showDate="show.showDate"
          :showRoom="show.showRoom"
        />

      </div>
    </div>
  </div>
</template>

<script>
import ShowtimeButton from '@/components/MovieComponents/ShowtimeButton.vue';
export default {
    name: "MovieDetails",
    props: ["movieId", "movieTitle"],
    components: {ShowtimeButton},
    data() {
      return {
        movieObj : {},
        showtimes : []
      }
    },
    methods: {
      getMovieDetails() {
        let getFilmInfo = async () => {
          await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/movies-title/" + this.movieTitle, {
              method: "GET",
              headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
              },
          })
          .then((res) => res.json())
          .then((s) => {
            this.movieObj = s.movies[0]
          })
          .catch((err) => {console.log("Err: " + err);})
        }
        getFilmInfo()
      },
      getMovieShowings() {
        let getTimes = async () => {
          await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/movie/" + this.movieId + "/shows", {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
          })
          .then((res) => res.json())
          .then((s) => {
            this.showtimes = s.shows
            console.log("Shows: " + JSON.stringify(s));
          })
          .catch((err) => {console.log("Err: " + err);})
        }
        getTimes()
      }
    },
    mounted() {
      this.getMovieDetails()
      this.getMovieShowings()
    }
}
</script>

<style scoped>
  #movie-details-container {
    padding: 25px;
    display: flex;
    flex-direction: row;
    justify-content: center;
  }

  #title-poster-container {
    display: flex;
    flex-direction: column;
  }

  #movie-info {
    margin: 0 20px;
    width: 575px;
    text-align: left;
  }

  #ticket-selectors {
    /* height: 550px; */
    width: 350px;
  }

  #ticket-input {
    width: 45px;
  }

  #tickets-shows-container {
    display: flex;
    flex-direction: column;
    border: solid 1px white;
  }



  p {
    font-size: 35px;
  }

  img {
    border: solid 10px black;
    height: 550px;
    width: 350px;
  }

  iframe {
    width: 100%;
    height: 275px;
  }
</style>