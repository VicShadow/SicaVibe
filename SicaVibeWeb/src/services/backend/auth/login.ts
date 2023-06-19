import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'

export interface LoginProps {
  email: string
  password: string
}

const LOGIN_ENDPOINT = 'login'

export const login = async (props: LoginProps): Promise<Token> => {
  const response = await backend.post(LOGIN_ENDPOINT, props)

  if (response.status !== 200) {
    throw new Error('Erro ao fazer login')
  } else {
    return response.data as Token
  }
}
