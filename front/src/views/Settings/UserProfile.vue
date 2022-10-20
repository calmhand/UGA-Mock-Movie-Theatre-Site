<template>
  <div class="profile_page_container">
    <div class="profile_container">
        Username: lorem <br>
        Email: Ipsum <br>
        Id: {{userId}}<br>
        Address: 104 Caldwell Hall, Athens, GA, 30602<br>
        <button id="orders-button" @click="displayOrders()">Orders</button><br>
        <button>Change Password</button>
        <button>Change Email</button><br>
        <input type="checkbox" checked> Allow Promotions
    </div>
  </div>
</template>

<script>
export default {
    name: "UserProfile",
    props: ['userId', 'email', 'username', 'address'],
    methods: {
        displayOrders() {
            this.$router.push({name: 'UserOrders', params: {userId: this.userId}})
        }
    }

}
</script>

<style scoped>
    .profile_page_container {
        height: 100vh;
    }

    #orders-button {

    }
</style>