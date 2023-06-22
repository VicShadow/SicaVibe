import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'

export interface GetReservationsProps {
  token: Token
  reservaid: number,
}


const CANCEL_RESERVATION_ENDPOINT = '/hospede/reservation-cancel'

export const cancelReservation = async ({
  token,
  reservaid
}: GetReservationsProps) : Promise<boolean>=> {
  const endpoint = CANCEL_RESERVATION_ENDPOINT

  const headers = {
    token,
    reservaid
  }

  const res = await backend.post(endpoint, {reservaid : reservaid} , { headers })

  if (res.status !== 200) return false
  
  return true
}
