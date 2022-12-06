export default {
    namespaced: true,
    state: () => ({
        "childTickets" : 0,
        "childPrice" : 0,
        "adultTickets" : 0,
        "adultPrice" : 0,
        "seniorTickets" : 0,
        "seniorPrice" : 0,
        "totalTickets" : 0,
        "movieId" : 0,
        "movieTitle" : "",
        "showDate" : "",
        "timeSlot" : "",
        "theatre" : "",
        "seats" : [],
        "total" : 0,
        "totalWithoutTax" : 0,
        "taxPrice" : 0,
        "orderConfirm" : {}
    }),
    mutations: {
        PARSE_SHOW(state, payload, title) {
            state.childPrice = payload.ticketPrices.child
            state.adultPrice = payload.ticketPrices.adult
            state.seniorPrice = payload.ticketPrices.senior
            state.movieId = payload.movieID
            state.showDate = payload.showDate
            state.theatre = payload.showRoom
            state.timeSlot = payload.showTimeSlot
            state.movieName = title
        },
        PARSE_PRICE(state, payload) {
            state.total = payload.total
            state.totalWithoutTax = payload.totalWithoutTax
            state.taxPrice = payload.taxPercentage
        },
        SET_CONFIRMED_ORDER_OBJ(state, payload) {
            state.orderConfirm = payload
        },
        SET_MOVIE_NAME(state, name) {
            state.movieTitle = name
        },
        CLEAR_CHECKOUT_STORE(state) {
            state.childPrice = 0
            state.adultPrice = 0
            state.seniorPrice = 0
            state.movieId = 0
            state.showDate = ""
            state.theatre = ""
            state.timeSlot = ""
            state.movieName = ""
            state.total = 0
            state.totalWithoutTax = 0
            state.taxPrice = 0
            state.orderConfirm = {}
            state.movieTitle = ""
            state.seats = []
        }
    },
    actions: {},
    getters: {}
}