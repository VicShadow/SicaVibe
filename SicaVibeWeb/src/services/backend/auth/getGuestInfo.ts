import type { User } from '@/stores/userStore'
import type { Token } from '@/types/Token'
import { backend } from '@/services/backend/backend'
import type { UserBackend } from '@/services/backend/auth/converters'
import { convertUserBackendToFrontend } from '@/services/backend/auth/converters'

const GUEST_INFO_ENDPOINT = '/hospede'
export const getGuestInfo = async (token: Token): Promise<User> => {
  const headers = {
    token
  }

  const response = await backend.get(GUEST_INFO_ENDPOINT, {
    headers
  })

  const user = response.data as UserBackend

  return convertUserBackendToFrontend(user, token)
}
