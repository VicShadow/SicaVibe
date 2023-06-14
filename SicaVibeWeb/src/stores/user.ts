import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
  const user = ref({
    name: 'Eduardo',
    email: 'eduardo@gmail.com',
    role: 'admin'
  })

  return { user }
})
