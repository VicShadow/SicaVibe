import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'

export interface Employee {
  id: number
  nome: string
  email: string
  numTelemovel: string
  cc: string
  nif: string
  dataNascimento: Date
  hotelName?: string,
  morada : string
}


export interface GetEmployeesHeaders {
  token: Token
  page: number
  pagesize: number
  usertype: string
}


const GET_EMPLOYEES_ENDPOINT = '/admin/get-user-list'

export const getEmployees = async ({
      token,
      page,
      pagesize,
      usertype
  }: GetEmployeesHeaders): Promise<Employee[]> => {
    const endpoint = GET_EMPLOYEES_ENDPOINT

    const headers = {
      token,
      page,
      pagesize,
      usertype
    }

    const res = await backend.get(endpoint, {
      headers
    })

    if (res.status !== 200) {
      // TODO: Improve error handling
      throw new Error('Failed to get reservations')
    }

    const backendData = res.data as Employee[]

    return backendData
}
