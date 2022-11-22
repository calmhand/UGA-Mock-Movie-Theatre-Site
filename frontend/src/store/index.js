import Vuex from 'vuex'
import users from '@/store/modules/users.js'
import site from '@/store/modules/site.js'
import movie from '@/store/modules/movie.js'
import show from '@/store/modules/shows.js'

// Create Store
export default new Vuex.Store({
    modules: {
        site,
        users,
        movie,
        show
    },
})