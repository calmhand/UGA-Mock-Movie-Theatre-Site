<template>
  <div id="seat-selector-container">

    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>Available</small>
      </li>
      <li>
        <div class="seat selected"></div>
        <small>Selected</small>
      </li>
      <li>
        <div class="seat sold"></div>
        <small>Sold</small>
      </li>
    </ul>

    <!-- TODO: Make seat container into component? -->
    <div class="container">

      <div class="screen"></div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>

      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
      </div>
      <div class="row">
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat sold"></div>
        <div class="seat"></div>
      </div>
    </div>
    <router-link to="/checkout/billing">Continue to checkout</router-link>
  </div>
</template>

<script>
export default {
    name: 'SelectSeats',
    mounted() {
        // adds listeners to each seat to show selection.
        document.querySelector('.container').addEventListener('click', (e) => {
            if (
                e.target.classList.contains("seat") &&
                !e.target.classList.contains("sold")
            ) {
                e.target.classList.toggle("selected");

            }
        })
    }
}
</script>

<style scoped>
    #seat-selector-container {
        height: 100vh;
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

    .container {
        perspective: 1000px;
        margin-bottom: 30px;
    }

    .screen {
        background-color: #fff;
        height: 120px;
        width: 35%;
        margin: 25px auto;
        transform: rotateX(-48deg);
        box-shadow: 0 3px 10px rgba(255, 255, 255, 0.7);
    }

    .row {
        display: flex;
        justify-content: center;
    }

    .seat {
        background-color: #444451;
        height: 26px;
        width: 32px;
        margin: 5px;
        font-size: 50px;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
    }
    
    .seat.selected {
        background-color: green;
    }

    .seat.sold {
        background-color: #fff;
    }

    .seat:nth-of-type(2) {
        margin-right: 18px;
    }

    .seat:nth-last-of-type(2) {
        margin-left: 18px;
    }

    .seat:not(.sold):hover {
        cursor: pointer;
        transform: scale(1.2);
    }

    .showcase .seat:not(.sold):hover {
        cursor: default;
        transform: scale(1);
    }
</style>