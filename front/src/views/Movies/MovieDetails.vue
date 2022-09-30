<template>
  <div id="movie-details-container">
    <img src="@/assets/temp_assets/pearl-poster.jpg">
    <section id="movie-info">
      <h1>Pearl (2022)</h1>
      <h3>Director: Ti West</h3>
      <h5>Actors: David Corenswet; Mia Goth; Emma Jenkins-Purro</h5>
      <p>
        Trapped on her family's isolated farm, Pearl must tend to her ailing father 
        under the bitter and overbearing watch of her devout mother. Lusting for a 
        glamorous life like she's seen in the movies, Pearl finds her ambitions, 
        temptations, and repressions all colliding in this origin story of X's 
        iconic villain.
      </p>
    </section>
    <section id="ticket-selector-container">
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

          <!-- TODO: Turn into component? -->
          <h1>Showtimes</h1>
          <div style="display: flex; flex-wrap:wrap; justify-content: center;">
            <router-link to="/checkout/seating"><ShowtimeButton id="showtime-button" :time="`10:00`"/></router-link>
            <ShowtimeButton :time="`10:30`"/>
            <ShowtimeButton :time="`11:00`"/>
            <ShowtimeButton :time="`11:30`"/>
            <ShowtimeButton :time="`12:00`"/>
          </div>
        </form>
      </div>
    </section>
  </div>
</template>

<script>
import ShowtimeButton from '@/components/MovieComponents/ShowtimeButton.vue';
export default {
    name: "MovieDetails",
    props: ["movieId"],
    components: {ShowtimeButton}
}
</script>

<style scoped>
  #movie-details-container {
    height: 100vh;
    padding: 25px;
    display: flex;
    flex-direction: row;
    justify-content: center;
  }

  #movie-info {
    margin: 0 20px;
    width: 575px;
  }

  #ticket-selectors {
    border: solid black 1px;
    height: 550px;
    width: 350px;
  }

  #ticket-input {
    width: 45px;
  }

  #showtime-button {
    animation: highlight 1s infinite; /* TODO: Delete after demo*/
  }

  p {
    font-size: 35px;
  }

  img {
    border: solid 10px black;
    height: 550px;
    width: 350px;
  }
</style>