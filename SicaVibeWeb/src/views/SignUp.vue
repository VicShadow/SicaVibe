<script setup lang="ts">
import TextField from '@/components/TextField.vue'
import { useRouter } from 'vue-router'
import { ref } from 'vue'
import { dateValidator } from '@/services/validator'

const router = useRouter()
const isSaved = ref(false)
const errorMessageEmail = ref('')
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
  const emailField = document.querySelector('#email') as HTMLInputElement
  const emailValue = emailField.value
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

  // Reset error messages
  errorMessageNif.value = ''
  errorMessageEmail.value = ''
  errorMessageCC.value = ''
  errorMessagePhone.value = ''
  errorMessageBirthday.value = ''
  errorMessagePassword.value = ''
  errorMessageConfirmPassword.value = ''

  const passwordRegex =
    /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]).{8,}$/

  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

  if (
    nifValue.length === 9 &&
    /^\d+$/.test(nifValue) &&
    emailValue.length > 0 &&
    emailRegex.test(emailValue) &&
    ccValue.length === 8 &&
    /^\d+$/.test(ccValue) &&
    phoneValue.length === 9 &&
    /^\d+$/.test(phoneValue) &&
    /^\d{2}\/\d{2}\/\d{4}$/.test(birthdayValue) &&
    passwordRegex.test(passwordValue) &&
    passwordValue === confirmPasswordValue
  ) {
    isSaved.value = true

    setTimeout(() => {
      router.push({ name: 'login' })
    }, 2000)
  } else {
    if (nifValue.length !== 9 || !/^\d+$/.test(nifValue)) {
      errorMessageNif.value += 'The NIF must have 9 digits'
    }

    if (emailValue.length === 0 || !emailRegex.test(emailValue)) {
      errorMessageEmail.value += 'The email is not valid.'
    }

    if (ccValue.length !== 8 || !/^\d+$/.test(ccValue)) {
      errorMessageCC.value += 'The CC must have 8 digits.'
    }

    if (phoneValue.length !== 9 || !/^\d+$/.test(phoneValue)) {
      errorMessagePhone.value += 'The phone number must have 9 digits.'
    }

    if (!dateValidator(birthdayValue)) {
      errorMessageBirthday.value = 'The date not valid.'
    }

    if (!passwordRegex.test(passwordValue)) {
      errorMessagePassword.value =
        'The password must have at least 8 characters, one uppercase letter, one lowercase letter, and one special character.'
    }

    if (passwordValue !== confirmPasswordValue) {
      errorMessageConfirmPassword.value = 'The passwords do not match.'
    }
  }
}
</script>

<template>
  <div class="outer-container">
    <div class="navbar">
      <div class="circle" />
      <v-app-bar-title class="header-text">SicaVibe</v-app-bar-title>
    </div>
    <div class="page-container">
      <div class="background-rect">
        <div class="register-title">Register</div>
        <form class="form">
          <div class="fields">
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <label>Name</label>
                <TextField label=""></TextField>
              </div>
              <div class="w-100 d-flex flex-column align-start">
                <label>Email</label>
                <TextField id="email" label=""></TextField>
                <div v-if="errorMessageEmail" class="error-message">
                  {{ errorMessageEmail }}
                </div>
              </div>
            </div>
            <div class="w-100">
              <TextField label="Address"></TextField>
            </div>
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <TextField id="birthday" label="Birthday" type="date"></TextField>
                <div v-if="errorMessageBirthday" class="error-message">
                  {{ errorMessageBirthday }}
                </div>
              </div>
              <div class="d-flex flex-column align-start">
                <TextField id="phone" label="Phone Number" maxlength="9"></TextField>
                <div v-if="errorMessagePhone" class="error-message">{{ errorMessagePhone }}</div>
              </div>
            </div>
            <div class="field-col">
              <div class="d-flex flex-column align-start">
                <TextField id="nif" label="NIF" maxlength="9"></TextField>
                <div v-if="errorMessageNif" class="error-message">{{ errorMessageNif }}</div>
              </div>
              <div class="d-flex flex-column align-start">
                <TextField id="cc" label="CC" maxlength="8"></TextField>
                <div v-if="errorMessageCC" class="error-message">{{ errorMessageCC }}</div>
              </div>
            </div>
            <div class="field-col">
              <div class="d-flex flex-column align-start">
                <TextField id="password" label="Password" type="password"></TextField>
                <div v-if="errorMessagePassword" class="error-message">
                  {{ errorMessagePassword }}
                </div>
              </div>
              <div class="d-flex flex-column align-start">
                <TextField
                  id="confirmPassword"
                  label="Confirm Password"
                  type="password"
                ></TextField>
                <div v-if="errorMessageConfirmPassword" class="error-message">
                  {{ errorMessageConfirmPassword }}
                </div>
              </div>
            </div>
          </div>
          <div class="button-container">
            <v-spacer></v-spacer>
            <v-btn class="button2" @click="login">Cancel</v-btn>
            <v-btn class="button" @click="saveData">Register</v-btn>
          </div>
        </form>
      </div>
    </div>
    <transition name="fade">
      <div v-if="isSaved" class="confirmation-overlay">
        <div class="confirmation-message">
          Account created successfully! Login to start using our platform
        </div>
      </div>
    </transition>
  </div>
</template>

<style scoped>
.outer-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 100vh;
}

.navbar {
  display: flex;
  flex-direction: row;
  gap: 1rem;
  padding: 1rem 2rem;
  max-height: 100px;
  background: #eceff1;
}

.header-text {
  font-weight: bold;
  font-size: 2.1rem;
  color: #0d47a1;
}

.circle {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #0d47a1;
}

.page-container {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.register-title {
  font-weight: bold;
  font-size: 1.5rem;
  color: #0d47a1;
  text-align: center;
}

.background-rect {
  max-width: 1000px;
  max-height: 800px;
  width: 100%;
  background-color: #eceff1;
  padding: 2rem;
  border-radius: 0.8em;
}

.button-container {
  width: 100%;
  display: flex;
  justify-content: flex-end;
  gap: 1rem;
}

.button {
  color: white;
  background-color: #0d47a1;
}

.button2 {
  color: #0d47a1;
  background-color: white;
}

.form {
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: start;
  gap: 2rem;
}

.fields {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: start;
  gap: 1rem;
}

.field-col {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: start;
  width: 100%;
  gap: 1rem;
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
}
</style>
