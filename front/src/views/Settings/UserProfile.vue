<template>
  <div class="profile_page_container">
    <div id="settings-container">
        <div id="settings-opt-container">
            <a @click="changeDisplay('#user-info-container', 1)" id="opt-btn">Personal Info</a>
            <a @click="changeDisplay('#address-info-container', 2)" id="opt-btn">Address</a>
            <a @click="changeDisplay('#payment-info-container', 3)" id="opt-btn">Payment</a>
            <a @click="changeDisplay('#promo-info-container', 4)" id="opt-btn">Manage Promotions</a>
        </div>
        <div id="vertical-line"></div>
        <div id="settings-info-container">
            <PersonalInfo />
            <AddressInfo />
            <PaymentInfo />
            <PromoInfo />
        </div>
    </div>
  </div>
</template>

<script>
import PersonalInfo from '@/components/SettingsComponents/PersonalInfo.vue'
import AddressInfo from '@/components/SettingsComponents/AddressInfo.vue'
import PaymentInfo from '@/components/SettingsComponents/PaymentInfo.vue'
import PromoInfo from '../../components/SettingsComponents/PromoInfo.vue'


export default {
    name: "UserProfile",
    props: ['userId', 'email', 'username', 'address'],
    components: { PersonalInfo, AddressInfo, PaymentInfo, PromoInfo},
    methods: {
        displayOrders() {
            this.$router.push({name: 'UserOrders', params: {userId: this.userId}})
        },
        clearStyles() {
            document.querySelector('#user-info-container').style.display = 'none'
            document.querySelector('#address-info-container').style.display = 'none'
            document.querySelector('#payment-info-container').style.display = 'none'
            document.querySelector('#promo-info-container').style.display = 'none'
            for (let i = 1; i < 5; i++) {
                var btn = document.querySelector('#settings-opt-container a:nth-child('+ i + ')')
                btn.style.color = '#FBFFF1'
                btn.style.textDecoration = 'none'
            }
        },
        changeDisplay(show, btnChild) {
            var window = document.querySelector(show)
            var btn = document.querySelector('#settings-opt-container a:nth-child('+ btnChild + ')')

            this.clearStyles()
            window.style.display = 'flex'
            btn.style.color = '#6061c8'
            btn.style.textDecoration = 'underline'
        }
    }

}
</script>

<style scoped>
    .profile_page_container {
        height: 100vh;
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;
    }

    #settings-container {
        display: flex;
        flex-direction: row;
        justify-content: center;
        align-items: center;

        height: 90%;
        width: 90%;

        background-color: rgba(0, 0, 0, 0.5);
        border-radius: 10px;
    }

    #settings-opt-container {
        display: flex;
        flex-direction: column;
        justify-content: center;
        width: 150px;
        height: 80%;
        font-size: 1.15em;
    }

    #vertical-line {
        height: 80%;
        margin: 0 50px;
        border-right: solid 2px #FBFFF1;
        border-radius: 20%;
        opacity: 0.4;
    }

    #settings-info-container {
        width: 60%;
        height: 80%;
    }

    button {
        width: 120px;
        height: 35px;
        border: solid 4px #FBFFF1;
        border-radius: 10px;
        margin-top: 25px;
        text-align: center;
        transition: opacity 0.2s ease-in-out;
    }

    button:hover {
        opacity: 0.7;
    }

    #opt-btn {
        text-align: left;
        margin: 15px 0;
        transition: opacity 0.2s ease-in-out;
    }

    #opt-btn:hover {
        opacity: 0.5;
        cursor: pointer;
    }
</style>