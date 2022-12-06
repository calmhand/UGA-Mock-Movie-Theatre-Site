<template>
  <div id="movieDetailsTrailerModal" class="modal fade" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
        <div class="modal-body">
            <iframe :src="url"></iframe>
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
    name: "MovieDetailsTrailer",
    props: ['url']
}
</script>

<style scoped>
    #movieDetailsTrailerModal {
        color: #FBFFF1;
    }

    .modal-content {
        background-color: #090b9bd7;
    }

    iframe {
        width: 100%;
        height: 315px;
    }
</style>