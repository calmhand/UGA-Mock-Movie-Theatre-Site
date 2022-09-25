const checkoutPaths = [
    {
        path: '/checkout/seating',
        name: 'SelectSeats',
        component: () => import('@/views/Checkout/SelectSeats.vue')
    },
    {
        path: '/checkout/billing',
        name: 'AddressBilling',
        component: () => import('@/views/Checkout/AddressBilling.vue')  
    },
]

export default checkoutPaths