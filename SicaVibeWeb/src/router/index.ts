import { createRouter, createWebHistory } from 'vue-router'
import About from '@/views/About.vue'
import AdminRooms from '@/views/AdminRooms.vue'

const routes = [
  {
    path: '/admin/rooms',
    name: 'home',
    component: AdminRooms
  },
  {
    path: '/about',
    name: 'about',
    component: About
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
