<script lang='ts' setup>
import NavBar from '@/components/navbar/NavBar.vue'
</script>

<template>
  <NavBar />
  <div class='content'>
    <router-view />
  </div>
</template>

<style scoped>

.content {
  width: 100%;
  height: 100%;
  padding: 6%;
}


</style>
