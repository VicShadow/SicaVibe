<template>
  <h1 class="va-h1">{{ msg }}</h1>
  <h3>A = {{ a }}</h3>

  <v-btn @click="a = 'changed-button-name'">Change button's name</v-btn>
</template>

<script setup lang="ts">
import { ref } from 'vue'

defineProps({
  msg: String
})

const a = ref('button-name')
</script>

<style scoped></style>
