import type { Reservation } from '@/types/Reservation'
import { alterReservation } from '@/services/backend/reservations/alterReservation'
import { ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'

export const checkOutReservation = async (
  token: Token,
  reservationId: number
): Promise<Reservation> => {
  try {
    return await alterReservation({
      token,
      reservationId,
      reservationType: ReservationStatus.DONE
    })
  } catch (e) {
    throw new Error('Failed to check out reservation')
  }
}
