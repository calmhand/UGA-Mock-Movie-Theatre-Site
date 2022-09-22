<template>
  <div class="profile_page_container">
    <div class="profile_container">
        Username: lorem <br>
        Email: Ipsum <br>
        Id: {{userId}}<br>
        <button @click="displayOrders()">Orders</button><br>
        <button>Change Password</button>
        <button>Change Email</button><br>
        <input type="checkbox" checked> Allow Promotions
    </div>
  </div>
</template>

<script>
export default {
    name: "UserProfile",
    props: ['userId'],
    methods: {
        displayOrders() {
            this.$router.push({name: 'UserOrders', params: {userId: this.userId}})
        }
    }

}
</script>

<style scoped>
    .profile_page_container {
        background-color: black;
        height: 100%;
    }
</style>