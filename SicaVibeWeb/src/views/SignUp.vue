<script setup lang="ts">
import TextField from '@/components/TextField.vue'

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
          <div>
            <form>
              <v-container>
                <v-row class="flex">
                  <v-col class="flex-grow-1">
                    <TextField label="Name"></TextField>
                  </v-col>
                  <v-col class="flex-grow-1">
                    <TextField label="Email"></TextField>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="Address" max-width="5000px"></TextField>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="Birthday"></TextField>
                  </v-col>
                  <v-col>
                    <TextField label="Phone Number"></TextField>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="NIF"></TextField>
                  </v-col>
                  <v-col>
                    <TextField label="CC"></TextField>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col>
                    <TextField label="Password" type="password"></TextField>
                  </v-col>
                  <v-col>
                    <TextField label="Confirm Password" type="password"></TextField>
                  </v-col>
                </v-row>
              </v-container>
            </form>
          </div>
          <div class="button-container">
              <v-btn class="button">Cancel</v-btn>
              <v-btn class="button">Save</v-btn>
          </div>
        </div>
        </v-container>
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
  border-radius: 0.8em;
  background-color: #0D47A1;
}

</style>
