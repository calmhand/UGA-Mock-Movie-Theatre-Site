<template>
    <div id="confirm-container">

        <!-- Create a single input for w/ a placeholder to mimic a verification window. -->
        <div id="form-container">
            <form id="account_confirmation_form">
                <h3><i class="fa-regular fa-circle-check"></i> &nbsp; Confirmation Code</h3>
                <hr>
                <div id="col">
                    <span id="prompt">
                        Check your email for a verification code and enter it below.
                    </span>
                    <input id="confirmCode" type="password" maxlength="6" required autofocus/>
                    <label for="confirmCode">Code</label>
                </div>

                <button @click="goToProfile()">Submit</button>
            </form>
        </div>
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
    #confirm-container {
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    #form-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 400px;
        width: 550px;
        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 10px;
    }

    #col {
      display: flex;
      flex-direction: column;
      margin: 0 15px;
    }

    #prompt {
        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 10px;
        padding: 10px;
        font-size: 15px;
        margin: 10px 0;
    }
    
    form {
        width: 400px;
    }

    label {
        font-size: 20px;
        padding-right: 10px;
        text-align: left;
    }

  input {
    height: 50px;
    background-color: transparent;
    font-size: 25px;
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

  button {
    width: 150px;
    height: 45px;
    border: solid 4px #FBFFF1;
    border-radius: 10px;
    margin-top: 25px;
    text-align: center;
    transition: opacity 0.2s ease-in-out;
  }

  button:hover {
    opacity: 0.5;
  }

</style>