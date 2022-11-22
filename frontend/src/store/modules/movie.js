export default {
    namespaced: true,
    state: () => ({
        retrieved : false,
        allMovies : [],
        currentMovies : [],
        upcomingMovies : []
    }),
    mutations: {
        GET_ALL_MOVIES(state) {
            let GET_FILMS = async () => {
                await fetch("http://127.0.0.1:8084/api/test/admin/manage-movies", {
                    method: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    state.retrieved = true
                    this.commit("movie/SET_ALL_MOVIES", s.movies)
                })
            }
            GET_FILMS()
        },
        GET_CURRENT_MOVIES(state) {
            let GET_CURRENT_FILMS = async () => {
                await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/home", {
                    method: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    state.retrieved = true
                    this.commit("movie/SET_CURRENT_MOVIES", s.currentMoviesList)
                })
            }
            GET_CURRENT_FILMS()
        },
        GET_UPCOMING_MOVIES(state) {
            let GET_UPCOMING_FILMS = async () => {
                await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/home", {
                    method: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                })
                .then((res) => res.json())
                .then((s) => {
                    state.retrieved = true
                    this.commit("movie/SET_UPCOMING_MOVIES", s.upcomingMovieList)
                })
            }
            GET_UPCOMING_FILMS()
        },
        SET_ALL_MOVIES(state, movies) {
            state.allMovies = movies
        },
        SET_CURRENT_MOVIES(state, movies) {
            state.currentMovies = movies
        },
        SET_UPCOMING_MOVIES(state, movies) {
            state.upcomingMovies = movies
        },
        CLEAR_MOVIES(state) {
            state.retrieved = false
        }
    },
    actions: {  },
    getters: {  },
}