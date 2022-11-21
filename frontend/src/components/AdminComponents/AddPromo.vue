<template>
    <div id="add-promo-modal" class="modal fade" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Promotion</h5>
                </div>

                <div class="modal-body"> 
                    <form>

                        <div id="row">
                            <div id="col">
                                <input type="text">
                                <label>Promo Name</label>
                            </div>

                            <div id="col">
                                <input type="text">
                                <label>Discount (%)</label>
                            </div>
                        </div>

                        <div id="row">
                            <div id="col">
                                <input type="text">
                                <label>Promo Code</label>
                            </div>
                        </div>

                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <!-- TODO: Implement AddPromo Button. -->
                    <button type="button" class="btn btn-primary">Add Promotion</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "AddPromo",
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