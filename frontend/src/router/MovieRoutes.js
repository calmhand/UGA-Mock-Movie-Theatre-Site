const moviePaths = [
    {
        path: "/movies/list",
        name: "MoviesPage",
        component: () => import("@/views/Movies/MoviesPage.vue")
    },
    {
        path: "/movies/:movieId/info",
        name: "MovieDetails",
        component: () => import("@/views/Movies/MovieDetails.vue"),
        props: true
    },
]

export default moviePaths 