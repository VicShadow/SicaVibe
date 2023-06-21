import { useMutation, useQueryClient } from '@tanstack/vue-query'
import { checkInReservation } from '@/services/backend/reservations/checkInReservation'
import { checkOutReservation } from '@/services/backend/reservations/checkOutReservation'
import { cancelReservation } from '@/services/backend/reservations/cancelReservation'
import type { Ref } from 'vue'

export interface useReservationMutationProps {
  token: string
  reservationId: Ref<number>
}

export const useReservationMutation = ({ token, reservationId }: useReservationMutationProps) => {
  const queryClient = useQueryClient()

  const queryKey = 'reservation'

  const checkInMutation = useMutation({
    mutationFn: async () => checkInReservation(token, reservationId.value),
    onSuccess: async (data) => {
      console.log("CheckInMutation success")
      await queryClient.invalidateQueries({ queryKey: [queryKey, reservationId] }) // Invalidate and refetch
      return queryClient.setQueryData([queryKey, reservationId], data)
    }
  })

  const checkOutMutation = useMutation({
    mutationFn: async () => checkOutReservation(token, reservationId.value),
    onSuccess: async (data) => {
      console.log("CheckOutMutation success")
      await queryClient.invalidateQueries({ queryKey: [queryKey, reservationId.value]}) // Invalidate and refetch
      return queryClient.setQueryData([queryKey, reservationId], data)
    }
  })

  const cancelMutation = useMutation({
    mutationFn: async () => cancelReservation(token, reservationId.value),
    onSuccess: async (data) => {
      console.log("CancelMutation success")
      await queryClient.invalidateQueries({ queryKey: [queryKey, reservationId.value], exact:true }) // Invalidate and refetch
      return queryClient.setQueryData([queryKey, reservationId], data)
    }
  })

  return {
    checkInMutation,
    checkOutMutation,
    cancelMutation
  }
}
