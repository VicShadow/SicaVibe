import { useQuery } from '@tanstack/vue-query'
import { getHotelRooms } from '@/services/backend/rooms/getHotelRooms'
import type { Ref } from 'vue'
import type { Token } from '@/types/Token'
import { getToken } from '@/services/storage/sessionStorage'

export interface useRoomsProps {
  hotelId: Ref<number | undefined>
}

export const useHotelRooms = ({ hotelId }: useRoomsProps) => {
  const token = getToken() as Token

  const queryKey = 'selectedRooms'
  const queryFn = async () => {
    return await getHotelRooms({ token, hotelId: hotelId.value })
  }

  const {
    data: hotelRooms,
    isLoading,
    isError,
    isSuccess
  } = useQuery({
    queryKey: [queryKey, hotelId.value],
    queryFn
  })

  return {
    hotelRooms,
    isLoading,
    isError,
    isSuccess
  }
}
