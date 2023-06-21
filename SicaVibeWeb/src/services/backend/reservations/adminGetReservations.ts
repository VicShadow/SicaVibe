import { backend } from '@/services/backend/backend'
import { type Reservation } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import { convertBackendReservationsAdminToFrontend } from '@/services/backend/reservations/converters'

export interface GetReservationsProps {
    token: Token
    page: number
    pagesize: number
    hotelid?: number
}

const GET_ADMIN_RESERVATIONS_ENDPOINT = '/admin/get-reservation-list'


export const getReservations = async ({
    page,
    pagesize,
    token,
    hotelid,
  }: GetReservationsProps): Promise<Map<string, Reservation[]>> => {
    const endpoint = GET_ADMIN_RESERVATIONS_ENDPOINT

    let headers = {
      token,
      page,
      pagesize,
      hotelid
    }


    if (hotelid) {
      headers = {
        ...headers,
        // @ts-ignore
        hotelid
      }
    }


    const res = await backend.get(endpoint, {
      headers
    })

    if (res.status !== 200) {
      // TODO: Improve error handling
      throw new Error('Failed to get reservations')
    }

    const backendData = res.data as Map<string, BackendReservation[]>

    return convertBackendReservationsAdminToFrontend(backendData)
  }
