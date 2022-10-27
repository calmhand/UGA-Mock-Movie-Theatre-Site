<template>
  <div id="user-info-container">
    <div id="info">  
      <div style="width: 100%;">
        <h3>Personal Info</h3>
        <hr>
      </div>
        <!-- change name form -->
        <form>
          <div id="row">
            <i class="fa-regular fa-user"></i>
            <div id="col">
              <input id="newfName" type="text" required/>
              <label for="newfName">First Name</label>
            </div>

            <div id="col">
              <input id="newlName" type="text" required/>
              <label for="newlName">Last Name</label>
            </div>
            <!-- TODO: Link changeName method -->
            <button>Save Changes</button>
          </div>
        </form>

        <!-- change password form -->
        <form>
          <div id="row">
                <i class="fa-solid fa-key"></i>
                <div id="col">
                    <input id="currentPass" type="password" required/>
                    <label for="currentPass">Password</label>
                </div>

                <div id="col">
                    <input id="newPass" type="password" required/>
                    <label for="newPass">New Password</label>
                </div>
                <!-- TODO: Link changePass method -->
                <button>Change Password</button>
            </div>
        </form>
    </div>
  </div>
</template>

<script>
export default {
    name: 'PersonalInfo',
    methods: {
      changeName() {
        // using fetch, post to api
        let newFirst = document.querySelector("#newfName").value
        let newLast = document.querySelector("#newlName").value
        // eslint-disable-next-line
        let newNamePayload = {
          "firstName" : newFirst,
          "lastName" : newLast,
        }
      },
      changePass() {
        // let currentPass = document.querySelector("#currentPass")
        // let newPass = document.querySelector("#newPass")
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
        font-size: 25px;
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