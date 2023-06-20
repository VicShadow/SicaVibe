<template>
  <v-app-bar :elevation="0" class="nav">
        <div class="circle"></div>
        <v-app-bar-title>
           <h1 class="text-h5" id="header-text"> SicaVibe </h1>
        </v-app-bar-title>
        <v-space></v-space>
        <router-link to="/login">
            <v-btn variant="outlined" class="bt1" rounded="xl" density="comfortable">
                Login
            </v-btn>
        </router-link>
        <router-link to="/signup">
            <v-btn class="bt2" rounded="xl" density="comfortable">
                Sign up
            </v-btn>
        </router-link>
  </v-app-bar>
</template>

<script lang="ts" setup></script>

<style scoped>

    .nav{
        background: unset !important;
    }

    #header-text{
        font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
        font-weight: bolder;
        color: #023E7D;
    }

    .circle {
        width: 20px;
        height: 20px;
        border-radius: 50%;
        background-color: #023E7D;
        margin-left: 1%;
        margin-right: -0.7%;
        padding: 1;
    }

    .bt1{
        background-color: white;
        color:#023E7D;
        margin-left: -25%;
    }

    .bt2{
        background-color: #023E7D;
        color: white;
        margin-left: -10%;
        margin-right: 15%;
    }
    
</style>