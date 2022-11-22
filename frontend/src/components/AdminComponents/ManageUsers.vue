<template>
    <div id="manage-users-container">
        <div id="user-opts">
            <a data-bs-toggle="modal" data-bs-target="#add-user-modal"><i class="fa-solid fa-plus"></i></a>
            <a @click="getUsers()"><i class="fa-solid fa-arrows-rotate"></i></a>
            <!-- TODO: Implement search for movies? -->
            <a><i class="fa-solid fa-magnifying-glass"></i></a>
        </div>
        <div id="users-container">
            <table>
                <tr>
                    <th>ID</th>
                    <th>User name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Subscription Status</th>
                    <th>Account Type</th>
                    <th>Account Status</th>
                    <th>Options</th>
                </tr>

                <tr v-for="user in users" :key="user.userID">
                    <td>{{user.userID}}</td>
                    <td>{{user.firstName}} {{user.lastName}}</td>
                    <td>{{user.number}}</td>
                    <td>{{user.email}}</td>
                    <td>{{user.isSubscribed}}</td>
                    <td>{{user.userType}}</td>
                    <td>{{user.statusID}}</td>
                    <td>
                        <button @click="suspendAccount(user.userID)">Suspend</button>
                        <button @click="activateAccount(user.userID)" >Activate</button>
                    </td>
                </tr>
                
            </table>
        </div>
    </div>
</template>
  
<script>
export default {
    name: "ManageMovies",
    data() {
        return {
            users : []
        }
    },
    methods: {
        getUsers() {
            let getAccounts = async () => {
                await fetch("http://127.0.0.1:8084/api/test/admin/manage-users", {
                    method: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                // console.log("Users succesfully retrieved." + JSON.stringify(s));
                this.users = s.users
                })
                .catch((err) => {console.log("Err: " + err);})
            }
            getAccounts()
        },
        async suspendAccount(id) {
            await fetch("http://127.0.0.1:8084/api/test/admin/manage-users/suspenduser/" + id, {
                method: "PUT",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            })
            .then((res) => res.json())
            .then(() => {this.getUsers()})
            .catch((err) => {console.log("Err: " + err);})
        },
        async activateAccount(id) {
            await fetch("http://127.0.0.1:8084/api/test/admin/manage-users/activateuser/" + id, {
                method: "PUT",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
            })
            .then((res) => res.json())
            .then(() => {this.getUsers()})
            .catch((err) => {console.log("Err: " + err);})
        }
    },
    mounted() {
        this.getUsers()
    }
}
</script>
  
<style scoped>
#manage-users-container {
  display: none;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 90%;
}

#user-opts {
  width: 100%;
  text-align: right;
}

i {
  font-size: 20px;
  margin: 0 10px;
  color: #FBFFF1;
}

a {
  text-decoration: none;
  font-size: 20px;
  transition: opacity 0.2s ease-in-out;
  cursor: pointer;
}

a:hover {
  opacity: 0.7;
}

button {
  width: 80px;
  height: 45px;
  margin: 10px;
  border: solid 4px #FBFFF1;
  border-radius: 10px;
  text-align: center;
  transition: opacity 0.2s ease-in-out;
}

button:hover {
  opacity: 0.7;
}

td, th{
  border: 1px solid #FBFFF1;
  text-align: left;
  padding: 8px;
}
</style>