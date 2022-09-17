import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

let app = createApp(App)

// Global Vars Here
app.config.globalProperties.$loginStatus = false

// Mount App
app.use(router).mount('#app')