import { backend } from '@/services/backend/backend'

interface GetRoomTypesInfoProps {
  hotelId: number
}

export interface RoomType {
  id: number
  nome: string
  capacidade: number
  preco: number
  descricao: string
  imgID: number
}

export type RoomTypes = RoomType[]

const GET_ROOM_TYPES_ENDPOINT = '/data/hotel/{id}/tipos-de-quartos'

export const getRoomTypes = async ({ hotelId }: GetRoomTypesInfoProps): Promise<RoomTypes> => {
  const response =
    await backend.get(GET_ROOM_TYPES_ENDPOINT.replace('{id}', hotelId.toString()))

  if (response.status !== 200) {
    throw new Error('Failed to get room types info')
  }

  return response.data as RoomTypes
}
