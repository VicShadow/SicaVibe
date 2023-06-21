import type { Token } from '@/types/Token'

export const saveToken = (token: Token): void => {
  localStorage.setItem('token', token)
}

export const getToken = (): Token | null => {
  return localStorage.getItem('token')
}

export const removeToken = (): void => {
  localStorage.removeItem('token')
}
