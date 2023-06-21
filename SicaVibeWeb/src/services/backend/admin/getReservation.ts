import  { type Reservation, type ReservationStatus } from '@/types/Reservation'
import { backend } from '@/services/backend/backend'
import type { Token } from '@/types/Token'
import type { BackendReservation } from '@/services/backend/reservations/converters'
import { convertBackendReservationToFrontend, convertFrontendReservationStatusToBackend } from '@/services/backend/reservations/converters'

export interface getReservationProps {
    token: Token
    reservationId: number
}

const GET_RESERVATION_ENDPOINT = '/admin/reservation'

export const getReservation = async ({
token,
reservationId
}: getReservationProps): Promise<Reservation> => {
const headers = {
    token,
    reservaid: reservationId
}

const res = await backend.get(GET_RESERVATION_ENDPOINT, {
    headers
})

const backendReservation = res.data as BackendReservation

return convertBackendReservationToFrontend(backendReservation)
}







export interface AlterReservationsProps {
    token: Token
    reservationId: number
    reservationType: ReservationStatus
}

const ALTER_RESERVATIONS_ENDPOINT = '/funcionario/alter-reservation'

export const alterReservation = async ({
    token,
    reservationId,
    reservationType
}: AlterReservationsProps): Promise<Reservation> => {
    const headers = {
        token
    }

    const body = {
        reservaID: reservationId,
        reservaType: convertFrontendReservationStatusToBackend(reservationType)
    }

    const res = await backend.post(ALTER_RESERVATIONS_ENDPOINT, body, {
        headers
    })

    if (res.status !== 200) {
        // TODO: Improve error handling
        throw new Error('Failed to get reservations')
    }

    return convertBackendReservationToFrontend(res.data as BackendReservation)
}