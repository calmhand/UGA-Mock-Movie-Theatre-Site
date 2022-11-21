<template>
  <div id="card-info-container">
    <div id="row">
        <div id="col">
            <label>{{card}}</label>
            <label>Card</label>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "CardObject",
    props: {
        card : String,
        exp : String,
        billingAddress : Object,
    }
}
</script>

<style scoped>
    #card-info-container {
        display: flex;
        flex-direction: column;
    }

    #row {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 15px;
    }

    label {
      font-size: 20px;
      padding-right: 10px;
      color: #FBFFF1;
    }
</style>