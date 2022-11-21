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
    {
        path: '/checkout/order-confirmed',
        name: 'OrderConfirmed',
        component: () => import('@/views/Checkout/OrderConfirmed.vue')
    },
]

export default checkoutPaths