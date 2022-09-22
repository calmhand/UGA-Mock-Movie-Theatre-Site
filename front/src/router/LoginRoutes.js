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
        name: "createAccount",
        component: () => import("@/views/Login/CreateAccount.vue")
    },
]

export default loginPaths 