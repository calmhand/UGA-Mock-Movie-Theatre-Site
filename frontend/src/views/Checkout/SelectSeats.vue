<template>
  <div id="seat-selector-container">
    <div class="seating-container">
      <ul class="showcase">
        <li>
          <div class="unused-seat"></div>
          <h4>Available</h4>
        </li>

        <li>
          <div class="unused-selected"></div>
          <h4>Selected</h4>
        </li>

        <li>
          <div class="seat unused-sold"></div>
          <h4>Sold</h4>
        </li>
      </ul>
      <div class="screen"></div>
      <MovieSeating :showId="showId" />
    </div>
  </div>
</template>

<script>
import MovieSeating from '@/components/CheckoutComponents/MovieSeating.vue'

export default {
    name: 'SelectSeats',
    props: {
      showId : String,
    },
    data() {
      return {

      }
    },
    components: {MovieSeating},
    methods: {

    },
    mounted() {
      if (this.$store.state.site.currentState == 0) {
        document.querySelector("#alert-site-state-btn").click()
        this.$router.push({path: "/login"})
      }
    }
}
</script>

<style scoped>
  #seat-selector-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.512);
    /* height: 100vh; */
    padding: 50px;
  }

  .showcase {
    background: rgba(0, 0, 0, 0.1);
    padding: 5px 10px;
    border-radius: 5px;
    color: rgb(0, 0, 0);
    list-style-type: none;
    display: flex;
    justify-content: center;
  }

  .showcase li {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0 10px;
  }

  .showcase li small {
    margin-left: 2px;
  }

  .seating-container {
    perspective: 1000px;
  }

  .screen {
    background-color: #fff;
    height: 120px;
    width: 50vw;
    margin: 25px auto;
    transform: rotateX(-40deg);
    box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
  }

  .unused-seat, .unused-selected, .unused-sold {
    background-color: #ffffff;
    height: 26px;
    width: 32px;
    margin: 5px;
    font-size: 50px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
  }
  
  .unused-selected {
    background-color: rgb(49, 56, 253);
  }

  .unused-sold {
    background-color: #3C3744;
  }

  h4 {
    color: #FBFFF1;
    margin: 0;
  }
</style>