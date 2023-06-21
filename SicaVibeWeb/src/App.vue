<template>
  <RouterView />
</template>

<script lang='ts' setup>
import { useUserStore } from '@/stores/userStore'

const { init } = useUserStore()

init()

</script>

<style scoped></style>
