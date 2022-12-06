<template>
    <div id="add-promo-modal" class="modal fade" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Promotion</h5>
                </div>

                <div class="modal-body"> 
                    <form autocomplete="off">
                        <div id="row">
                            <div id="col">
                                <input id="promo-name-input" type="text">
                                <label>Promo Name</label>
                            </div>

                            <div id="col">
                                <input id="discount-input" type="number" min="5" max="50">
                                <label>Discount (%)</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="promo-code-input" type="text">
                                <label>Promo Code</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="promo-start-input" type="date">
                                <label>Start Date</label>
                            </div>

                            <div id="col">
                                <input id="promo-end-input" type="date">
                                <label>End Date</label>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button id="close-promo-modal" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button @click="addPromo()" type="button" class="btn btn-primary">Add Promotion</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddPromo",
    methods: {
        addPromo() {
            let promoName = document.querySelector("#promo-name-input").value
            let discount = document.querySelector("#discount-input").value
            let code = document.querySelector("#promo-code-input").value
            let promoStart = document.querySelector("#promo-start-input").value
            let promoEnd = document.querySelector("#promo-end-input").value

            let promoPayload = {
                "promotionName" : promoName,
                "promocode" : code,
                "discount" : discount,
                "startDate" : promoStart,
                "endDate" : promoEnd,
                "isSent" : false
            }

            let postAd = async () => {
                await fetch("http://127.0.0.1:8084/api/test/admin/manage-promotions/addpromotion", {
                    method: "POST",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(promoPayload),
                })
                .then((res) => res.json())
                .then(() => {
                    // console.log("promo added: " + JSON.stringify(s))
                    document.getElementById("close-promo-modal").click()
                })
                .catch((err) => {console.log("err: " + err);})
            }
            postAd()   
        }
    }
}
</script>

<style scoped>
    #add-movie-modal {
        color: #FBFFF1;
    }
    
    .modal-content {
        background-color: #090b9bd7;
    }

    #row {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    #col {
        display: flex;
        flex-direction: column;
        margin: 0 15px;
    }

    form {
        width: 100%;
        text-align: left;
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
        align-content: center;
        overflow-y: auto;
    }

    label {
        font-size: 17px;
        padding-right: 10px;
        text-align: left;
    }

    input {
        height: 50px;
        background-color: transparent;
        font-size: 15px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: white;
        text-align: center;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 4px #FBFFF1;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
    }
</style>