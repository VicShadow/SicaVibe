import { createRouter, createWebHistory } from 'vue-router'
import About from '@/views/About.vue'
import Login from '@/views/Login.vue'
import SignUp from '@/views/SignUp.vue'
import AdminRooms from '@/views/AdminRooms.vue'
import AdminReservas from '@/views/AdminReservas.vue'
import GuestLayoutVue from '@/layouts/GuestLayout.vue'
import Home from '@/views/Home.vue'
import AdminLayoutVue from '@/layouts/AdminLayout.vue'
import ReceptionistLayoutVue from '@/layouts/ReceptionistLayout.vue'
import HostProfile from '@/views/HostProfile.vue'
import { useUserStore } from '@/stores/userStore'

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
      },
      {
        path: 'reservations',
        name: 'admin-reservations',
        component: AdminReservas
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
    component: HostProfile
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

const ALLOWED_ROUTES = ['', '/login', '/signup', '/home', '/about']

/* // FIXME: This is not working
router.beforeEach((to, from) => {
  const { isLogged } = useUserStore()

  console.log("Allowing routes: ", ALLOWED_ROUTES)
  console.log("Current route: ", to.path)

  const isNOTLogged = !isLogged()
  const isNOTAllowedRoute = !ALLOWED_ROUTES.includes(to.path)

  console.log("isNOTLogged:", isNOTLogged ? "NOT LOGGED" : "LOGGED")
  console.log("isNOTAllowedRoute:", isNOTAllowedRoute ? "NOT ALLOWED" : "ALLOWED")

  if (isNOTLogged && isNOTAllowedRoute) {
    return '/login'
  } else {
    return true
  }
})
 */

export default router
