import Vuex from 'vuex'
import users from '@/store/modules/users.js'
import site from '@/store/modules/site.js'

// Create Store
export default new Vuex.Store({
    modules: {
        site,
        users
    },
})