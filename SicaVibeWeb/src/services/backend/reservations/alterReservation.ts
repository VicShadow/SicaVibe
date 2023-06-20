import { backend } from '@/services/backend/backend'
import { type Reservation, type ReservationStatus } from '@/types/Reservation'
import {
  type BackendReservation,
  convertBackendReservationToFrontend,
  convertFrontendReservationStatusToBackend
} from '@/services/backend/reservations/converters'
import type { Token } from '@/types/Token'

export interface AlterReservationsProps {
  token: Token
  reservationId: number
  reservationType: ReservationStatus
}

const ALTER_RESERVATIONS_ENDPOINT = '/funcionario/alter-reservation'

export const alterReservation = async ({
  token,
  reservationId,
  reservationType
}: AlterReservationsProps): Promise<Reservation> => {
  const headers = {
    token
  }

  const body = {
    reservaID: reservationId,
    reservaType: convertFrontendReservationStatusToBackend(reservationType)
  }

  const res = await backend.post(ALTER_RESERVATIONS_ENDPOINT, body, {
    headers
  })

  if (res.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  return convertBackendReservationToFrontend(res.data as BackendReservation)
}
