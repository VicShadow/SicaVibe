import type { Reservation } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import { backend } from '@/services/backend/backend'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import { convertBackendReservationToFrontend } from '@/services/backend/reservations/converters'

export interface getReservationProps {
  token: Token
  reservationId: number
}

const GET_RECEPTIONIST_RESERVATION_ENDPOINT = '/funcionario/reservation'

export const getReservation = async ({
  token,
  reservationId
}: getReservationProps): Promise<Reservation> => {
  const headers = {
    token,
    reservaid: reservationId
  }

  const res = await backend.get(GET_RECEPTIONIST_RESERVATION_ENDPOINT, {
    headers
  })

  const backendReservation = res.data as BackendReservation

  return convertBackendReservationToFrontend(backendReservation)
}
