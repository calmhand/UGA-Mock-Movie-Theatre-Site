<template>
    <div id="confirm-form-container">
        <!-- Create a single input for w/ a placeholder to mimic a verification window. -->
        <button @click="goToProfile()"> Verify Code </button>
    </div>
</template>

<script>
export default {
    name: "ConfirmAccount",
    methods: {
        goToProfile() {
            this.$router.push({name: 'UserProfile', params: {userId: 123}})
        }
    }
}
</script>

<style scoped>
    #confirm-form-container {
        height: 100vh;
    }
</style>