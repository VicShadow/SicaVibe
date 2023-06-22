import { useQuery } from '@tanstack/vue-query'
import { getReservations } from '@/services/backend/reservations/getReservations'
import type { Reservation } from '@/types/Reservation'
import type { Ref } from 'vue'
import { ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import { ref } from 'vue'

export interface useReservationsProps {
  token: Token
  page: Ref<number>
  pagesize: Ref<number>
  type?: Ref<ReservationStatus | undefined>
  guestCC?: Ref<string | undefined>
  guestName?: Ref<string | undefined>
}

export interface useReservationsReturn {
  reservations: Ref<Reservation[] | undefined>
  isLoading: Ref<boolean>
  error: Ref<string | undefined>
  isSuccess: Ref<boolean>
}

export const useReservations = (props: useReservationsProps): useReservationsReturn => {
  const queryKey = 'reservations'
  /*
  const queryFn = async () =>
    getReservations({
      token: props.token,
      page: props.page.value,
      pagesize: props.pagesize?.value,
      guestName: props.guestName?.value
    })
  const {
    data: reservations,
    isLoading,
    isError,
    isSuccess
  } = useQuery<Reservation[]>({
    queryKey: [queryKey, props.page, props.pagesize, props.type, props.guestCC, props.guestName],
    queryFn,
    cacheTime: 0,
    staleTime: 0
  })
   */

  // Do not use vue query at all but return the data using the backend service
  const reservations = ref<Reservation[] | undefined>(undefined)
  const isLoading = ref(false)
  const isSuccess = ref(false)
  const error = ref()

  getReservations({
    token: props.token,
    page: props.page.value,
    pagesize: props.pagesize?.value,
    guestName: props.guestName?.value
  }).then((data) => {
    reservations.value = data
    isSuccess.value = true
  }).catch((error) => {
    error.value = error
  }).finally(() => {
    isLoading.value = false
  })

  return {
    reservations,
    isLoading,
    error,
    isSuccess
  }
}
