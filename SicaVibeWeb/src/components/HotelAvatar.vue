<script lang="ts" setup>
import { toRefs } from 'vue'

interface Props {
  img: string // Url of the image
}

const props = defineProps<Props>()

const { img } = toRefs(props)
</script>

<template>
  <div class="d-flex flex-row justify-start align-center py-1 outer-div">
    <v-img :cover="true" :src="img" aspect-ratio="1" class="rounded-sm" height="40" width="40" />
    <div class="d-flex flex-column justify-center">
      <span class="text-h6">Porto Hotel</span>
      <span class="text-caption">Uma experiência totalmente diferente</span>
    </div>
  </div>
</template>

<style scoped>
.outer-div {
  gap: 1rem;
}
</style>
