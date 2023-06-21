import { ref } from 'vue'
import { defineStore } from 'pinia'
import { getToken, removeToken, saveToken } from '@/services/storage/sessionStorage'
import { getGuestInfo } from '@/services/backend/auth/getGuestInfo'
import { login as loginBackend } from '@/services/backend/auth/login'
import { getAdminInfo } from '@/services/backend/auth/getAdminInfo'
import { getReceptionistInfo } from '@/services/backend/auth/getReceptionistInfo'
import { convertUserType } from '@/services/backend/auth/converters'
import { decodeJWT } from '@/services/jwt/decoder'

export enum Role {
  Guest = 'guest',
  Receptionist = 'receptionist',
  Admin = 'admin'
}

export interface User {
  id: number
  name: string
  email: string
  address: string
  phoneNumber: string
  cc: string
  nif: string
  birthDate: Date
  hotelName?: string

  role: Role
  token: string
}


export const useUserStore = defineStore('user', () => {
  const user = ref<User>()

  const init = async () => {
    const token = getToken()
    if (!token) {
      return
    }

    await getInfo(token)
  }

  const getInfo = async (token: string) => {
    const decodedToken = decodeJWT(token)
    const role = convertUserType(decodedToken?.role ?? '')
    if (!role) {
      throw new Error('Invalid token')
    } else if (role === Role.Admin) {
      user.value = await getAdminInfo(token)
    } else if (role === Role.Receptionist) {
      user.value = await getReceptionistInfo(token)
    } else if (role === Role.Guest) {
      user.value = await getGuestInfo(token)
    } else {
      throw new Error('Invalid role')
    }

    saveToken(token)
  }

  const login = async (email: string, password: string): Promise<Role | undefined> => {
    const token = await loginBackend({
      email,
      password
    })
    await getInfo(token)

    return user.value?.role
  }

  const logout = () => {
    user.value = undefined

    removeToken()
  }

  const isLogged = () => {
    return !!user.value
  }

  return { user, init, login, logout, isLogged }
})
