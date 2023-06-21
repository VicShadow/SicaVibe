import type { Room } from '@/types/Room'
import { backend } from '@/services/backend/backend'
import type { BackendHotelRooms } from '@/services/backend/rooms/converters'
import { convertBackendRoomsToFrontend } from '@/services/backend/rooms/converters'


export interface GetHotelRoomsProps {
  token: string
  roomType?: number
  hotelId?: number
}
export interface HotelRooms {
  [key: number]: Room[]
}


const GET_ROOMS_ENDPOINT = '/admin/get-quartos-list'
export const getHotelRooms = async ({token, roomType, hotelId}: GetHotelRoomsProps): Promise<HotelRooms> => {
  const headers = {
    token,
    tipoquarto: roomType,
    hotel: hotelId
  }

  const response = await backend.get(GET_ROOMS_ENDPOINT, { headers })

  if (response.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  const backendData = response.data as BackendHotelRooms

  return convertBackendRoomsToFrontend(backendData)
}
