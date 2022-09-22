const moviePaths = [
    {
        path: "/movies/list",
        name: "MoviesPage",
        component: () => import("@/views/Movies/MoviesPage.vue")
    },
    {
        path: "/movies/:movieName/info",
        name: "MovieDetails",
        component: () => import("@/views/Movies/MovieDetails.vue"),
        props: true
    },
]

export default moviePaths 