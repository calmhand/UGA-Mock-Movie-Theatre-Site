import { createRouter, createWebHashHistory } from 'vue-router'

/** Importing routes from external src to save space. */
import loginPaths from '@/router/LoginRoutes.js'
import userPaths from '@/router/UserRoutes.js'
import adminPaths from '@/router/AdminRoutes.js'
import moviePaths from '@/router/MovieRoutes.js'
import checkoutPaths from '@/router/CheckoutRoutes.js'

const routes = [
  { // Home
    path: '/home',
    name: 'HomePage', 
    component: () => import("@/views/HomePage.vue")
  }, // Imported Paths
  ...loginPaths,
  ...userPaths,
  ...adminPaths,
  ...moviePaths,
  ...checkoutPaths,
  { // Catch non-existent paths.
    path: '/:catchAll(.*)',
    name: 'ErrorPage',
    component: () => import('@/views/ErrorPage.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
