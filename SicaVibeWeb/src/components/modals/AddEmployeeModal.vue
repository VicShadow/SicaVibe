<script lang="ts" setup>
import { ref, toRefs } from 'vue'
import TextField from '@/components/TextField.vue'
import {
  validateCC,
  validateDate,
  validateEmail,
  validateNif,
  validatePassword,
  validatePhone
} from '@/services/validator'
import { type RegisterEmployeeProps, registerEmployee } from '@/services/backend/admin/registerFuncionario'
import { formatDateBackend } from '@/services/formatter'
import { getHoteis } from '@/services/backend/hoteis/getHoteis'
import type { Hotel } from '@/types/Hotel'

interface Props {
  isModalOpen: boolean
}

const props = defineProps<Props>()

const emits = defineEmits(['close'])

const { isModalOpen } = toRefs(props)

const loading = ref(false)

const success = ref(false)
const errorMessageEmail = ref('')
const errorMessageNif = ref('')
const errorMessageCC = ref('')
const errorMessagePhone = ref('')
const errorMessageBirthday = ref('')
const errorMessagePassword = ref('')
const errorMessageConfirmPassword = ref('')
const errorMessage = ref('')
const errorMessageHotel = ref('')
const hotelid = ref("")

const hoteis = ref<Hotel[]>([])
getHoteis().then(res => hoteis.value = res)
success.value = false

async function registerFunc (props: RegisterEmployeeProps) {
  try {
    const res = await registerEmployee({
      ...props,
      birthday: formatDateBackend(new Date(props.birthday))
    })

    if (res) return true
    else return false

  } catch (error) {
    errorMessage.value = error.message // TODO: Improve user readability

    return false
  }
}

const registerOnClick = async () => {
  const nameField = document.querySelector('#name') as HTMLInputElement
  const nameValue = nameField.value
  const nifField = document.querySelector('#nif') as HTMLInputElement
  const nifValue = nifField.value
  const emailField = document.querySelector('#email') as HTMLInputElement
  const emailValue = emailField.value
  const addressField = document.querySelector('#address') as HTMLInputElement
  const addressValue = addressField.value
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
  errorMessageHotel.value = ''

  if (
    validateNif(nifValue) &&
    validateEmail(emailValue) &&
    validateCC(ccValue) &&
    validatePhone(phoneValue) &&
    validateDate(birthdayValue) &&
    validatePassword(passwordValue) &&
    passwordValue === confirmPasswordValue &&
    hotelid.value != ""
  ) {

    const registrationSuccess = registerFunc({
      email: emailValue,
      password: passwordValue,
      nome: nameValue,
      mobileNumber: phoneValue,
      birthday: birthdayValue,
      address: addressValue,
      cc: ccValue,
      nif: nifValue,
      hotelID: Number(hotelid.value)
    })

    if (!registrationSuccess) return
    success.value = true

    setTimeout(() => {
        emits('close')
    }, 1000);

  } else {
    if (!validateNif(nifValue)) {
      errorMessageNif.value += 'The NIF must have 9 digits'
    }

    if (!validateEmail(emailValue)) {
      errorMessageEmail.value += 'The email is not valid.'
    }

    if (!validateCC(ccValue)) {
      errorMessageCC.value += 'The CC must have 8 digits.'
    }

    if (!validatePhone(phoneValue)) {
      errorMessagePhone.value += 'The phone number must have 9 digits.'
    }

    if (!validateDate(birthdayValue)) {
      errorMessageBirthday.value = 'The date not valid.'
    }

    if (!validatePassword(passwordValue)) {
      errorMessagePassword.value =
        'The password must have at least 8 characters, one uppercase letter, one lowercase letter, and one special character.'
    }

    if (passwordValue !== confirmPasswordValue) {
      errorMessageConfirmPassword.value = 'The passwords do not match.'
    }

    if (hotelid.value.length <= 0) errorMessageHotel.value = "Please select a Hotel for the employee."
  }
}
</script>

