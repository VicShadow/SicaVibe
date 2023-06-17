<script setup lang="ts">
import TextField from '@/components/TextField.vue'
import { useRouter } from 'vue-router'
import { ref } from 'vue'

const router = useRouter()
const isSaved = ref(false)
const errorMessageNif = ref('')
const errorMessageCC = ref('')
const errorMessagePhone = ref('')
const errorMessageBirthday = ref('')
const errorMessagePassword = ref('')
const errorMessageConfirmPassword = ref('')

const login = () => {
  router.push({ name: 'login' })
}

const saveData = () => {
const nifField = document.querySelector('#nif') as HTMLInputElement
const nifValue = nifField.value
const ccField = document.querySelector('#cc') as HTMLInputElement
const ccValue = ccField.value
const phoneField = document.querySelector('#phone') as HTMLInputElement
const phoneValue = phoneField.value
const birthdayField = document.querySelector('#birthday') as HTMLInputElement
const birthdayValue = birthdayField.value
const passwordField = document.querySelector('#password') as HTMLInputElement
const passwordValue = passwordField.value
const confirmPasswordField = document.querySelector('#confirmPassword') as HTMLInputElement
const confirmPasswordValue = confirmPasswordField.value


errorMessageNif.value = ''
errorMessageCC.value = ''
errorMessagePhone.value = ''
errorMessageBirthday.value = ''
errorMessagePassword.value = ''
errorMessageConfirmPassword.value = ''

const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]).{8,}$/

if (nifValue.length === 9 && /^\d+$/.test(nifValue) && ccValue.length === 8 && /^\d+$/.test(ccValue) 
    && phoneValue.length === 9 && /^\d+$/.test(phoneValue)
    && /^\d{2}\/\d{2}\/\d{4}$/.test(birthdayValue) && passwordRegex.test(passwordValue) &&
    passwordValue === confirmPasswordValue) {

  isSaved.value = true

  setTimeout(() => {
    router.push({ name: 'login' })
  }, 2000)
} else {
  if (nifValue.length !== 9 || !/^\d+$/.test(nifValue)) {
    errorMessageNif.value += 'The NIF must have 9 digits'
  }

  if (ccValue.length !== 8 || !/^\d+$/.test(ccValue)) {
    errorMessageCC.value += 'The CC must have 8 digits.'
  }

  if (phoneValue.length !== 9 || !/^\d+$/.test(phoneValue)) {
    errorMessagePhone.value += 'The phone number must have 9 digits.'
  }

  if (!/^\d{2}\/\d{2}\/\d{4}$/.test(birthdayValue)) {
    errorMessageBirthday.value = 'The date not valid.'
  }

  if (!passwordRegex.test(passwordValue)) {
      errorMessagePassword.value = 'The password must have at least 8 characters, one uppercase letter, one lowercase letter, and one special character.'
    }

  if (passwordValue !== confirmPasswordValue) {
    errorMessageConfirmPassword.value = 'The passwords do not match.'
  }
}
}
</script>

<template>
<v-app>
      <v-app-bar app color="blue-grey-lighten-5">
          <div class="circle"></div>
          <v-app-bar-title class="header-text">
              SicaVibe
          </v-app-bar-title>
      </v-app-bar>
      <v-container fluid class="page-container">
        <div class="background-rect">
          <div class="register-title">Register</div>
          <div class="form">
            <form>
              <v-container>
                <v-row>
                  <v-col>
                    <label>Name</label>
                    <TextField label="Name"></TextField>
                  </v-col>
                  <v-col>
                    <TextField label="Email"></TextField>
                  </v-col>
                </v-row>
                <v-row class="address">
                    <TextField label="Address" max-width="500px"></TextField>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="Birthday" type="date" id="birthday"></TextField>
                    <div class="error-message" v-if="errorMessageBirthday">{{ errorMessageBirthday }}</div>
                  </v-col>
                  <v-col>
                    <TextField label="Phone Number" id="phone"></TextField>
                    <div class="error-message" v-if="errorMessagePhone">{{ errorMessagePhone }}</div>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="NIF" id="nif"></TextField>
                    <div class="error-message" v-if="errorMessageNif">{{ errorMessageNif }}</div>
                  </v-col>
                  <v-col>
                    <TextField label="CC" id="cc"></TextField>
                    <div class="error-message" v-if="errorMessageCC">{{ errorMessageCC }}</div>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="Password" type="password" id="password"></TextField>
                    <div class="error-message" v-if="errorMessagePassword">{{ errorMessagePassword }}</div>
                  </v-col>
                  <v-col>
                    <TextField label="Confirm Password" type="password" id="confirmPassword"></TextField>
                    <div class="error-message" v-if="errorMessageConfirmPassword">{{ errorMessageConfirmPassword }}</div>
                  </v-col>
                </v-row>
              </v-container>
            </form>
          </div>
          <div class="button-container">
              <v-spacer></v-spacer>
              <v-btn class="button2" @click="login">Cancel</v-btn>
              <v-btn class="button" @click="saveData">Register</v-btn>
          </div>
        </div>
        </v-container>
        <transition name="fade">
          <div v-if="isSaved" class="confirmation-overlay">
            <div class="confirmation-message">Account created successfully! Login to start using our platform</div>
          </div>
        </transition>
    </v-app>>
</template>


<style scoped>

.header-text {
  font-weight: bold;
  font-size: 2.1rem;
  color: #0D47A1;
}

.circle {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #0D47A1;
  margin-left: 25px;
  padding: 1;
}

.page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.register-title {
  font-weight: bold;
  font-size: 1.5rem;
  color: #0D47A1;
  text-align: center;
  margin-bottom: 5px;
}

.background-rect {
  width: 650px; 
  height: 450px;
  background-color: #ECEFF1;
  padding: 10px;
  margin-top: 2%;
  border-radius: 0.8em;
}

.button-container {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}


.button {
  margin-right: 0.5rem;
  color: white;
  background-color: #0D47A1;
}

.button2 {
  margin-right: 0.5rem;
  color: #0D47A1;
  background-color: white;
}

.form {
  text-align: center;
}

.address {
  padding-left: 3.7rem;
  padding-top: 1rem;
  padding-bottom: 1rem;
}

.confirmation-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
}

.confirmation-message {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
}

.error-message {
  color: red;
  font-size: 0.9rem;
  margin-top: 5px;
}
</style>

