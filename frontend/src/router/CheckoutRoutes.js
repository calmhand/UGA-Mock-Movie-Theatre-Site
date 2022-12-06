const checkoutPaths = [
    {
        path: '/checkout/:showId/tickets',
        name: 'SelectTickets',
        component: () => import('@/views/Checkout/SelectTickets.vue'),
        props: true
    },
    {
        path: '/checkout/:showId/seating',
        name: 'SelectSeats',
        component: () => import('@/views/Checkout/SelectSeats.vue'),
        props: true
    },
    {
        path: '/checkout/:showId/payment',
        name: 'AddressBilling',
        component: () => import('@/views/Checkout/BillingPayment.vue'),
        props: true
    },
    {
        path: '/checkout/:showId/order-confirmed',
        name: 'OrderConfirmed',
        component: () => import('@/views/Checkout/OrderConfirmed.vue'),
        props: true
    },
]

export default checkoutPaths