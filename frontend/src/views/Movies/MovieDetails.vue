<template>
  <div id="movie-details-container">
    <div id="title-poster-container">
      <h1><strong>{{movieObj.title}}</strong></h1>
      <img :src="movieObj.posterURL">
    </div>

    <section id="movie-info">
      <div>
        <p><em>"{{movieObj.synopsis}}"</em></p>
        <button id="movie-details-trailer-btn" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#movieDetailsTrailerModal">
          <i class="fa-solid fa-play" style="font-size: 15px; opacity: 0.9;">&nbsp; Trailer</i>
        </button>
      </div>

      <div style="margin-top: 15%;">
        <h5>Genre: {{movieObj.category}}</h5>
        <h5>Rating: {{movieObj.rating}}</h5>
        <h5>Director: {{movieObj.director}}</h5>
        <h5>Actors: {{movieObj.cast}}</h5>
      </div>
    </section>

    <div id="shows-container" v-if="showtimes.length > 0">
      <h1>Showtimes</h1>
      <hr style="margin: 0; color: white;">
      <div id="showtime-container">
        <div id="showtime-buttons-window">
          <ShowtimeButton v-for="show in showtimes" :key="show.showID" 
            :timeSlot="show.showTimeSlot"
            :showDate="show.showDate"
            :showRoom="show.showRoom"
            :showID="show.showID"
            :movieTitle="movieObj.title"
          />
        </div>
      </div>
    </div>
    <div v-else>
        <h1>No available shows.</h1>
    </div>
    <MovieDetailsTrailer :url="movieObj.trailerURL"/>
  </div>
  <AlertModal :id="`alert-movie-login-modal`" :errorTitle="`Guest Error`" :message="`Please login or create an account to book a movie!`"/>
  <button id="alert-movie-login-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-movie-login-modal"></button>
</template>

<script>
import MovieDetailsTrailer from '@/components/MovieComponents/MovieDetailsTrailer.vue'
import ShowtimeButton from '@/components/MovieComponents/ShowtimeButton.vue';
import AlertModal from '@/components/AlertModal.vue'

export default {
    name: "MovieDetails",
    props: ["movieId", "movieTitle"],
    components: {MovieDetailsTrailer, ShowtimeButton, AlertModal},
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
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 25px;
    height: 100%;
  }

  #title-poster-container {
    display: flex;
    flex-direction: column;
    align-content: center;
    align-items: center;
    justify-content: center;
  }

  #movie-info {
    margin: 0 20px;
    width: 575px;
    text-align: left;
  }

  #ticket-selectors {
    width: 350px;
  }

  #ticket-input {
    width: 45px;
  }

  #shows-container {
    display: flex;
    flex-direction: column;
    flex-wrap: wrap;
    align-items: center;
    width: 20%;
    height: 500px;
  }

  #showtime-buttons-window {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
  }

  #movie-details-trailer-btn {
    background-color: rgba(0, 0, 0, 1); 
    border-color: rgba(0, 0, 0, 1);
    transition: opacity 0.3s ease-in-out;
  }

  #movie-details-trailer-btn:hover {
    opacity: 0.7;
  }

  p {
    font-size: 20px;
  }

  img {
    border: solid 10px black;
    height: 650px;
    width: 450px;
  }
</style>