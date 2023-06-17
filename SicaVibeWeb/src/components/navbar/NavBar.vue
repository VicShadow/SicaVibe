<script lang="ts" setup></script>

<template>
  <v-app-bar :elevation="0" image="/torreBelem.jpg">
    <template v-slot:image>
      <v-img
        gradient="to top right"
        style="
           {
            max-height: 100%;
            max-width: 100%;
          }
        "
      ></v-img>
    </template>
    <div class="circle"></div>
    <v-app-bar-title class="header-text"> SicaVibe</v-app-bar-title>
    <v-space></v-space>
    <router-link to="/login">
      <v-btn class="bt1" density="comfortable" rounded="xl" variant="outlined"> Login</v-btn>
    </router-link>
    <router-link to="/signup">
      <v-btn class="bt2" density="comfortable" rounded="xl"> Sign up</v-btn>
    </router-link>
  </v-app-bar>
</template>

<style scoped>
.header-text {
  font-weight: bolder;
  font-size: 2rem;
  color: #023e7d;
}

.circle {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #023e7d;
  margin-left: 10px;
  margin-right: -7px;
}

.bt1 {
  background-color: white;
  color: #023e7d;
  margin-right: 10px;
}

.bt2 {
  background-color: #023e7d;
  color: white;
}
</style>
