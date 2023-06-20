import { alterReservation } from '@/services/backend/reservations/alterReservation'
import { type Reservation, ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'

export const cancelReservation = async (
  token: Token,
  reservationId: number
): Promise<Reservation> => {
  try {
    return await alterReservation({
      token,
      reservationId,
      reservationType: ReservationStatus.CANCELLED
    })
  } catch (e) {
    throw new Error('Failed to cancel reservation')
  }
}
