import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createStore } from 'vuex'

// eslint-disable-next-line
const siteStates = {
    "GUEST" : 0,
    "CUSTOMER" : 1,
    "ADMIN" : 2,
}

const store = createStore({
    state() {
      return {
        currentState: 0
      }
    },
    mutations: {
      updateState(state, newState) {
        state.currentState = siteStates[newState]
      },
    }
  })

let app = createApp(App)

// Mount App
app.use(router)
app.use(store)
app.mount('#app')