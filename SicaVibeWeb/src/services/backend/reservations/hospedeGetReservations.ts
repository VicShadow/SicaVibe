import { backend } from '@/services/backend/backend'
import { type Reservation } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import {
  convertBackendReservationsToFrontend,
} from '@/services/backend/reservations/converters'

export interface GetReservationsProps {
  token: Token
}

export type GetReservationsResponse = BackendReservation[]

const GET_RESERVATIONS_ENDPOINT = '/hospede/reservations'

export const getReservations = async ({
  token,
}: GetReservationsProps): Promise<Reservation[]> => {
  const endpoint = GET_RESERVATIONS_ENDPOINT

  const headers = {
    token,
  }

  const res = await backend.get(endpoint, {
    headers
  })

  if (res.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  const backendData = res.data as GetReservationsResponse

  return convertBackendReservationsToFrontend(backendData)
}
