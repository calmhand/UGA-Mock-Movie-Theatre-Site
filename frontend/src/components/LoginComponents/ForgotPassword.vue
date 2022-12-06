<template>
    <!-- ENTER EMAIL MODAL-->
    <div class="modal fade" id="enterEmailModal" aria-hidden="true" aria-labelledby="enterEmailModalLabel" tabindex="-1" data-bs-keyboard="false" data-bs-backdrop="static">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="enterEmailModalLabel">Find Account</h1>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <i class="fa-solid fa-triangle-exclamation"></i> &nbsp; Enter your email below to be sent a verification code.
                    <div id="col">
                        <input id="emailReset" name="emailReset" type="email" required autocomplete="off">
                        <label for="emailReset">Email</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="findEmailBtnHidden" style="display: none;" class="btn btn-primary" data-bs-target="#resetPasswordModal" data-bs-toggle="modal"></button>
                    <button @click="verifyEmail()" id="findEmailBtn" class="btn btn-primary">Next</button>
                </div>
            </div>
        </div>
    </div>

    <!-- ENTER NEW PASSWORDS MODAL-->
    <div class="modal fade" id="resetPasswordModal" aria-hidden="true" aria-labelledby="resetPasswordModalLabel" tabindex="-1" data-bs-keyboard="false" data-bs-backdrop="static">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="resetPasswordModalLabel">Set New Password</h1>
                </div>
                <div class="modal-body">
                    <form autocomplete="off">
                        <i class="fa-solid fa-triangle-exclamation"></i> &nbsp; Enter your code and create a new password.
                        
                        <div id="col">
                            <input id="resetCode" name="resetCode" type="email" maxlength="6" required>
                            <label for="resetCode">Code</label>
                        </div>
                        <div id="col">
                            <input id="newPass-forgot" name="newPass-forgot" type="password" required>
                            <label for="newPass-forgot">New Password</label>
                        </div>

                        <div id="col">
                            <input id="confirmNewPass-forgot" name="confirmNewPass-forgot" type="password" required>
                            <label for="confirmNewPass-forgot">Confirm New Password</label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="resetSuccessModalBtn" class="btn btn-primary" data-bs-target="#resetSuccessModal" data-bs-toggle="modal" style="display: none;"></button>
                    <button @click="setNewPassword()" class="btn btn-primary">Reset Password</button>
                </div>
            </div>
        </div>
    </div>
    
    <!-- PROCESS COMPLETE MODAL -->
    <div class="modal fade" id="resetSuccessModal" aria-hidden="true" aria-labelledby="resetSuccessModalLabel" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="resetPasswordModalLabel">Successful Password Change</h1>
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Password successfully reset. Please log in.
                </div>
            </div>
        </div>
    </div>
    <a data-bs-toggle="modal" href="#enterEmailModal" role="button"><h3 style="text-align: center;">Reset Password</h3></a>
</template>

<script>
    export default {
        name: 'ForgotPassword',
        data() {
            return {
                next : true,
                saveEmail : ""
            }
        },
        methods: {
            verifyEmail() {
                let email = document.querySelector("#emailReset").value
                let searchPayload = {
                    "email" : email,
                }
                const searchEmail = async (payload) => {
                    await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/forgotpassword", {
                        method: "POST",
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(payload)
                    })
                    .then((res) => res.json())
                    .then((result) => {
                        console.log("searchEmail Sucess: " + result);
                        this.saveEmail = email
                        document.querySelector("#findEmailBtnHidden").click()
                    })
                    .catch((err) => {console.log(err);})
                }
                if (email !== "") searchEmail(searchPayload)
            },
            setNewPassword() {
                let pass = document.querySelector("#newPass-forgot").value
                let confirmPass = document.querySelector("#confirmNewPass-forgot").value
                let code = document.querySelector("#resetCode").value
                let newPassPayload = {
                    "newPassword" : pass,
                    "code" : code,
                    "email" : this.saveEmail
                }

                const setPass = async (payload) => {
                    await fetch("http://127.0.0.1:8084/api/onlinemoviebooking/emailresetpassword", {
                        method: "POST", 
                        headers: {
                            'Accept': 'application/json',
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(payload)
                    })
                    .then((res) => res.json())
                    .then(() => {
                        console.log("Successful pass change");
                        document.querySelector("#resetSuccessModalBtn").click()
                    })
                    .catch((err) => {console.log(err);})
                }

                if (!(pass === confirmPass) || pass == "" | confirmPass == "") {
                    alert("Forgot Password System: Passwords don't match.")
                } else {
                    setPass(newPassPayload)
                }
            }
        }
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