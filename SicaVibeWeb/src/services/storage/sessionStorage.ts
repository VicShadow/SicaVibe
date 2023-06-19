import type { Token } from '@/types/Token'

export const saveToken = (token: Token): void => {
  localStorage.setItem('token', token)
}
