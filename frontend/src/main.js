import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import { createStore } from 'vuex'
import store from './store'

// const store = createStore({
//   state() {
//     return {
//       currentState : 0,
//       id : 0,
//       email : "",
//       roles : [],
//       accessToken : "",
//       tokenType : "",
//       firstName : "",
//       lastName : "",
//       phone : "",
//       subbed : false,
//       street : "",
//       apt : "",
//       city : "",
//       state : "",
//       zip : ""
//     }
//   },
//   mutations: {
//     updateState(state, newState) {
//       state.currentState = siteStates[newState]
//     },
//     parseToken(state, payload) {
//       state.id = payload["id"]
//       state.email = payload["email"]
//       state.roles = payload["roles"]
//       state.accessToken = payload["accessToken"]
//       state.tokenType = payload["tokenType"]
//       this.commit("updateState", "CUSTOMER")
//       console.log("success (main.js): Login Successful");
//     },
//     setUserInfo(state, payload) {
//       state.firstName = payload["firstName"]
//       state.lastName = payload["lastName"]
//       state.phone = payload["phone"]
//       state.subbed = payload["isSubscribed"]
//       state.street = payload["street"]
//       state.apt = payload["apt"]
//       state.zipcode = payload["zipcode"]
//       state.city = payload["city"]
//       state.state = payload["state"]

//     },
//     clearToken(state) {
//       state.id = 0
//       state.email = ""
//       state.roles = []
//       state.accessToken = ""
//       state.tokenType = ""
//       this.commit("updateState", "GUEST")
//     },
//   },
// })

let app = createApp(App)

// Enable Routing and State Management, then mount app.
app.use(router)
app.use(store)
app.mount('#app')