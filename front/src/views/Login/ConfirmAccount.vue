<template>
    <div id="confirm-form-container">

        <!-- Create a single input for w/ a placeholder to mimic a verification window. -->
        <form id="account_confirmation_form">
            <label>Confirmation Code</label>
            <input type="text" placeholder="loremipsum"/><br>
        </form>
        
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
    
    form {
        border: solid 1px white;
        width: 400px;
        margin: 10px auto;
        padding: 40px;
    }

    input {
        width: 250px;
        height: 40px;
        border: solid 4px white;
        border-radius: 10px;
        margin: 15px;
    }

    label {
        font-size: 30px;
    }

</style>