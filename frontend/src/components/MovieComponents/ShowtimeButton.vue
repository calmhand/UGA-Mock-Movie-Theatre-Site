<template>
  <div>
    <button type="button">{{showRoom}} : {{showDate}} : {{timeSlot}}</button>
  </div>
</template>

<script>
export default {
    name: "ShowtimeButton",
    props: ['timeSlot', 'showDate', 'showRoom']
}
</script>

<style scoped>
    button {
        border: solid black 10px;
        border-radius: 20px;
        background-color: black;
        color: white;
        margin: 5px 10px;
    }
</style>