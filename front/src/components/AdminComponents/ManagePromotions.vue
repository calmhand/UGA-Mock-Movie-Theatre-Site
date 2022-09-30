<template>
  <div class="Manage-promotions-container">
    <div id="allpromotions-container">
      <h1>Promotions</h1>
      <table>
        <tr>
          <th>Promotion name</th>
          <th>Discount</th>
          <th>Promotion Code</th>
          <th>Sent to Users</th>
          <th>Options</th>
        </tr>
        <tr>
          <td>Homecoming</td>
          <td>10%</td>
          <td>HOMECOMING10</td>
          <td>True</td>
          <td><button>Send to Users</button>
            <button>Delete</button>
          </td>
        </tr>
        <tr>
          <td>Christmas</td>
          <td>20%</td>
          <td>SANTA20</td>
          <td>False</td>
          <td><button>Send to Users</button>
            <button>Delete</button>
          </td>
        </tr>
      </table>
    </div>
    <br /><br />
    <div id="addpromo-container">
      <button @click="openAddPromoForm()">Add Promo</button>
      <form id="add-promo-form">
        <div class="labels">
          <label for="promotionName">Promotion Name</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="promotionName">
        </div>

        <div class="labels">
          <label for="discount">Discount</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="discount">
        </div>

        <div class="labels">
          <label for="promotionCode">Promotion Code</label>
        </div>
        <div class="input-tab">
          <input class="input-field" type="text" name="promotionCode">
        </div>

        <div class="submission">
          <button type="submit" @click="savePromo()">Save</button>
          <button @click="closeAddPromoForm()">Cancel</button>
        </div>

      </form>
    </div>

  </div>
</template>
  
<script>
export default {
  name: "ManageMovies",
  props: [''],
  methods: {
    openAddPromoForm() {
      document.getElementById("add-promo-form").style.display = "block";
    },
    closeAddPromoForm() {
      document.getElementById("add-promo-form").style.display = "none";
    },
    savePromo() {
      // save
    },
    loadPromotions() {
      // api to call all promotions and load the table
    },
  }
}

  // call loadPromotions

</script>
  
<style scoped>
#add-promo-form {
  margin: 0 auto;
  width: 100%;
  padding: 10px;
  display: none;
}

.labels {
  display: inline-block;
  text-align: right;
  width: 40%;
  vertical-align: top;
  margin-top: 20px;
}

.input-tab {
  display: inline-block;
  text-align: left;
  width: 50%;
  margin-left: 10px;
}

.input-field {
  display: inline-block;
  width: 50%;
  padding: 5px;
  margin: 18px 0 0 10px;
  border: 1px solid #e67e22;
  border-radius: 4px;
  font-family: inherit;
  font-size: 15px;
  font-weight: bold;
}

#dropdown {
  width: 50%;
  padding: 5px;
  margin: 20px 0 10px 10px;
  border: 1px solid #e67e22;
  border-radius: 3px;
  font-family: inherit;
  font-size: 15px;
}

.submission {
  margin: 10px 0px 0px 60px;
}

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