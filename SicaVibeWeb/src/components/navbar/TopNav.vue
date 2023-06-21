<script lang="ts" setup>
import { useUserStore } from '@/stores/userStore'

const {
  user: { name }
} = useUserStore()
</script>

<template>
  <div class="border-b-sm pa-4 position-sticky topbar">
    <div></div>
    <div>{{ name }}</div>
  </div>
</template>

<style scoped>
.topbar {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
