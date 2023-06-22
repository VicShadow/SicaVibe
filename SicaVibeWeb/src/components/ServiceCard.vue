<script setup lang='ts'>
import { toRefs } from 'vue'

export interface ServiceCardProps {
  id: number
  name: string
  price: number
  isSelected?: boolean
}

const props = defineProps<ServiceCardProps>()

const { name, price } = toRefs(props)
</script>

<template>
  <div class='service' :class='{ selected: isSelected }'>
    <span>{{ name }}</span>
    <span>{{ price }} €</span>
  </div>
</template>

<style scoped>
.service {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 0.5rem;
  background-color: #f5f5f5;
  transition: all 0.2s ease-in-out;
  gap: 1rem;
  padding: 0.5rem 1rem;
}

.service:hover {
  cursor: pointer;
  background-color: #e0e0e0;
}

.selected {
  background-color: #79b979;
  color: white;
}

.selected:hover {
  background-color: #619461;
  color: white;
}
</style>
