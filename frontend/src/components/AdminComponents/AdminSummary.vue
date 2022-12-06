<template>
    <div id="site-summary-container">
        <h1>Welcome to the admin console.</h1>
    </div>
</template>
  
<script>
export default {
    name: "AdminSummary",
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