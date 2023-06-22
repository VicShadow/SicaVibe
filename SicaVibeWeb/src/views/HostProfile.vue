<script lang="ts" setup>
import { useRouter } from 'vue-router'
import { ref } from 'vue'
import CurrentPasswordModal from '@/components/modals/CurrentPasswordModal.vue'
import DeleteModal from '@/components/modals/DeleteModal.vue'
import { useUserStore, type User } from '@/stores/userStore';
import { deleteAccount } from '@/services/backend/auth/deleteAccount';
import type { Token } from '@/types/Token';
import { login } from '@/services/backend/auth/login';
import HostReservationCard from '@/components/HostReservationCard.vue'


const router = useRouter()

const { user} = useUserStore()


const isChangePassordModalOpen = ref(false)
const isDeleteAccountModalOpen = ref(false)
const errorMessageCurrentPassword = ref('')


const logoutOnClick = async () => {
  router.push('/')
}

const editOnClick = async () => {
  router.push('/edit')
}

errorMessageCurrentPassword.value = ''

const changePasswordOnClick = async () => {
  const currentPasswordField = document.querySelector('#currentPassword') as HTMLInputElement
  const currentPasswordValue = currentPasswordField.value
  console.log(currentPasswordValue)

  try { 
    await login({email: user.email, password: currentPasswordValue}) 
  } catch {
    errorMessageCurrentPassword.value = 'The current password is incorrect. Please try again.'
  }

  isChangePassordModalOpen.value = false
  router.push('/changepassword')
}


const openChangePasswordModal = () => {
  isChangePassordModalOpen.value = true
}

const openDeleteAccountModal = () => {
  isDeleteAccountModalOpen.value = true
}

const deleteAccountHandler = () => {
  deleteAccount((user as User).token) 
  isChangePassordModalOpen.value = false
  router.push('/home')
}


const reservations = [
  {
    "id" : "1",
    "guestId" : "2",
    "guestName" : "Filipa",
    "inDate" : "10/10/2001",
    "outDate" : "11/10/2001",
    "price" : "100",
    "status" : "Scheduled",
    "rooms" : [],
    "services" : []
  },
  {
    "id" : "1",
    "guestId" : "2",
    "guestName" : "Filipa",
    "inDate" : "10/10/2023",
    "outDate" : "11/10/2001",
    "price" : "100",
    "status" : "On going",
    "rooms" : [],
    "services" : []
  },
  {
    "id" : "1",
    "guestId" : "2",
    "guestName" : "Filipa",
    "inDate" : "10/10/2001",
    "outDate" : "11/10/2001",
    "price" : "100",
    "status" : "Done",
    "rooms" : [],
    "services" : []
  }
];


</script>

<template>
    <div class="outer-container">
        <div class="navbar">
            <div class="circle" />
            <v-app-bar-title class="header-text">SicaVibe</v-app-bar-title>
            <v-btn class="button" @click="logoutOnClick">Logout</v-btn>
            <v-img class="image-fill" contain src="../user_button.jpg"></v-img>
        </div>
        <div class="page-container">
            <div class="profile">
                <label class="subtitle-text">Profile</label>
                <div class="background-rect">
                  <v-row class="align-right">
                  <div>
                      <v-menu open-on-hover>
                        <template v-slot:activator="{ props }">
                          <v-btn v-bind="props">
                            <v-img class="image-fill-2" contain src="../menu_button.jpg"></v-img>
                          </v-btn>
                        </template>
                        <v-list>
                          <v-row class="fill-height">
                            <v-btn class="fill-width lowercase-text" @click="editOnClick">Edit Profile</v-btn>
                          </v-row>
                          <v-row class="fill-height">
                            <v-btn class="fill-width lowercase-text" 
                                  :ripple="false"
                                  @click="openChangePasswordModal">Change Password</v-btn>
                          </v-row>
                        </v-list>
                      </v-menu>
                    </div>
                  </v-row>
                  <v-row>
                    <v-img class="user-img" contain src="../user_button.jpg"></v-img>
                  </v-row>
                  <div v-if="user">
                    <h2 class="name">{{  user.name }}</h2>
                    <div class="profile-fields">
                      <label class="field">Email</label>
                      <label class="field-text">{{  user.email }}</label>
                      <label class="field">Address</label>
                      <label class="field-text">{{  user.address }}</label>
                      <label class="field">Birthday</label>
                      <label class="field-text">{{  user.birthDate}}</label>
                      <label class="field">Phone Number</label>
                      <label class="field-text">{{  user.phoneNumber }}</label>
                      <label class="field">NIF</label>
                      <label class="field-text">{{  user.nif }}</label>
                      <label class="field">CC</label>
                      <label class="field-text">{{  user.cc }}</label>
                    </div>
                  </div>
                  <div class="button-container">
                    <v-btn class="button-delete" 
                          :ripple="false"
                          @click="openDeleteAccountModal">Delete Account</v-btn>
                  </div>
                </div>
            </div>
            <div class="reservations">
                <label class="subtitle-text">Reservations</label>
                <div class="background-rect2">
                  <div class="background-rect2">
                    <HostReservationCard v-for="reservation in reservations" :key="reservation.id" :reservation="reservation" />
                  </div>
                </div>
            </div>
        </div>
    </div>
    <CurrentPasswordModal
    v-model:is-open="isChangePassordModalOpen"
    :is-open="isChangePassordModalOpen"
    title="Current Password"
    input="password"
    type="password"
    @cancel="isChangePassordModalOpen = false"
    @confirm="changePasswordOnClick"
    :error-message-current-password="errorMessageCurrentPassword"
    />
    <DeleteModal
    v-model:is-open="isDeleteAccountModalOpen"
    :is-open="isDeleteAccountModalOpen"
    message="Are you sure you want to delete the account?"
    title="Delete Account"
    @cancel="isDeleteAccountModalOpen = false"
    @confirm="deleteAccountHandler"
  />

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
  align-items: center;
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

.subtitle-text {
  font-weight: bold;
  font-size: 1.7rem;
  color: #0d47a1;
}

.circle {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #0d47a1;
}

.profile-fields {
  display: flex;
  flex-direction: column;
  justify-content: center;
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

.button {
  color: white;
  background-color: #0d47a1;
}

.image-fill {
  max-height: 40px;
  max-width: 40px;
}
.image-fill-2 {
  max-height: 30px;
  max-width: 30px;
}
.user-img {
  display: flex;
  justify-content: center;
  align-items: center;
  max-height: 100px;
  max-width: 100px;
  margin: auto;
}

.name {
  font-weight: bold;
  display: flex;
  justify-content: center;
  align-items: center;
}

.field {
  font-weight: bold;
  margin-top: 1.5rem;
  line-height: 0.1; 
}

.field-text {
  line-height: 3; 
}

.background-rect2 {
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

.page-container {
  display: flex;
  gap: 2rem;
}

.profile {
  flex: 1;
}

.reservations {
  flex: 2;
}

.button-delete {
  margin-top: auto; 
  color: white;
  background-color: #E53935;
  width: 300px;
}

.button-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: auto; 
}

.align-right {
  margin-left: auto;
}

.fill-height {
  height: 100%;
}

.fill-width {
  width: 100%;
}

.lowercase-text {
  text-transform: lowercase;
}


</style>
  


           