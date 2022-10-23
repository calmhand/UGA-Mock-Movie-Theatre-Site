<template>
  <div class="profile_page_container">
    <div id="settings-container">
        <div id="settings-opt-container">
            <a href="" id="opt-btn">Personal Info</a>
            <a href="" id="opt-btn">Address</a>
            <a href="" id="opt-btn">Payment</a>
            <a href="" id="opt-btn">Orders</a>
            <a href="" id="opt-btn">Manage Promotions</a>
        </div>
        <div id="vertical-line"></div>
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
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
        border: solid 1px red;
    }

    #settings-container {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;

        height: 90%;
        width: 90%;

        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 10px;
    }

    #settings-opt-container {
        display: flex;
        flex-direction: column;
        width: 150px;
    }

    #vertical-line {
        height: 80%;
        margin: 0 35px;
        border-right: solid 1px #FBFFF1;
    }

    button {
        width: 120px;
        height: 35px;
        border: solid 4px #FBFFF1;
        border-radius: 10px;
        margin-top: 25px;
        text-align: center;
        transition: opacity 0.2s ease-in-out;
    }

    button:hover {
        opacity: 0.7;
    }

    #opt-btn {
        text-align: left;
        margin: 15px 0;
    }
</style>