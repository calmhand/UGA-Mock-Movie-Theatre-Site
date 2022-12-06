<template>
  <div class="modal fade" :id="id" tabindex="-1" aria-labelledby="alertModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="alertModalLabel">{{errorTitle}}</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                {{message}}
            </div>
        </div>
    </div>
    </div>
</template>

<script>
export default {
    name: "AlertModal",
    props: {
        id : String,
        errorTitle : String,
        message : String,
    },
}
</script>

<style scoped>
    .modal-content {
        background-color: #3C3744;
        color: #FBFFF1;
    }

    button {
        background-color: #FBFFF1;
        border-color: #FBFFF1;
        color: #3C3744;
    }
</style>