const userPaths = [
    {
        path: "/user/:userId",
        name: "UserProfile",
        component: () => import("@/views/Settings/UserProfile.vue"),
        props: true
    },
]

export default userPaths 