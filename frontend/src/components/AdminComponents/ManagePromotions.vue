<template>
  <div id="manage-promos-container">
    <div id="promo-opts">
      <a data-bs-toggle="modal" data-bs-target="#add-promo-modal"><i class="fa-solid fa-plus"></i></a>
      <a @click="getPromos()"><i class="fa-solid fa-arrows-rotate"></i></a>
      <!-- TODO: Implement search for promos? -->
      <a><i class="fa-solid fa-magnifying-glass"></i></a>
    </div>

    <div id="promo-console">
      <table id="manage-promos-table">
        <tr>
          <th>Promotion ID</th>
          <th>Promotion name</th>
          <th>Discount</th>
          <th>Promotion Code</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Sent to Users</th>
          <th>Options</th>
        </tr>

        <tr v-for="ad in promos" :key="ad.promoID">
          <td>{{ad.promoID}}</td>
          <td>{{ad.promotionName}}</td>
          <td>{{ad.discount}}</td>
          <td>{{ad.promocode}}</td>
          <td>{{convertTime(ad.startDate)}}</td>
          <td>{{convertTime(ad.endDate)}}</td>
          <td>{{ad.isSent}}</td>
          <td>
            <button @click="sendPromo(ad.promoID)">Dispatch</button>
            <button v-if="ad.isSent === false" @click="sendID(ad.promoID)" id="edit-promo-btn" type="button" data-bs-toggle="modal" data-bs-target="#edit-promo-modal">Edit</button>
            <button>Remove</button>
          </td>
        </tr>

      </table>
    </div>

    <AddPromo />
    <EditPromo />
  </div>
</template>
  
<script>
import AddPromo from '@/components/AdminComponents/AddPromo.vue'
import EditPromo from '@/components/AdminComponents/EditPromo.vue'

export default {
  name: "ManageMovies",
  components: {AddPromo, EditPromo},
  data() {
    return {
      promos : [],
    }
  },
  methods: {
    getPromos() {
      let getAds = async () => {
        await fetch("http://127.0.0.1:8084/api/test/admin/manage-promotions", {
          method: "GET",
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
        })
        .then((res) => res.json())
        .then((s) => {
          // console.log("Promos successfully retrieved." + JSON.stringify(s));
          this.promos = s.promotions
        })
        .catch((err) => {console.log("Err:" + err);})
      }
      getAds()
    },
    sendPromo(id) {
      let dispatchAd = async () => {
        await fetch("http://127.0.0.1:8084/api/test/admin/manage-promotions/sendpromotion/" + id, {
          method: "GET",
          headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
          },
        })
        .then((res) => res.json())
        .then((s) => {
          console.log("PromoID:" + id + " successfully dispatched." + JSON.stringify(s));
        })
        .catch((err) => {console.log("Err:" + err);})
      }
      dispatchAd()
    },
    convertTime(time) {
      return new Date(time).toLocaleDateString("en-US")
    },
    sendID(id) {
      document.querySelector("#promo-id-edit").value = id
    }
  },
  mounted() {
    this.getPromos()
  },
}
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

button, #edit-promo-btn {
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