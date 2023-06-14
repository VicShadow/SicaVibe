<script setup lang='ts'>
import { toRefs } from 'vue'
import { useRouter } from 'vue-router'

export interface Props {
  title: string
  value: string
  icon: string
}

const props = defineProps<Props>()

const { title, value, icon } = toRefs(props)

const router = useRouter()

const onClick = () => {
  router.push(value.value)
}

</script>

<template>
  <v-list-item :prepend-icon='icon' :title='title' @click='onClick' />
</template>

<style scoped>

</style>
