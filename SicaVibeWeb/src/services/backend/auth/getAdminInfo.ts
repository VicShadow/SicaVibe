import { backend } from '@/services/backend/backend'
import type { User } from '@/stores/userStore'
import { Role } from '@/stores/userStore'
import type { Token } from '@/types/Token'
import type { UserBackend } from '@/services/backend/auth/converters'
import { convertUserBackendToFrontend } from '@/services/backend/auth/converters'

const ADMIN_INFO_ENDPOINT = '/admin/info' // TODO: Make sure this is the correct endpoint
export const getAdminInfo = async (token: Token): Promise<User> => {
  return {
    id: 1,
    name: 'Admin',
    email: 'admin1@example.com',
    phoneNumber: '961234567',
    cc: '12345678',
    nif: '123456789',
    birthDate: new Date('1990-01-01'),
    role: Role.Admin,
    token: token
  }

  const headers = {
    token
  }

  const response = await backend.get(ADMIN_INFO_ENDPOINT, {
    headers
  })

  const user = response.data as UserBackend

  return convertUserBackendToFrontend(user, token)
}
