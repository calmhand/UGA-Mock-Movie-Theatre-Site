export default { 
    namespaced: true,
    state: () => ({ 
        firstName : "",
        lastName : "",
        phone : "",
        subbed : false,
        street : "",
        apt : "",
        city : "",
        state : "",
        zip : "",
    }),
    mutations: {
        SET_USER(state, payload) {
            state.firstName = payload["firstName"]
            state.lastName = payload["lastName"]
            state.phone = payload["number"]
            state.subbed = payload["isSubscribed"]
            state.street = payload["address"]["street"]
            state.apt = payload["address"]["apt"]
            state.zipcode = payload["address"]["zipcode"]
            state.city = payload["address"]["city"]
            state.state = payload["address"]["state"]
            console.log("user testing:" + JSON.stringify(payload));
        },
    },
    actions: {  },
    getters: {  }
}