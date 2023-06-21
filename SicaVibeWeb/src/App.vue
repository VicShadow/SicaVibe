<template>
  <v-app :full-height='true'>
  <RouterView />
  </v-app>
</template>

<script lang='ts' setup>
import { useUserStore } from '@/stores/userStore'

const { init } = useUserStore()

init()

</script>

<style scoped></style>
