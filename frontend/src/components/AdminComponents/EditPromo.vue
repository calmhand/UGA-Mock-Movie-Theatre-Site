<template>
  <div>
    <div class="modal fade" id="edit-promo-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="edit-promo-modal-label" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="edit-promo-modal-label">Edit Promotion</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div id="row">
                            <div id="col">
                                <input id="promo-id-edit" type="text" disabled>
                                <label>Promo ID</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="promo-name-edit" type="text">
                                <label>Promo Name</label>
                            </div>

                            <div id="col">
                                <input id="discount-edit" type="number" min="5" max="50">
                                <label>Discount (%)</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="promo-code-edit" type="text">
                                <label>Promo Code</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input id="promo-start-edit" type="date">
                                <label>Start Date</label>
                            </div>

                            <div id="col">
                                <input id="promo-end-edit" type="date">
                                <label>End Date</label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="close-edit-promo-modal" type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button @click="editPromo()" type="button" class="btn btn-primary">Edit Promo</button>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name: "EditPromo",
    data() {
        return {
            promoID : 0,
            promo : {}
        }
    },
    methods: {
        editPromo() {
            this.setID()
            let promoNameEdit = document.querySelector("#promo-name-edit").value
            let codeEdit = document.querySelector("#promo-code-edit").value
            let discountEdit = document.querySelector("#discount-edit").value
            let startDateEdit = document.querySelector("#promo-start-edit").value
            let endDateEdit = document.querySelector("#promo-end-edit").value

            let promoEditPayload = {
                "promotionName" : promoNameEdit,
                "promocode" : codeEdit,
                "discount" : discountEdit,
                "startDate" : Math.floor(new Date(startDateEdit)),
                "endDate" : Math.floor(new Date(endDateEdit)),
                "isSent" : false
            }

            let editPromo = async () => {
                await fetch("http://127.0.0.1:8084/api/test/admin/manage-promotions/updatepromotion/" + this.promoID, {
                    method: "PUT",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(promoEditPayload),
                })
                .then((res) => res.json())
                .then(() => {
                    document.getElementById("close-edit-promo-modal").click()
                })
                .catch((err) => {console.log("err: " + err);})
            }
            editPromo()

        },
        setID() {
            this.promoID = document.querySelector('#promo-id-edit').value
        }
    },
}
</script>

<style scoped>
    #edit-promo-modal {
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