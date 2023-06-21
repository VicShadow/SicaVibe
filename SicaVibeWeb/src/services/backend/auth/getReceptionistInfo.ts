import { backend } from '@/services/backend/backend'
import type { User } from '@/stores/userStore'
import { Role } from '@/stores/userStore'
import type { Token } from '@/types/Token'
import type { UserBackend } from '@/services/backend/auth/converters'
import { convertUserBackendToFrontend } from '@/services/backend/auth/converters'

const RECEPTIONIST_INFO_ENDPOINT = '/receptionist/info' // TODO: Make sure this is the correct endpoint
export const getReceptionistInfo = async (token: Token): Promise<User> => {
  return {
    id: 0,
    name: 'Receptionist',
    email: 'receptionist@example.com',
    phoneNumber: '123456789',
    cc: '123456789',
    nif: '123456789',
    birthDate: new Date(),
    hotelName: 'Hotel',
    role: Role.Receptionist,
    token
  } // TODO: Remove this when the backend is implemented

  const headers = {
    token
  }

  const response = await backend.get(RECEPTIONIST_INFO_ENDPOINT, {
    headers
  })

  const user = response.data as UserBackend

  return convertUserBackendToFrontend(user, token)
}
