<template>
    <!-- TODO: Stop video playback when modal is closed. -->
    <div class="modal fade" :id="`trailerModal` + this.trailerId" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered modal-xl">
            <div class="modal-content">
                <div class="modal-body">
                    <iframe width="850px" height="580px" :src="this.link" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
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
    name: 'TrailerModal',
    props: {
        link: String,
        trailerId: Number
    }
}
</script>

<style scoped>
    .modal-content {
        background-color: #3C3744;
    }
</style>