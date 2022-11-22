const siteStates = {
    "GUEST" : 0,
    "CUSTOMER" : 1,
    "ADMIN" : 2,
}

export default { 
    namespaced: true,
    state: () => ({ 
        currentState : 0,
        roles : [],
        accessToken : "",
        tokenType : "",
        id : 0,
        email : "",
    }),
    mutations: {
        UPDATE_STATE(state, newState) {
            state.currentState = siteStates[newState]
        },
        PARSE_TOKEN(state, payload) {
            state.id = payload["id"]
            state.email = payload["email"]
            state.roles = payload["roles"]
            state.accessToken = payload["accessToken"]
            state.tokenType = payload["tokenType"]
            // this.commit("site/UPDATE_STATE", "CUSTOMER")
            console.log("success (site.js): Login Successful");
        },
        CLEAR_TOKEN(state) {
            state.id = 0
            state.email = ""
            state.roles = []
            state.accessToken = ""
            state.tokenType = ""
            this.commit("site/UPDATE_STATE", "GUEST")
        },
    },
    actions: {  },
    getters: {  }
 }