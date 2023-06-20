import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'

export interface RegisterProps {
  email: string
  password: string
  name: string
  address: string
  birthday: string // dd/mm/yyyy
  mobileNumber: string
  cc: string
  nif: string
}

const REGISTER_ENDPOINT = 'register'

export const register = async ({
  mobileNumber,
  email,
  birthday,
  address,
  name,
  password,
  nif,
  cc
}: RegisterProps) => {
  const body = {
    email: email,
    password: password,
    nome: name,
    morada: address,
    dataNascimento: birthday,
    numTelemovel: mobileNumber,
    nTelemovel: '',
    cc: cc,
    nif: nif
  }

  const response = await backend.post(REGISTER_ENDPOINT, body)

  if (response.status !== 200) {
    throw new Error(response.data)
  } else {
    return response.data as Token
  }
}
