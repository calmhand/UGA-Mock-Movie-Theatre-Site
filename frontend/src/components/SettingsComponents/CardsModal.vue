<template>
    <div class="modal fade" id="cards-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="cards-modal-label" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="cards-modal-label">Available Cards</h1>
                </div>

                <div id="cards-display" class="modal-body">
                    
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "CardsModal",
    methods: {
    }
}
</script>

<style scoped>
    #cards-modal {
        color: #FBFFF1;
    }

    .modal-content {
        background-color: #090b9bd7;
    }

    #cards-display {
        display: flex;
        flex-direction: column;
    }
</style>