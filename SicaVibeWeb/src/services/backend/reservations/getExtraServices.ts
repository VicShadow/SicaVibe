import { backend } from '@/services/backend/backend'

export interface GetExtraServicesProps {
  hotelId: number
}

export interface ExtraService {
  nome: string,
  preco: number,
  id: number
}

export type ExtraServices = ExtraService[]

const GET_EXTRA_SERVICES_ENDPOINT = '/data/hotel/{id}/servicos-extra'

export const getExtraServices = async ({ hotelId }: GetExtraServicesProps): Promise<ExtraServices> => {
  const response =
    await backend.get(GET_EXTRA_SERVICES_ENDPOINT.replace('{id}', hotelId.toString()))

  if (response.status !== 200) {
    throw new Error('Failed to get extra services')
  }

  return response.data as ExtraServices
}
