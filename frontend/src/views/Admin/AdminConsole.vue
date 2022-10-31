<template>
    <div id="admin-console-container">
        <h1>Admin Console</h1>

        <div class="admin-btn-group">
            <button @click="showHome()">Summary</button>
            <button @click="showManageMovies()">Manage Movies</button>
            <button @click="showManagePromotions()">Manage Promotions</button>
            <button @click="showManageUsers()">Manage Users</button>
        </div>
        <div class="admin-components">
            <AdminHome v-if="showComponentAdminHome" />
            <ManageMovies v-if="showComponentManageMovies" />
            <ManagePromotions v-if="showComponentManagePromotions" />
            <ManageUsers v-if="showComponentManageUsers" />
        </div>
    </div>
</template>
  
<script>
import AdminHome from '@/components/AdminComponents/AdminHome.vue';
import ManageMovies from '@/components/AdminComponents/ManageMovies.vue';
import ManagePromotions from '@/components/AdminComponents/ManagePromotions.vue';
import ManageUsers from '@/components/AdminComponents/ManageUsers.vue';
export default {
    name: "AdminConsole",
    components: { AdminHome, ManageMovies, ManagePromotions, ManageUsers },
    methods: {
        hide(){
            this.showComponentAdminHome = false,
            this.showComponentManageMovies = false,
            this.showComponentManagePromotions = false,
            this.showComponentManageUsers = false
        },
        showHome() {
            this.hide(),
            this.showComponentAdminHome = true
        },
        showManageMovies() {
            this.hide(),
            this.showComponentManageMovies = true
        },
        showManagePromotions() {
            this.hide(),
            this.showComponentManagePromotions = true
        },
        showManageUsers() {
            this.hide(),
            this.showComponentManageUsers = true
        },
    },
    data() {
        return{
            showComponentAdminHome: true,
            showComponentManageMovies :false,
            showComponentManagePromotions :false,
            showComponentManageUsers :false
        }
        
    },
    beforeMount() {
        if (this.$store.state.currentState == 0 || this.$store.state.currentState == 1) {
            alert("Must be logged in.")
            this.$router.push({path: "/login"})
        }
    },
}
</script>
  
<style scoped>
ManageMovies {
    display: none;
}
.admin-components{
margin: 2% 10% 10% 10%;
}

#admin-console-container {
    min-height: 100vh;
    width: 100vW;
}

div.admin-btn-group {
    align-content: center;
    width: 100%;
}

.admin-btn-group button {
    background-color: black;
    color: #b3b3b3;
    padding: 10px 24px;
    cursor: pointer;

    /*float: right;  Float the buttons side by side */
}

.admin-btn-group button:hover {
    background-color: white;
}

.admin-btn-group button:not(:last-child) {
    border-right: none;
    /* Prevent double borders */
}
</style>