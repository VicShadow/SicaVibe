<script lang="ts" setup></script>

<template>
  <v-app-bar :elevation="0" image="/torreBelem.jpg">
        <template v-slot:image>
            <v-img
              style="{max-height:100%; max-width:100%;}"
              gradient="to top right"
            ></v-img>
        </template>
        <div class="circle"></div>
        <v-app-bar-title class="header-text">
            SicaVibe
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

<style scoped>
    .header-text{
        font-weight: bolder;
        font-size: 2rem;
        color: #023E7D;
    }

    .circle {
        width: 30px;
        height: 30px;
        border-radius: 50%;
        background-color: #023E7D;
        margin-left: 10px;
        margin-right: -7px;
        padding: 1;
    }

    .bt1{
        background-color: white;
        color:#023E7D;
        margin-right: 10px;
    }

    .bt2{
        background-color: #023E7D;
        color: white;
    }
    
</style>