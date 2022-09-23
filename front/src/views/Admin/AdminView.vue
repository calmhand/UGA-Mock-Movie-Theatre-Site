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
    components: {ManageMovies}
}
</script>

<style scoped>
    #admin-view-container {
        height: 100vh;
    }
</style>