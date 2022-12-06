<template>
    <div id="promo-info-container">
        <div style="width: 100%;">
            <h3>Promotions</h3>
            <hr>
        </div>
        <div id="promo-info">
            

            <form>
                <div id="col">
                    <h3>Subscribe to our promotions</h3>
                    <button @click="updateSubscriptions(true)">Subscribe</button>
                </div>
            </form>

            <form>
                <div id="col">
                    <h3 style="color: red;">Unsubscribe from all current promotions</h3>
                    <button @click="updateSubscriptions(false)">Unsubscribe</button>
                </div>
            </form>
        </div>
    </div>
    <AlertModal :id="`alert-promoUpdate-modal`" :errorTitle="updatePromoTitle" :message="updatePromoMsg"/>
    <button id="alert-promoUpdate-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-promoUpdate-modal"></button>
</template>

<script>
import AlertModal from '@/components/AlertModal.vue'

export default {
    name: 'PromoInfo',
    components: {AlertModal},
    data() {
        return {
            updatePromoTitle : "",
            updatePromoMsg : ""
        }
    },
    methods: {
        updateSubscriptions(choice) {
            const update = async (promoPayload) => {
                await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/updateprofile", {
                    method: "PUT",
                    headers: {
                        "Accept" : "application/json",
                        "Content-Type" : "application/json"
                    },
                    body: JSON.stringify(promoPayload)
                })
                .then((res) => res.json())
                .then((s) => {
                    if (choice) {
                        this.updatePromoTitle = "Subscription Notice"
                        this.updatePromoMsg = "You are now subscribed to promotions."
                        document.querySelector("#alert-promoUpdate-btn").click()
                    } else {
                        this.updatePromoTitle = "Subscription Notice"
                        this.updatePromoMsg = "You are now unsubscribed from all promotions."
                        document.querySelector("#alert-promoUpdate-btn").click()
                    }
                    console.log(s);
                })
                .catch((err) => {console.log("Err: " + err);})
            }
            
            let payload = {
                "firstName" : this.$store.state.users.firstName,
                "lastName" : this.$store.state.users.lastName,
                "isSubscribed" : choice,
            }

            update(payload)
        }
    }
}
</script>

<style scoped>
    #promo-info-container {
        display: none;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        text-align: left;
    }

    #promo-info {
        padding: 25px;
        display: flex;
        flex-direction: column;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 15px;
    }

    h3 {
        margin-top: 25px;
    }

    hr {
        margin: 0;
    }

    button {
        padding: 5px;
        margin: 10px 0;
        width: 175px;
        text-decoration: none;
        font-size: 20px;
        text-align: center;
        color: #FBFFF1;
        background-color: transparent;
        border: solid 2px #FBFFF1;
        border-radius: 20px;
        transition: opacity 0.2s ease-in-out;
    }

    button:hover {
        opacity: 0.6;
    }
</style>