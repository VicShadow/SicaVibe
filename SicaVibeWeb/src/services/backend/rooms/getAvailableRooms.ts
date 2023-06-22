import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'

interface GetAvailableRoomsProps {
  token: Token
  hotelId: number
  inDate: string // dd/mm/yyyy
  outDate: string // dd/mm/yyyy
}


export interface AvailableRooms {
  [key: number]: number // roomTypeId -> number of available rooms
}

const GET_AVAILABLE_ROOMS_ENDPOINT = '/hospede/check-availability'
export const getAvailableRooms = async (
  {
    token,
    hotelId,
    inDate,
    outDate
  }: GetAvailableRoomsProps
): Promise<AvailableRooms> => {
  const headers = {
    token,
    hotelid: hotelId,
    dataentrada: inDate,
    datasaida: outDate,
    "Content-Type": "application/json"
  }

  const response = await backend.get(GET_AVAILABLE_ROOMS_ENDPOINT, { headers, data: {} })

  if (response.status !== 200) {
    throw new Error('Failed to get available rooms')
  }

  return response.data as AvailableRooms
}
