<script lang="ts" setup>
import { useUserStore } from '@/stores/user'
import AdminLayout from '@/layouts/AdminLayout.vue'

interface Props {}

defineProps<Props>()

const { user } = useUserStore()
</script>

<template>
  <AdminLayout v-if="user?.role === 'admin'">
    <slot />
  </AdminLayout>
  <div v-else>
    <slot />
  </div>
</template>

<style scoped></style>
