<template>
  <div>
    <button @click="beginTicketing()" id="show-btn" type="button">
      <span>{{showRoom}}</span>
      <span>{{showDate}}</span>
      <span>@ {{timeSlot}}</span>
    </button>
  </div>
</template>

<script>
export default {
    name: "ShowtimeButton",
    props: {
      "movieTitle" : String,
      "timeSlot" : String,
      "showDate" : String,
      "showRoom" : String,
      "showID" : Number,
    },
    methods: {
      checkAuth() {
        if (this.$store.state.site.currentState == 0) {
          document.querySelector("#alert-movie-login-btn").click()
          return false
        } else {
          return true
        }
      },
      beginTicketing() {
        const saveShow = async () => {
          await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/show-details/" + this.showID, {
            method: "GET",
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            }
          })
          .then((res) => res.json())
          .then((s) => {
            this.$store.commit('checkout/PARSE_SHOW', s)
            this.$store.commit('checkout/SET_MOVIE_NAME', this.movieTitle)

            console.log("(showtimebooking)get show: " + JSON.stringify(s) + this.$store.state.checkout.movieTitle);
          })
          .catch((err) => {console.log("err: " + err);})
        }

        if (this.checkAuth()) {
          this.$router.push({path: "/checkout/"+ this.showID +"/tickets"})
          saveShow()
        } else {
          this.$router.push({path: "/login"})
        }
      }
    },
}
</script>

<style scoped>
  #show-btn {
    text-align: left;
  }

  span {
    display: block;
    font-size: 0.9em;
  }

  button {
      border: solid #3C3744 10px;
      border-radius: 20px;
      background-color: #3C3744;
      color: white;
      margin: 5px 10px;
      transition: opacity 0.3s ease-in-out;
  }

  button:hover {
    opacity: 0.7;
  }
</style>