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
                    <button @click="updateSubscription(true)">Subscribe</button>
                </div>
            </form>

            <form>
                <div id="col">
                    <h3 style="color: red;">Unsubscribe from all current promotions</h3>
                    <button @click="updateSubscription(false)">Unsubscribe</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'PromoInfo',
        methods: {
            updateSubscriptions(choice) {
                const update = async (promoPayload) => {
                    await fetch("", {
                        method: "PUT",
                        headers: {
                            "Accept" : "application/json",
                            "Content-Type" : "application/json"
                        },
                        body: JSON.stringify(promoPayload)
                    })
                    .then((res) => res.json())
                    .then((result) => {console.log(result);})
                    .catch((err) => {console.log("Err: " + err);})
                }
                
                let payload = {
                    userid : this.$store.state.site.id,
                    isSubscribed : choice
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