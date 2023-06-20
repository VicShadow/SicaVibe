<script lang="ts" setup>
import { computed, toRefs } from 'vue'
import { useRouter } from 'vue-router'

export interface Props {
  title: string
  value: string
  icon: string
  selected?: boolean
}

const props = defineProps<Props>()

const { title, value, icon, selected } = toRefs(props)

const router = useRouter()

const onClick = () => {
  router.push(value.value)
}

const style = computed(() => {
  return {
    background: selected.value ? '#e9f2ff' : ''
  }
})
</script>

<template>
  <v-list-item
    :prepend-icon="icon"
    :style="style"
    :title="title"
    class="navitem rounded-sm"
    @click="onClick"
  />
</template>

<style scoped>
.navitem:hover {
  background: #f1f2f4;
}
</style>
