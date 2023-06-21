import { backend } from '@/services/backend/backend'
import type { User } from '@/stores/userStore'
import type { Token } from '@/types/Token'
import type { UserBackend } from '@/services/backend/auth/converters'
import { convertUserBackendToFrontend } from '@/services/backend/auth/converters'

const RECEPTIONIST_INFO_ENDPOINT = '/funcionario'
export const getReceptionistInfo = async (token: Token): Promise<User> => {
  const headers = {
    token
  }

  const response = await backend.get(RECEPTIONIST_INFO_ENDPOINT, {
    headers
  })

  const user = response.data as UserBackend

  return convertUserBackendToFrontend(user, token)
}
