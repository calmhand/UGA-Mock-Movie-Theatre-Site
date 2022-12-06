<template>
  <div id="user-info-container">
    <div id="info">  
      <div style="width: 100%;">
        <h3>Personal Info</h3>
        <hr>
      </div>
      <div id="row">
        <i class="fa-solid fa-address-card"></i>
        <div id="col">
          <input :placeholder="this.$store.state.site.email" disabled>
          <label>Email</label>
        </div>

        <div id="col">
          <input :placeholder="this.$store.state.site.id" disabled>
          <label>Account ID </label>
        </div>
      </div>
      
        <form id="change-profile-name">
          <div id="row">
            <i class="fa-regular fa-user"></i>
            <div id="col">
              <input id="newfName" type="text" :placeholder="this.$store.state.users.firstName" required/>
              <label for="newfName">First Name</label>
            </div>

            <div id="col">
              <input id="newlName" type="text" :placeholder="this.$store.state.users.lastName" required/>
              <label for="newlName">Last Name</label>
            </div>
            <button @click="updateProfile(`name`)">Save Changes</button>
          </div>
        </form>

        <form id="change-profile-pass">
          <div id="row">
              <i class="fa-solid fa-key"></i>
              <div id="col">
                  <input id="currentPass" type="password" required/>
                  <label for="currentPass">Current Password</label>
              </div>

              <div id="col">
                  <input id="newPass" type="password" required/>
                  <label for="newPass">New Password</label>
              </div>
              <button @click="updateProfile(`pass`)">Change Password</button>
          </div>
        </form>
    </div>
  </div>
  <AlertModal :id="`alert-personal-modal`" :errorTitle="changeTitle" :message="changeMsg"/>
  <button id="alert-personal-btn" style="display: none;" data-bs-toggle="modal" data-bs-target="#alert-personal-modal"></button>
</template>

<script>
import AlertModal from '@/components/AlertModal.vue'

export default {
    name: 'PersonalInfo',
    components: {AlertModal},
    data() {
      return {
        changeTitle : "",
        changeMsg : ""
      }
    },
    methods: {
      updateProfile(select) {
        let newFirst = document.querySelector("#newfName").value
        let newLast = document.querySelector("#newlName").value
        let names = [newFirst, newLast]
        const changeName = async () => {
          
          let newNamePayload = {
              "firstName" : newFirst,
              "lastName" : newLast,
              "number" : this.$store.state.users.phone,
              "isSubscribed" : this.$store.state.users.subbed,
              "status" : "ACTIVE",
          }

          await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/updateprofile", {
            method: "PUT",
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(newNamePayload)
          })
          .then((res) => res.json())
          .then((s) => {
            this.changeTitle = "Change Name"
            this.changeMsg = "Name succesfully changed! Name changed to " + s.firstName + " " + s.lastName + "."
            document.querySelector("#newfName").value = ""
            document.querySelector("#newlName").value = ""
            document.querySelector("#newfName").placeholder = s.firstName
            document.querySelector("#newlName").placeholder = s.lastName
            document.querySelector("#alert-personal-btn").click()
          })
          .catch((err) => {console.log("err: " + err);})
        }

        let currentPass = document.querySelector("#currentPass").value
        let newPass = document.querySelector("#newPass").value
        let passes = [currentPass, newPass]
        const changePass = async () => {
          const newPassPayload = {
            "email" : this.$store.state.site.email,
            "password" : currentPass,
            "newPassword" : newPass,
          }
          
          await fetch("http://127.0.0.1:8084/api/test/" + this.$store.state.site.id + "/resetpassword", {
            method: "PUT",
            headers: {
              "Accept": "application/json",
              "Content-Type": "application/json",
            },
            body: JSON.stringify(newPassPayload)
          })
          .then((res) => res.json())
          .then((s) => {
            if (s.process == "failure") {
              throw 'You entered the wrong password. Please try again.'
            } else {
              this.changeTitle = "Change Password"
              this.changeMsg = "Password successfully changed."
              document.querySelector("#currentPass").value = ""
              document.querySelector("#newPass").value = ""
              document.querySelector("#alert-personal-btn").click()
              console.log("Changed pass (when logged in): " + JSON.stringify(s));
            }
          })
          .catch((err) => {
            this.changeTitle = "Change Password"
            this.changeMsg = err
            document.querySelector("#currentPass").value = ""
            document.querySelector("#newPass").value = ""
            document.querySelector("#alert-personal-btn").click()
          })
        }
        
        if (select === "name" && !this.isEmpty(names)) {
          changeName()
        } else if (select === "pass" && !this.isEmpty(passes)) {
          changePass()
        }
      },
      isEmpty(vals) {
        for (let i = 0; i < vals.length; i++) {
          if (vals[i] === "") {
            return true
          }
        }
        return false
      }
    }
}
</script>

<style scoped>
    #user-info-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        text-align: left;
    }

    #info {
      padding: 25px;
      display: flex;
      flex-direction: column;
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

    h3 {
        margin-top: 25px;
    }

    hr {
        margin: 0;
    }

    i {
        font-size: 25px;
        margin: 0 10px;
        height: 20px;
        width: 20px;
    }

    label {
        font-size: 20px;
        padding-right: 10px;
        color: #FBFFF1;
    }

    input {
        width: 200px;
        height: 50px;
        background-color: transparent;
        font-size: 17px;
        border: none;
        border-bottom: solid 4px #FBFFF1;
        outline: none;
        color: #FBFFF1;
        transition: border-color 0.2s ease-in-out;
    }

    input:required {
        border-bottom: solid 4px #FBFFF1;
    }

    input:invalid:focus {
        border-bottom: solid 4px red;
    }
    
    input::placeholder {
      color: #858585ab;
    }

    button {
        padding: 5px;
        margin: 10px 0;
        width: 175px;
        text-decoration: none;
        font-size: 20px;
        text-align: center;
        color: #FBFFF1;
        background-color: transparent;
        border: solid 2px #FBFFF1;
        border-radius: 20px;
        transition: opacity 0.2s ease-in-out;
    }

    button:hover {
        opacity: 0.6;
    }
</style>