<template>
    <v-dialog v-model="isModalOpen" max-width="600px">
        <div class="pa-6 card bg-white rounded-sm">
        <v-card-title class="pa-0">
            <span class="text-h5">Add New Employee</span>
        </v-card-title>
        <form class="form">
          <div class="fields">
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <label>Name</label>
                <TextField id="name" label=""></TextField>
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
              <label>Address</label>
              <TextField id="address" label=""></TextField>
            </div>
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <label>Birthday</label>
                <TextField id="birthday" label="" type="date"></TextField>
                <div v-if="errorMessageBirthday" class="error-message">
                  {{ errorMessageBirthday }}
                </div>
              </div>
              <div class="w-100 d-flex flex-column align-start">
                <label>Phone Number</label>
                <TextField id="phone" label="" maxlength="9"></TextField>
                <div v-if="errorMessagePhone" class="error-message">{{ errorMessagePhone }}</div>
              </div>
            </div>
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <label>NIF</label>
                <TextField id="nif" label="" maxlength="9"></TextField>
                <div v-if="errorMessageNif" class="error-message">{{ errorMessageNif }}</div>
              </div>
              <div class="w-100 d-flex flex-column align-start">
                <label>CC</label>
                <TextField id="cc" label="" maxlength="8"></TextField>
                <div v-if="errorMessageCC" class="error-message">{{ errorMessageCC }}</div>
              </div>
            </div>
            <div class="field-col">
              <div class="w-100 d-flex flex-column align-start">
                <label>Password</label>
                <TextField id="password" label="" type="password"></TextField>
                <div v-if="errorMessagePassword" class="error-message">
                  {{ errorMessagePassword }}
                </div>
              </div>
              <div class="w-100 d-flex flex-column align-start">
                <label>Confirm Password</label>
                <TextField id="confirmPassword" label="" type="password"></TextField>
                <div v-if="errorMessageConfirmPassword" class="error-message">
                  {{ errorMessageConfirmPassword }}
                </div>
              </div>
            </div>
          </div>
          <div class="button-container">
            <div v-if="errorMessage" class="error-message">
              {{ errorMessage }}
            </div>

            <div>
                <label for="hotel">Hotel:</label>
                <select name="hotel" id="hotelid" v-model="hotelid" required>
                    <option v-for="hotel in hoteis" :key="hotel.id" :value="hotel.id">{{ hotel.nome }}</option>
                </select>
                <div v-if="errorMessageHotel" class="error-message">
                  {{ errorMessageHotel }}
                </div>
            </div>
            <v-spacer></v-spacer>
          </div>
        </form>

        <div v-if="success" class="sucessMessage">Employed created with success!</div>

        <v-card-actions class="pa-0 w-100 d-flex justify-end">
            <v-btn
            class="cancel-btn"
            variant="text"
            @click="$emit('close')">
                Cancel
            </v-btn>
            <v-btn :loading="loading" class="add-btn" @click="registerOnClick">Register</v-btn>
        </v-card-actions>
        </div>

    </v-dialog>



</template>

<style scoped>
select {
    margin-left: 5px;
    border: 2px solid rgba(9, 30, 66, 0.141176);
    background: #ffffff;
    border-radius: 3px;
    padding: 6px 8px;
    box-sizing: border-box;
}
select:focus-visible,
select:focus {
  outline: none;
  box-shadow: none;
}

select:hover {
  background: #f7f8f9;
}

.page-container {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.background-rect {
  max-width: 1000px;
  max-height: 800px;
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
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
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

.card {
  display: flex;
  flex-direction: column;
  align-items: start;
  justify-content: start;
  gap: 1.5rem;
}

.fields {
  display: flex;
  flex-direction: column;
  align-items: start;
  justify-content: start;
  gap: 1rem;
  width: 100%;
}

.cancel-btn {
  text-transform: capitalize;
}

.add-btn {
  color: white;
  background: #0c66e4;
  text-transform: capitalize;
}

.sucessMessage {
    color: green;
    font-weight: bold;
}
</style>
