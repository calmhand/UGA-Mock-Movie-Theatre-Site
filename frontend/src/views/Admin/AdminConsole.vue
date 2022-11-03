<template>
    <div id="admin-console-container">
        <div id="console-display">
            <div id="admin-btns">
                <a @click="switchView(0)" style="border-bottom: solid 2px #3088BE; opacity: 1;">Summary</a>
                <a @click="switchView(1)">Manage Movies</a>
                <a @click="switchView(2)">Manage Showtimes</a>
                <a @click="switchView(3)">Manage Promotions</a>
                <!-- TODO: Won't implement unless told to do otherwise. -->
                <!-- <a @click="switchView(4)">Manage Users</a> -->
            </div>
            <div id="console-view">
                <AdminSummary />
                <ManageMovies />
                <ManageShowtimes />
                <ManagePromotions />
                <ManageUsers />
            </div>
        </div>
    </div>
</template>
  
<script>
import AdminSummary from '@/components/AdminComponents/AdminSummary.vue';
import ManageMovies from '@/components/AdminComponents/ManageMovies.vue';
import ManageShowtimes from '@/components/AdminComponents/ManageShowtimes.vue'
import ManagePromotions from '@/components/AdminComponents/ManagePromotions.vue';
import ManageUsers from '@/components/AdminComponents/ManageUsers.vue';

export default {
    name: "AdminConsole",
    components: { AdminSummary, ManageMovies, ManageShowtimes, ManagePromotions, ManageUsers },
    methods: {
        switchView(id) {
            let buttons = document.querySelector("#admin-btns").children
            const clearBtnStyles = () => {
                for (let i = 0; i < buttons.length; i++) {
                    let btn = buttons[i].style
                    btn.opacity = "0.5"
                    btn.border = "none"
                }
            }

            const styleBtn = () => {
                let b = buttons[id].style
                b.borderBottom = "solid 2px #3088BE"
                b.opacity = "1"
            }
            
            let windows = document.querySelector("#console-view").children
            const hideWindows = () => {
                for (let i = 0; i < windows.length; i++) {
                    let window = windows[i].style
                    window.display = "none"
                }
            }

            const showWindow = () => {
                let w = windows[id].style
                w.display = "flex"
            }

            clearBtnStyles()
            styleBtn()
            hideWindows()
            showWindow()
        },
    },
    beforeMount() {
        if (this.$store.state.currentState == 0 || this.$store.state.currentState == 1) {
            alert("Must be logged in as admin.")
            this.$router.push({path: "/login"})
        }
    },
}
</script>
  
<style scoped>

#admin-console-container {
    height: 100vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

#console-display {
    display: flex;
    flex-direction: column;
    justify-content: center;

    height: 90%;
    width: 90%;

    background-color: rgba(0, 0, 0, 0.5);
    border-radius: 10px;
}

#admin-btns {
    display: flex;
    flex-direction: row;
    justify-content: center;
    font-size: 1.15em;
}

a {
    text-align: left;
    margin: 15px 20px;
    opacity: 0.5;
    color: #FBFFF1;
    transition: opacity 0.3s ease-in-out;
}

a:hover {
    opacity: 0.5;
    cursor: pointer;
}

#console-view {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
}
</style>