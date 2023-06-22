import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'
import type { UserBackend } from './converters'
import { formatDateBackend } from '@/services/formatter'

export interface EditProfileProps {
  token: Token
  user: UserBackend,
}


const EDIT_PROFILE_ENDPOINT = '/hospede/edit-account'

export const editProfile = async ({
  token,
  user
}: EditProfileProps) : Promise<UserBackend>=> {
  const endpoint = EDIT_PROFILE_ENDPOINT

  const backendUser = {
    email: user.email,
    nome: user.nome,
    numTelemovel: user.numTelemovel,
    morada: user.morada,
    cc: user.cc,
    nif: user.nif,
    dataNascimento: formatDateBackend(new Date(user.dataNascimento)),
    id: user.id
  }


  const headers = {
    token
  }

  const res = await backend.post(endpoint, backendUser, { headers })

  if (res.status !== 200) throw new Error("Edit Profile Not Possible!")
  
  return res.data as UserBackend
}