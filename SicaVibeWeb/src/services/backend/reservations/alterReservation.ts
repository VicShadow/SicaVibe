import { backend } from '@/services/backend/backend'
import { type ReservationStatus } from '@/types/Reservation'

export interface AlterReservationsProps {
  reservationId: string
  reservationType: ReservationStatus
}

const ALTER_RESERVATIONS_ENDPOINT = 'reservations'

export const alterReservation = async ({ reservationId, reservationType }: AlterReservationsProps) => {
  const body = {
    reservaID: reservationId,
    reservaType: reservationType
  }

  // TODO: Testing missing
  const res = await backend.post(ALTER_RESERVATIONS_ENDPOINT, body)

  if (res.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  return res.data
}
