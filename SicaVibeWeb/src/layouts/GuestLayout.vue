<script lang='ts' setup>
import NavBar from '@/components/navbar/NavBar.vue'
</script>

<template >
  <NavBar />
  <div class='content'>
    <div class='content-bg'>
    <router-view />
    </div>
  </div>
</template>

<style scoped>

.content {
  width: 100%;
  height: 100%;
  padding: 6%;
}

.content-bg {
  width: 100%;
  height: 100%;
  background: #f3f3f3;
}


</style>
