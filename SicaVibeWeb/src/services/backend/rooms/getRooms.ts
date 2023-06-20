import type { Room } from '@/types/Room'
import { RoomStatus } from '@/types/Room'

export const getRooms = async (token: string, id?: number): Promise<Room[]> => {
  return [
    {
      id: 1,
      typeId: 1,
      typeName: 'Single',
      doorNumber: 1,
      status: RoomStatus.AVAILABLE
    }
  ]
}
