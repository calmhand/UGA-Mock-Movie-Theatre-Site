import Vuex from 'vuex'
import users from '@/store/modules/users.js'
import site from '@/store/modules/site.js'
import movie from '@/store/modules/movie.js'
import checkout from '@/store/modules/checkout.js'

// Create Store
export default new Vuex.Store({
    modules: {
        site,
        users,
        movie,
        checkout
    },
})