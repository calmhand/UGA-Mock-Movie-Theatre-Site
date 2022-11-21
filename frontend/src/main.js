import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

let app = createApp(App)

// Enable Routing and State Management, then mount app.
app.use(router)
app.use(store)
app.mount('#app')