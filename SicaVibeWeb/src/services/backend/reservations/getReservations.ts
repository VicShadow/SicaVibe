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
  isAdmin?: boolean
  hotelid?: number
}

export type GetReservationsResponse = BackendReservation[]

const GET_RECEPTIONIST_RESERVATIONS_ENDPOINT = '/funcionario/list-reservations'
const GET_ADMIN_RESERVATIONS_ENDPOINT = '/admin/get-reservation-list'

export const getReservations = async ({
  type,
  guestCC,
  guestName,
  page,
  pagesize,
  token,
  isAdmin = false,
  hotelid,
}: GetReservationsProps): Promise<Reservation[]> => {
  const endpoint = isAdmin
    ? GET_ADMIN_RESERVATIONS_ENDPOINT
    : GET_RECEPTIONIST_RESERVATIONS_ENDPOINT

  let headers = isAdmin ? {
    token,
    page,
    pagesize,
    hotelid
  } : {
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

  console.log('Response data: ', res.data)
  const backendData = res.data as GetReservationsResponse

  return convertBackendReservationsToFrontend(backendData)
}
