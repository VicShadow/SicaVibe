import { useQuery } from '@tanstack/vue-query'
import type { Reservation } from '@/types/Reservation'
import type { Ref } from 'vue'
import type { Token } from '@/types/Token'
import { getReservation } from '@/services/backend/reservations/getReservation'
import type { AxiosError } from 'axios'
import { ref } from 'vue'

export interface useReservationProps {
  token: Token
  reservationId: Ref<number>
}

export interface useReservationReturn {
  reservation: Ref<Reservation> | Ref<undefined>
  isLoading: Ref<boolean>
  isError: Ref<true> | Ref<false>
  isSuccess: Ref<boolean>
  error: Ref<Error | null>
}

export const useReservation = (props: useReservationProps): useReservationReturn => {
  /*
  const queryKey = 'reservation'
  const queryFn = async () => {
    try {
      return await getReservation({
        token: props.token,
        reservationId: props.reservationId.value
      })
    } catch (error) {
      throw new Error((error as AxiosError).message)
    }
  }
  const {
    data: reservation,
    isLoading,
    isError,
    isSuccess,
    error
  } = useQuery<Reservation>({
    queryKey: [queryKey, props.reservationId.value],
    queryFn,
    cacheTime: 0
  })
   */

  // Do not use vue query at all but return the data using the backend service
  const reservation = ref<Reservation>()
  const isLoading = ref(false)
  const isError = ref(false)
  const isSuccess = ref(false)
  const error = ref<string | null>(null)

  getReservation({ token: props.token, reservationId: props.reservationId.value })
    .then((data) => {
      reservation.value = data
      isSuccess.value = true
    })
    .catch((err) => {
      error.value = (err as AxiosError).message
      isError.value = true
    })
    .finally(() => {
      isLoading.value = false
    })

  return {
    reservation,
    isLoading,
    isError,
    isSuccess,
    error: error as Ref<Error | null>
  }
}
