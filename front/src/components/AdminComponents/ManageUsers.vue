<template>
    <div class="Manage-users-container">
        <div id="users-container">
            <h1>Users</h1>
            <table>
                <tr>
                    <th>User name</th>
                    <th>Email</th>
                    <th>Account Status</th>
                    <th>Account Type</th>
                    <th>Options</th>
                </tr>
                <tr>
                    <td>Jay</td>
                    <td>jay@gmail.com</td>
                    <td>active</td>
                    <td>customer</td>
                    <td><button>Bookings</button>
                        <button>Suspend</button>
                        <button>Activate</button>
                        <button>Make Admin</button>
                    </td>
                </tr>
                <tr>
                    <td>Jayasimha</td>
                    <td>Jayasimha@gmail.com</td>
                    <td>active</td>
                    <td>admin</td>
                    <td><button>Bookings</button>
                        <button>Suspend</button>
                        <button>Activate</button>
                        <button>Make Admin</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>
  
<script>
export default {
    name: "ManageMovies",
    props: [''],
    methods: {
        getUsers(){
            // fetch users and lopad table
        },
    }
}
</script>
  
<style scoped>
button {
    background-color: #e67e22;
    border-radius: 4px;
    color: white;
    font-size: 1em;
    font-weight: bold;
    font-family: inherit;
    padding: 10px 15px;
    border: 1px solid;
}

button:hover {
    background-color: #bf6516;
}

h1 {
    text-align: left;
    font-size: 25px;
}

table {
    font-family: arial, sans-serif;
    color: black;
    border-collapse: collapse;
    width: 100%;
}

td,
th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr {
    background-color: white;
}
</style>