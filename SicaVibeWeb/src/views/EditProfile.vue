<script setup lang="ts">
import TextField from '@/components/TextField.vue'
import { useRouter } from 'vue-router'
import { ref } from 'vue'
import {
  validatePassword,
  validatePhone
} from '@/services/validator'

const router = useRouter()
const success = ref(false)
const errorMessagePhone = ref('')
const errorMessage = ref('')

const cancelOnClick = () => {
  router.push({ name: 'hostprofile' })
}

const saveOnClick = async () => {
  const nameField = document.querySelector('#name') as HTMLInputElement
  const nameValue = nameField.value
  const addressField = document.querySelector('#address') as HTMLInputElement
  const addressValue = addressField.value
  const phoneField = document.querySelector('#phone') as HTMLInputElement
  const phoneValue = phoneField.value

  // Reset error messages
  errorMessagePhone.value = ''

  if (
    validatePhone(phoneValue)
  ) {
    success.value = true

    setTimeout(() => {
      router.push({ name: 'hostprofile' })

    }, 2000)
  } else {

    if (!validatePhone(phoneValue)) {
      errorMessagePhone.value += 'The phone number must have 9 digits.'
    }
  }
}
const name = ref<string>('Filipa')
const phone = ref<string>('123456789')
const address = ref<string>('Rua da Filipa')
</script>

<template>
  <div class="outer-container">
    <div class="navbar">
      <div class="circle" />
      <v-app-bar-title class="header-text">SicaVibe</v-app-bar-title>
    </div>
    <div class="page-container">
      <div class="background-rect">
        <div class="register-title">Edit Profile</div>
        <form class="form">
          <div class="fields">
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <label>Name</label>
                <TextField id="name" v-model:value='name'></TextField>
              </div>
              <div class="w-100 d-flex flex-column align-start">
                <label>Phone Number</label>
                <TextField id="phone" maxlength="9" v-model:value='phone'></TextField>
                <div v-if="errorMessagePhone" class="error-message">{{ errorMessagePhone }}</div>
              </div>
            </div>
            <div class="w-100">
              <label>Address</label>
              <TextField id="address" v-model:value='address'></TextField>
            </div>
          </div>
          <div class="button-container">
            <div v-if="errorMessage" class="error-message">
              {{ errorMessage }}
            </div>
            <v-spacer></v-spacer>
            <v-btn class="button2" @click="cancelOnClick">Cancel</v-btn>
            <v-btn class="button" @click="saveOnClick">Save</v-btn>
          </div>
        </form>
      </div>
    </div>
    <transition name="fade">
      <div v-if="success" class="confirmation-overlay">
        <div class="confirmation-message">
            Profile updated successfully!
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
  max-height: 200px;
  width: 100%;
  background-color: #f1f2f4;
  padding: 2rem;
  border-radius: 0.5em;

  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 2rem;
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
  gap: 2rem;
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