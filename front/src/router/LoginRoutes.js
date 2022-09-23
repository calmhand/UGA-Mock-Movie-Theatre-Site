const loginPaths = [
    {
        path: "/login",
        name: "LoginPage",
        component: () => import("@/views/Login/LoginPage.vue")
    },
    {
        path: "/login/admin",
        name: "AdminLogin",
        component: () => import("@/views/Login/AdminLogin.vue")
    },
    {
        path: "/login/create",
        name: "CreateAccount",
        component: () => import("@/views/Login/CreateAccount.vue")
    },
    {
        path: "/login/confirmation",
        name: "ConfirmAccount",
        component: () => import('@/views/Login/ConfirmAccount.vue')
    }
]

export default loginPaths 