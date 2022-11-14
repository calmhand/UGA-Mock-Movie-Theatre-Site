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
      
        <!-- change name form -->
        <form>
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

        <!-- change password form -->
        <form>
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
</template>

<script>
export default {
    name: 'PersonalInfo',
    methods: {
      updateProfile(select) {
        const changeName = async () => {
          let newFirst = document.querySelector("#newfName").value
          let newLast = document.querySelector("#newlName").value
          let newNamePayload = {
              "firstName" : newFirst,
              "lastName" : newLast,
              "number" : this.$store.state.users.street,
              "isSubscribed" : this.$store.state.users.subbed,
              "status" : "ACTIVE",
              "userType" : "CUSTOMER"
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
          .then((result) => {
            alert("Name succesfully changed!")
            console.log("Name change result: " + JSON.stringify(result));
          })
          .catch((err) => {console.log("err: " + err);})
        }

        const changePass = async () => {
          let currentPass = document.querySelector("#currentPass").value
          let newPass = document.querySelector("#newPass").value
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
          .then((result) => {
            alert("Password succesfully changed!")
            document.querySelector("#currentPass").value = ""
            document.querySelector("#newPass").value = ""
            console.log("Changed pass (when logged in): " + JSON.stringify(result));
          })
          .catch((err) => {console.log("err: " + err);})
        }
        
        if (select === "name") {
          changeName()
        } else if (select === "pass") {
          changePass()
        }
      },
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
      color: #FBFFF1;
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