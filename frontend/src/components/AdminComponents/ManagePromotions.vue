<template>
  <div id="manage-promos-container">
    <div id="promo-opts">
      <a data-bs-toggle="modal" data-bs-target="#add-promo-modal"><i class="fa-solid fa-plus"></i></a>
      <a @click="getPromos()"><i class="fa-solid fa-arrows-rotate"></i></a>
    </div>

    <div id="promo-console">
      <div id="manage-promos-table">
        <div id="promo-obj" v-for="ad in promos" :key="ad.promoID">
          <div id="row">
            <div id="col">
              <h4>{{ad.promoID}}</h4>
              <label>Promotion ID</label>
            </div>

            <div id="col">
              <h4>{{ad.promotionName}}</h4>
              <label>Promotion name</label>
            </div>

            <div id="col">
              <h4>{{ad.discount}}%</h4>
              <label>Discount</label>
            </div>

            <div id="col">
              <h4>{{ad.promocode}}</h4>
              <label>Promo Code</label>
            </div>

            <div id="col">
              <h4>{{convertTime(ad.startDate)}}</h4>
              <label>Start Date</label>
            </div>

            <div id="col">
              <h4>{{convertTime(ad.endDate)}}</h4>
              <label>End Date</label>
            </div>

            <div id="col">
              <h4>{{ad.isSent}}</h4>
              <label>Dispatched?</label>
            </div>
          </div>
          <hr>
          <div id="row">
            Options: 
            <button @click="sendPromo(ad.promoID)">Dispatch</button>
            <button v-if="ad.isSent === false" @click="sendID(ad.promoID)" id="edit-promo-btn" type="button" data-bs-toggle="modal" data-bs-target="#edit-promo-modal">Edit</button>
          </div>
        </div>
      </div>
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
          console.log("Promos successfully retrieved." + JSON.stringify(s));
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
          this.getPromos()
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

#manage-promos-table {
    background-color: #090b9b33;
    border: 4px solid #FBFFF1;
    border-radius: 10px;
    height: 80vh;
    width: 100%;
    overflow-y: scroll;
}

#promo-obj {
  border-bottom: solid 2px #FBFFF1;
  padding: 20px;
}

#row {
    display: flex;
    flex-direction: row;
    align-items: center;
}

#col {
    display: flex;
    flex-direction: column;
    margin: 0 15px;
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