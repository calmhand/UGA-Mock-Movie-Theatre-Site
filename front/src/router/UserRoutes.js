const userPaths = [
    {
        path: "/user/:userId",
        name: "UserProfile",
        component: () => import("@/views/Settings/UserProfile.vue"),
        props: true
    },
    {
        path: "/user/:userId/orders",
        name: "UserOrders",
        component: () => import("@/views/Settings/UserOrders.vue"),
        props: true
    },
]

export default userPaths 