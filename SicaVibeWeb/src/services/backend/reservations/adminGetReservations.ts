import { backend } from '@/services/backend/backend'
import { type Reservation, ReservationStatus } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import {
    convertBackendReservationsAdminToFrontend,
    convertFrontendReservationStatusToBackend
} from '@/services/backend/reservations/converters'

export interface GetReservationsProps {
  token: Token
  page: number
  pagesize: number
  hotelid?: number
}

export interface GetReservationsAdminBackend {
    [key: number]: BackendReservation[];
}

export interface GetReservationsAdmin {
    [key: number]: Reservation[];
}


const GET_ADMIN_RESERVATIONS_ENDPOINT = '/admin/get-reservation-list'


export const getReservations = async ({
    page,
    pagesize,
    token,
    hotelid,
  }: GetReservationsProps): Promise<GetReservationsAdmin> => {
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
  
    console.log('Response data: ', res.data)
    const backendData = res.data as GetReservationsAdminBackend
  
    return convertBackendReservationsAdminToFrontend(backendData)
  }