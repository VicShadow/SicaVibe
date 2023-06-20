import { createRouter, createWebHistory } from 'vue-router'
import About from '@/views/About.vue'
import Login from '@/views/Login.vue'
import SignUp from '@/views/SignUp.vue'
import AdminRooms from '@/views/AdminRooms.vue'
import GuestLayoutVue from '@/layouts/GuestLayout.vue'
import Home from '@/views/Home.vue'
import AdminLayoutVue from '@/layouts/AdminLayout.vue'
import ReceptionistLayoutVue from '@/layouts/ReceptionistLayout.vue'
import HostProfile from '@/views/HostProfile.vue'
import EditProfile from '@/views/EditProfile.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/admin/',
    name: 'admin',
    component: AdminLayoutVue,
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
    component: GuestLayoutVue,
    children: []
  },
  {
    path: '/receptionist/',
    name: 'receptionist',
    component: ReceptionistLayoutVue,
    children: [
      {
        path: 'reservations',
        name: 'receptionist-reservations',
        component: () => import('@/views/ReceptionistReservations.vue')
      },
      {
        path: 'reservations/:id/',
        name: 'reservation',
        component: () => import('@/views/ReceptionistReservation.vue')
      }
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/signup',
    name: 'signup',
    component: SignUp
  },
  {
    path: '/hostprofile',
    name: 'hostprofile',
    component: HostProfile,
  },
  {
    path: '/edit',
    name: 'edit-profile',
    component: EditProfile,
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
