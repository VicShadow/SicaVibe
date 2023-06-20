import { getToken } from '@/services/storage/sessionStorage'
import { useQuery } from '@tanstack/vue-query'
import { getRooms } from '@/services/backend/rooms/getRooms'
import type { Ref } from 'vue'

export interface useRoomsProps {
  id: Ref<number | undefined>
}

export const useRooms = ({ id }: useRoomsProps) => {
  const token = getToken()
  if (!token) throw new Error('Token not found')

  const queryKey = 'rooms'
  const queryFn = async () => {
    return await getRooms(token, id.value)
  }

  const {
    data: rooms,
    isLoading,
    isError,
    isSuccess
  } = useQuery({
    queryKey: [queryKey, id],
    queryFn
  })

  return {
    rooms,
    isLoading,
    isError,
    isSuccess
  }
}
