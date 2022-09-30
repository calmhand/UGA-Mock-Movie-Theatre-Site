const adminPaths = [
    {
        path: "/admin/console",
        name: "AdminConsole",
        component: () => import("@/views/Settings/AdminConsole.vue")
    },
]

export default adminPaths 