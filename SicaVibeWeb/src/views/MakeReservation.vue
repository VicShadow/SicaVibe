<script setup lang='ts'>

import Steps from '@/components/Steps.vue'
</script>

<template>
  <div class='container'>
    <Steps :num='3' :current='1' />
  </div>
</template>

<style scoped>

.container {
  padding: 4%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
}
</style>
