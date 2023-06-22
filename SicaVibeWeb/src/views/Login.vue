<script lang="ts" setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { Role, useUserStore } from '@/stores/userStore'

const INITIAL_GUEST_ENDPOINT = '/hostprofile' // TODO: Change this to the correct guest endpoint
const INITIAL_RECEPTIONIST_ENDPOINT = '/receptionist/reservations'
const INITIAL_ADMIN_ENDPOINT = '/admin/reservations'

const router = useRouter()

const { user,  login } = useUserStore()

const email = ref('')
const password = ref('')
const errorMessage = ref('')
const isLoggingIn = ref(false)
const loginOnClick = async () => {
  isLoggingIn.value = true

  try {
    const role = await login(email.value, password.value)

    if (role === Role.Admin) await router.push(INITIAL_ADMIN_ENDPOINT)
    else if (role === Role.Receptionist) await router.push(INITIAL_RECEPTIONIST_ENDPOINT)
    else if (role === Role.Guest) await router.push(INITIAL_GUEST_ENDPOINT)
    else await router.push('/login')

  } catch (error) {
    errorMessage.value = error.message // TODO: Improve user readability
  }

  isLoggingIn.value = false
}
</script>
<template>
  <v-app>
    <v-app-bar app color="blue-grey-lighten-5">
      <div class="circle"></div>
      <v-app-bar-title class="header-text" @click.prevent="router.push({ name : 'home'})"> SicaVibe</v-app-bar-title>
    </v-app-bar>
    <v-container class="page-container" fluid>
      <v-row align="center" justify="space-between">
        <v-col class="card-col">
          <v-card class="card-width" variant="outlined">
            <v-sheet class="pa-2 ma-2">
              <v-card-item>
                <v-card-title class="welcome-title text-center">Welcome back!</v-card-title>
                <v-responsive class="mx-auto mt-8" max-width="344">
                  <v-text-field
                    v-model="email"
                    hint="Enter your email to access this website"
                    label="Email"
                    type="input"
                  ></v-text-field>
                </v-responsive>

                <v-responsive class="mx-auto mt-4" max-width="344">
                  <v-text-field
                    v-model="password"
                    hint="Enter your password to access this website"
                    label="Password"
                    type="password"
                  ></v-text-field>
                </v-responsive>
              </v-card-item>

              <router-link class="router-link d-flex justify-center" to="/changepassword">Forgot your password?</router-link>

              <v-card-text class="d-flex justify-center text-red">
                {{ errorMessage }}
              </v-card-text>

              <v-card-text class="d-flex justify-center">
                Don't have an account?
                <router-link class="router-link" to="/signup">Sign up</router-link>
              </v-card-text>

              <v-card-actions class="d-flex justify-center">
                <v-btn :loading="isLoggingIn" class="button" @click="loginOnClick">Login</v-btn>
              </v-card-actions>
            </v-sheet>
          </v-card>
        </v-col>

        <v-col class="card-col">
          <v-card class="card-width" variant="outlined">
            <v-sheet class="pa-2 ma-2">
              <div class="image-gradient"></div>
              <div class="image-container">
                <v-img class="image-fill" contain src="../torreBelem.jpg"></v-img>
              </div>
            </v-sheet>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<style scoped>
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
  margin-left: 25px;
}

.page-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  position: relative;
}

.card-width {
  width: 100%;
  max-width: 550px;
  margin: 0 auto;
  border: none;
}

.image-container {
  position: relative;
  overflow: hidden;
}

.image-gradient {
  position: absolute;
  top: 0;
  left: 0;
  width: 80%;
  height: 120%;
  background-image: linear-gradient(to right, rgba(255, 255, 255, 1), rgba(255, 255, 255, 0));
  z-index: 1;
}

.image-fill {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

.button {
  color: white;
  border-radius: 0.8em;
  background-color: #0d47a1;
}

.welcome-title {
  font-size: 2rem;
  color: #0d47a1;
}

.router-link {
  padding-left: 0.5rem;
  color: lightcoral;
  text-decoration: underline;
  cursor: pointer;
}
</style>
