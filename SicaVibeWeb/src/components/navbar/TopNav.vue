<script lang='ts' setup>
import { useUserStore } from '@/stores/userStore'
import { toRefs } from 'vue'
import { useRouter } from 'vue-router'

const {
  user,
  logout
} = useUserStore()

const router = useRouter()

const { name } = toRefs(user)

const logoutOnclick = () => {
  logout()

  router.push('/login')
}
</script>

<template>
  <div class='border-b-sm pa-4 position-sticky topbar'>
    <div></div>
    <div class='right'>
      <span>{{ name }}</span>
      <v-btn @click='logoutOnclick' class='bg-blue-darken-2 elevation-0 text-capitalize'>Logout</v-btn>
    </div>
  </div>
</template>

<style scoped>
.topbar {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.right {
  display: flex;
  flex-direction: row;
  align-items: center;
  gap: 1rem;
}
</style>
