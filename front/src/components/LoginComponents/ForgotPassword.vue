<template>
    <div class="modal fade" id="enterEmailModal" aria-hidden="true" aria-labelledby="enterEmailModalLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="enterEmailModalLabel">Find Account</h1>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <i class="fa-solid fa-triangle-exclamation"></i> &nbsp; Enter your email below to be sent a verification code.
                    <div id="col">
                        <input name="emailReset" type="email" required>
                        <label for="emailReset">Email</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <!-- TODO: Check if email is in DB. Alert user if email doesn't exist. Else, continue -->
                    <button class="btn btn-primary" data-bs-target="#verifyAccountModal" data-bs-toggle="modal">Next</button>
                </div>
            </div>
        </div>
    </div>

    <!-- TODO: Create modal for failed email search attempt. -->

    <div class="modal fade" id="verifyAccountModal" aria-hidden="true" aria-labelledby="verifyAccountModalLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="verifyAccountModalLabel">Verify</h1>
                    <!-- <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button> -->
                </div>
                <div class="modal-body">
                    <form>
                        <i class="fa-solid fa-triangle-exclamation"></i> &nbsp; Enter your verification code.
                        <div id="col">
                            <input name="resetCode" type="email" maxlength="6" required>
                            <label for="resetCode">Code</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    
                    <button class="btn btn-primary" data-bs-target="#resetPasswordModal" data-bs-toggle="modal">Confirm</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="resetPasswordModal" aria-hidden="true" aria-labelledby="resetPasswordModalLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="resetPasswordModalLabel">Set New Password</h1>
                    <!-- <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button> -->
                </div>
                <div class="modal-body">
                    <form>
                        <i class="fa-solid fa-triangle-exclamation"></i> &nbsp; Create a new password.
                        <div id="col">
                            <input name="newPass" type="email" required>
                            <label for="newPass">New Password</label>
                        </div>

                        <div id="col">
                            <input name="confirmNewPass" type="email" required>
                            <label for="confirmNewPass">Confirm New Password</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <!-- TODO: Check if password meets security requirements. Continue if good. -->
                    <button class="btn btn-primary" data-bs-target="#resetSuccessModal" data-bs-toggle="modal">Reset Password</button>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="resetSuccessModal" aria-hidden="true" aria-labelledby="resetSuccessModalLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body">
                    Password successfully reset. Please log in.
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" data-bs-target="#resetSuccessModal" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <a data-bs-toggle="modal" href="#enterEmailModal" role="button"><h3 style="text-align: center;">Reset Password</h3></a>
</template>

<script>
    export default {
        name: 'ForgotPassword',
    }
</script>

<style scoped>
    .modal-content {
        background-color: #3C3744;
    }
    
    #col {
      display: flex;
      flex-direction: column;
      margin: 0 15px;
    }

    a {
        text-decoration: none;
        font-size: 20px;
        transition: opacity 0.2s ease-in-out;
    }

    a:hover {
        opacity: 0.7;
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
    
    label {
        font-size: 20px;
        padding-right: 10px;
        text-align: left;
    }

    button {
        background-color: #FBFFF1;
        border-color: #FBFFF1;
        color: #3C3744;
    }
</style>