<script lang="ts" setup>
import { useRouter } from 'vue-router'
import { ref } from 'vue'

const router = useRouter()

const logoutOnClick = async () => {
  router.push('/')
}

const user = {
    "email" : "hospede9@gmail.com",
    "password" : "Password.123",
    "nome" : "Joana Alves",
    "numTelemovel" : "123456780",
    "dataNascimento" : "15/05/2001",
    "morada" : "Rua da Joana, nº(-1)",
    "cc" : "100100108",
    "nif" : "100100108"
}

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
                  <v-row>
                    <v-col cols="8">
                      <v-img class="user-img" contain src="../user_button.jpg"></v-img>
                      <h2 class="name">{{  user.nome }}</h2>
                    </v-col>
                    <v-col cols="4">
                      <v-btn class="edit-button">
                        <v-img class="image-fill-2" contain src="../edit_button.jpg"></v-img>
                      </v-btn>
                    </v-col>
                  </v-row>
                  <div class="profile-fields">
                    <label class="field">Email</label>
                    <label class="field-text">{{  user.email }}</label>
                    <label class="field">Address</label>
                    <label class="field-text">{{  user.morada }}</label>
                    <label class="field">Birthday</label>
                    <label class="field-text">{{  user.dataNascimento }}</label>
                    <label class="field">Phone Number</label>
                    <label class="field-text">{{  user.numTelemovel }}</label>
                    <label class="field">NIF</label>
                    <label class="field-text">{{  user.nif }}</label>
                    <label class="field">CC</label>
                    <label class="field-text">{{  user.cc }}</label>
                  </div>
                  <div class="button-container">
                    <v-btn class="button-delete">Delete Account</v-btn>
                  </div>
                </div>
            </div>
            <div class="reservations">
                <label class="subtitle-text">Reservations</label>
                <div class="background-rect2">
                    
                </div>

            </div>
        </div>
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
.edit-button {
  background-color: transparent !important;
  box-shadow: none !important;
  display: flex;
  justify-content: flex-start;
  max-height: 100px;
  max-width: 100px;
  margin: auto;
}



</style>
  