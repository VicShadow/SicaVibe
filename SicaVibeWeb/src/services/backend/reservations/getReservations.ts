import { backend } from '@/services/backend/backend'
import { type Reservation, ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import {
  convertBackendReservationsToFrontend,
  convertFrontendReservationStatusToBackend
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

const GET_RECEPTIONIST_RESERVATIONS_ENDPOINT = '/funcionario/list-reservations'

export const getReservations = async ({
  type,
  guestCC,
  guestName,
  page,
  pagesize,
  token,
}: GetReservationsProps): Promise<Reservation[]> => {
  const endpoint = GET_RECEPTIONIST_RESERVATIONS_ENDPOINT

  let headers = {
    token,
    page,
    pagesize,
  }


  if (type) {
    headers = {
      ...headers,
      // @ts-ignore
      tipo: convertFrontendReservationStatusToBackend(type)
    }
  }

  if (guestCC) {
    headers = {
      ...headers,
      // @ts-ignore
      hospedecc: guestCC
    }
  }

  if (guestName) {
    headers = {
      ...headers,
      // @ts-ignore
      hospedenome: guestName
    }
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
