import { useQuery } from '@tanstack/vue-query'
import { getReservations } from '@/services/backend/reservations/getReservations'
import type { Reservation } from '@/types/Reservation'
import type { Ref } from 'vue'
import { ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'

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
  isError: Ref<boolean>
  isSuccess: Ref<boolean>
}

export const useReservations = (props: useReservationsProps): useReservationsReturn => {
  const queryKey = 'reservations'
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

  return {
    reservations,
    isLoading,
    isError,
    isSuccess
  }
}
