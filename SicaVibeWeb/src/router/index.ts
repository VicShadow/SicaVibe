import { createRouter, createWebHistory } from 'vue-router'
import About from '@/views/About.vue'
import AdminRooms from '@/views/AdminRooms.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/Home.vue')
  },
  {
    path: '/admin/',
    name: 'admin',
    component: () => import('@/layouts/AdminLayout.vue'),
    children: [
      {
        path: 'rooms',
        name: 'admin-rooms',
        component: AdminRooms
      }
    ]
  },
  {
    path: '/guest/',
    name: 'guest',
    component: () => import('@/layouts/GuestLayout.vue'),
    children: []
  },
  {
    path: '/receptionist/',
    name: 'receptionist',
    component: () => import('@/layouts/ReceptionistLayout.vue'),
    children: []
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    // Redirect to home if no route found
    path: '/:pathMatch(.*)*',
    name: 'not-found',
    redirect: '/'
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
