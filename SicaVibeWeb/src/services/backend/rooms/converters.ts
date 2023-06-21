import type { HotelRooms } from '@/services/backend/rooms/getHotelRooms'


export interface BackendRoom {
  id: number
  tipoQuartoID: number
  tipoQuartoNome: string
  numPorta: number
  estado: string
}


export interface BackendHotelRooms {
  [key: number]: BackendRoom[]
}


export const convertBackendRoomsToFrontend = (backendRooms: BackendHotelRooms): HotelRooms => {
  const rooms: HotelRooms = {}

  for (const roomType in backendRooms) {
    rooms[Number(roomType)] = backendRooms[Number(roomType)].map((backendRoom) => ({
      id: backendRoom.id,
      typeId: backendRoom.tipoQuartoID,
      typeName: backendRoom.tipoQuartoNome,
      doorNumber: backendRoom.numPorta,
      status: backendRoom.estado
    })).sort((a, b) => a.doorNumber - b.doorNumber)
  }

  return rooms
}
