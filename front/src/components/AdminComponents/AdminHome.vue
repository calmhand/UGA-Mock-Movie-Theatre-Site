<template>
    <h1>At a Glance:</h1>
    <table id="admin-stats">
        <tr>
            <th>Halls:</th>
            <td>4</td>
        </tr>
        <tr>
            <th>Current Movies:</th>
            <td>2</td>
        </tr>
        <tr>
            <th>Shows Scheduled:</th>
            <td>4</td>
        </tr>
        <tr>
            <th>Registered Users:</th>
            <td>48</td>
        </tr>
        <tr>
            <th>Suspended Users:</th>
            <td>2</td>
        </tr>
        <tr>
            <th>Admin Staff:</th>
            <td>3</td>
        </tr>
    </table>
</template>
  
<script>
export default {
    name: "AdminHome",
    props: [''],
    methods: {
        getAdminStats() {
            //api to get stats
        },
    }
}
</script>
  
<style scoped>
h1 {
    text-align: left;
    margin-left: 20%;
    font-size: 25px;
}

#admin-stats {
    margin-left: 20%;
    width: 60%;
    background-color: white;
}

td,
th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    color: black;
}
</style>