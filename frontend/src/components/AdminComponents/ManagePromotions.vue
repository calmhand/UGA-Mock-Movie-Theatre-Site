<template>
  <div id="manage-promos-container">
    <div id="promo-opts">
      <a data-bs-toggle="modal" data-bs-target="#add-promo-modal"><i class="fa-solid fa-plus"></i></a>
      <!-- TODO: Implement search for promos? -->
      <a><i class="fa-solid fa-magnifying-glass"></i></a>
    </div>

    <div id="promo-console">
      <table id="manage-promos-table">
        <tr>
          <th>Promotion name</th>
          <th>Discount</th>
          <th>Promotion Code</th>
          <th>Is Active</th>
          <th>Sent to Users</th>
          <th>Options</th>
        </tr>
        <tr>
          <td>Homecoming</td>
          <td>10%</td>
          <td>HOMECOMING10</td>
          <td>True</td>
          <td>True</td>
          <td>
            <button>Dispatch</button>
            <button>Suspend</button>
            <button>Activate</button>
          </td>
        </tr>
        <tr>
          <td>Christmas</td>
          <td>20%</td>
          <td>SANTA20</td>
          <td>False</td>
          <td>False</td>
          <td>
            <button>Dispatch</button>
            <button>Suspend</button>
            <button>Activate</button>
          </td>
        </tr>
      </table>      
    </div>
    
    <AddPromo />
  </div>
</template>
  
<script>
import AddPromo from '@/components/AdminComponents/AddPromo.vue'
export default {
  name: "ManageMovies",
  components: {AddPromo},
  methods: {
    
  }
}

  // call loadPromotions

</script>
  
<style scoped>
#manage-promos-container {
  display: none;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

#promo-opts {
  width: 100%;
  text-align: right;
}

#promo-console {
  width: 100%;
}

#manage-promos-table {
    background-color: #090b9b33;
    border: 1px solid #FBFFF1;
    margin: 10px;
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
  width: 100px;
  height: 45px;
  margin: 0 10px;
  border: solid 4px #FBFFF1;
  border-radius: 10px;
  text-align: center;
  transition: opacity 0.2s ease-in-out;
}

button:hover {
  opacity: 0.7;
}

td, th {
  border: 1px solid #FBFFF1;
  text-align: left;
  padding: 8px;
}
</style>