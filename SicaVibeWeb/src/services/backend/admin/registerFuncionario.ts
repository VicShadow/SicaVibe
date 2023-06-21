import { backend } from '@/services/backend/backend'
import type { User } from '@/stores/userStore'
import { getToken } from '@/services/storage/sessionStorage'

export interface RegisterEmployeeProps {
  email: string
  password: string
  nome: string
  address: string
  birthday: string // dd/mm/yyyy
  mobileNumber: string
  cc: string
  nif: string
  hotelID : number
}

const REGISTER_ENDPOINT = '/admin/register-func'

const headers = {
    headers : {
        token: getToken()
    }
}

export const registerEmployee = async ({
  mobileNumber,
  email,
  birthday,
  address,
  nome,
  password,
  nif,
  cc,
  hotelID
}: RegisterEmployeeProps) : Promise<User> => {
  const body = {
    email: email,
    password: password,
    nome: nome,
    morada: address,
    dataNascimento: birthday,
    numTelemovel: mobileNumber,
    cc: cc,
    nif: nif,
    hotelID: hotelID
  }

  const response = await backend.post(REGISTER_ENDPOINT, body, headers)

  if (response.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to Register Employee')
  }

  const backendData = response.data as User

  return backendData
}
