import { useMutation, useQueryClient } from '@tanstack/vue-query'
import { checkInReservation } from '@/services/backend/reservations/checkInReservation'
import { checkOutReservation } from '@/services/backend/reservations/checkOutReservation'
import { cancelReservation } from '@/services/backend/reservations/cancelReservation'

export interface useReservationMutationProps {
  token: string
  reservationId: number
}

export const useReservationMutation = ({ token, reservationId }: useReservationMutationProps) => {
  const queryClient = useQueryClient()

  const queryKey = 'reservation'

  const checkInMutation = useMutation({
    mutationFn: async () => checkInReservation(token, reservationId),
    onSuccess: async (data) =>
      queryClient.setQueryData([queryKey, reservationId], data)
      //await queryClient.invalidateQueries({ queryKey: [queryKey, reservationId] }) // Invalidate and refetch
  })

  const checkOutMutation = useMutation({
    mutationFn: async () => checkOutReservation(token, reservationId),
    onSuccess: async (data) =>
      queryClient.setQueryData([queryKey, reservationId], data)
      //await queryClient.invalidateQueries({ queryKey: [queryKey, reservationId], exact: true }) // Invalidate and refetch
  })

  const cancelMutation = useMutation({
    mutationFn: async () => cancelReservation(token, reservationId),
    onSuccess: async (data) =>
      queryClient.setQueryData([queryKey, reservationId], data)
      //await queryClient.invalidateQueries({ queryKey: [queryKey, reservationId], exact:true }) // Invalidate and refetch
  })

  return {
    checkInMutation,
    checkOutMutation,
    cancelMutation
  }
}
