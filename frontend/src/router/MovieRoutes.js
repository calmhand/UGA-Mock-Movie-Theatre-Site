const moviePaths = [
    {
        path: "/movies/list",
        name: "MoviesPage",
        component: () => import("@/views/Movies/MoviesPage.vue")
    },
    {
        path: "/movies/search/:query",
        name: "MovieSearchPage",
        component: () => import("@/views/Movies/MovieSearchPage.vue"),
        props: true
    },
    {
        path: "/movies/filter/:genre",
        name: "MovieGenrePage",
        component: () => import("@/views/Movies/MovieGenrePage.vue"),
        props: true
    },
    {
        path: "/movies/:movieId/:movieTitle/info",
        name: "MovieDetails",
        component: () => import("@/views/Movies/MovieDetails.vue"),
        props: true
    },
]

export default moviePaths 