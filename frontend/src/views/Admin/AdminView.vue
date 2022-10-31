<template>
  <div id="admin-view-container">
    <!-- Create an example CRUD interface for movies and promotions. -->
    <!-- The admin view should show options to manage movies (including movie scheduling) and
        manage promotions. -->
    <ManageMovies />
  </div>
</template>

<script>
import ManageMovies from '@/components/AdminComponents/ManageMovies.vue'
export default {
    components: {ManageMovies},
    beforeMount() {
        if (this.$store.state.currentState == 0 || this.$store.state.currentState == 1) {
            alert("Must be logged in.")
            this.$router.push({path: "/login"})
        }
    }
}
</script>

<style scoped>
    #admin-view-container {
        height: 100vh;
    }
</style>