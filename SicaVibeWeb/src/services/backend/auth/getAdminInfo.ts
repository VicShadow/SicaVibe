import { backend } from '@/services/backend/backend'
import type { User } from '@/stores/userStore'
import type { Token } from '@/types/Token'
import type { UserBackend } from '@/services/backend/auth/converters'
import { convertUserBackendToFrontend } from '@/services/backend/auth/converters'

const ADMIN_INFO_ENDPOINT = '/admin'
export const getAdminInfo = async (token: Token): Promise<User> => {
  const headers = {
    token
  }

  const response = await backend.get(ADMIN_INFO_ENDPOINT, {
    headers
  })

  const user = response.data as UserBackend

  return convertUserBackendToFrontend(user, token)
}
