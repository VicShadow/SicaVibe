import { Role, type User } from '@/stores/userStore'
import { type Token } from '@/types/Token'
import { decodeJWT } from '@/services/jwt/decoder'

export interface UserBackend {
  email: string
  nome: string
  numTelemovel: string
  morada: string
  cc: string
  nif: string
  dataNascimento: Date
  hotelName: string
  id: number
}

export const convertUserType = (type: string): Role => {
  switch (type) {
    case 'HOSPEDE':
      return Role.Guest
    case 'FUNCIONARIO':
      return Role.Receptionist
    case 'ADMINISTRADOR':
      return Role.Admin
    default:
      throw new Error('Invalid user type')
  }
}


export const convertUserBackendToFrontend = (user: UserBackend, token: Token): User => {
  const decodedToken = decodeJWT(token)
  if (!decodedToken) {
    throw new Error('Invalid token')
  }

  return {
    id: user.id,
    name: user.nome,
    email: user.email,
    address: user.morada,
    phoneNumber: user.numTelemovel,
    cc: user.cc,
    nif: user.nif,
    birthDate: user.dataNascimento,
    hotelName: user.hotelName,

    role: convertUserType(decodedToken.role),
    token
  }
}

