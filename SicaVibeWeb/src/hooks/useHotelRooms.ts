import { useQuery } from '@tanstack/vue-query'
import { getHotelRooms } from '@/services/backend/rooms/getHotelRooms'
import type { Ref } from 'vue'
import type { Token } from '@/types/Token'
import { getToken } from '@/services/storage/sessionStorage'

export interface useRoomsProps {
  hotelId: Ref<number | undefined>
}

export const useHotelRooms = ({ hotelId }: useRoomsProps) => {
  console.log("hotelId", hotelId)
  const token = getToken() as Token

  console.log("Token:", token)

  const queryKey = 'selectedRooms'
  const queryFn = async () => {
    const hotelRooms = await getHotelRooms({token, hotelId: hotelId.value})
    console.log("hotelRooms", hotelRooms)
    return hotelRooms
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
