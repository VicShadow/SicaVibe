<template>
    <v-app id="page">
      <NavBar/>
      <Footer></Footer>
    </v-app>
</template>

<script lang="ts" setup>
  import NavBar from '@/components/NavBar.vue'
  import Footer from '@/components/Footer.vue'
</script>

<style scoped>
  #page{
    position: relative;
    min-height: 100vh;
  }
</style>
  
