import { backend } from '@/services/backend/backend'
import { type Reservation, ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import {
  convertBackendReservationsToFrontend,
  convertReservationStatusToBackend
} from '@/services/backend/reservations/converters'

export interface GetReservationsProps {
  token: Token
  type?: ReservationStatus
  guestCC?: string
  guestName?: string
  page: number
  pagesize: number
}

export type GetReservationsResponse = BackendReservation[]

const GET_RESERVATIONS_ENDPOINT = '/funcionario/list-reservations'

export const getReservations = async ({
  type,
  guestCC,
  guestName,
  page,
  pagesize,
  token
}: GetReservationsProps): Promise<Reservation[]> => {
  let headers = {
    token,
    page,
    pagesize
  }

  if (type) {
    headers = {
      ...headers,
      // @ts-ignore
      type: convertReservationStatusToBackend(type)
    }
  }

  if (guestCC) {
    headers = {
      ...headers,
      // @ts-ignore
      guestCC
    }
  }

  if (guestName) {
    headers = {
      ...headers,
      // @ts-ignore
      guestName
    }
  }

  const res = await backend.get(GET_RESERVATIONS_ENDPOINT, {
    headers
  })

  if (res.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  console.log('Response data: ', res.data)

  const backendData = res.data as GetReservationsResponse

  return convertBackendReservationsToFrontend(backendData)
}
