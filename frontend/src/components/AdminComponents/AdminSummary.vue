<template>
    <div id="site-summary-container">
        <table id="site-overview-table">
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
    </div>
</template>
  
<script>
export default {
    name: "AdminSummary",
    props: [''],
    methods: {
        getAdminStats() {
            //api to get stats
        },
    }
}
</script>
  
<style scoped>
#site-summary-container {
    display: flex;
    width: 100%;
    align-items: center;
    justify-content: center;
}

#site-overview-table {
    width: 60%;
    background-color: #090b9b33;
    border: 1px solid #FBFFF1;
}

td, th {
    border: 1px solid #FBFFF1;
    text-align: left;
    padding: 8px;
    color: #FBFFF1;
}
</style>