import { type Guest, type Reservation, ReservationStatus, type Service } from '@/types/Reservation'
import { type Room, RoomStatus } from '@/types/Room'
import type { GetReservationsResponse } from '@/services/backend/reservations/getReservations'

interface Hospede {
  email: string
  password: string
  salt: string
  nome: string
  dataNascimento: string
  numTelemovel: string
  morada: string
  cc: string
  nif: string
  id: number
  ormid: number
}

interface Quarto {
  id: number
  tipoQuartoID: number
  tipoQuartoNome: string
  numPorta: number
  estado: string
}

interface ServicoExtra {
  nome: string
  preco: number
  id: number
}

export interface BackendReservation {
  id: number
  hospedeId: number
  hospedeNome: string
  hospede: Hospede | null // Only if the available is the logged-in user is an admin
  dataEntrada: string
  dataSaida: string
  preco: number
  estado: string
  quartos: Quarto[]
  servicosExtras: ServicoExtra[]
}

export enum BackendReservationStatus {
  ON_GOING = 'A_DECORRER',
  DONE = 'TERMINADA',
  CANCELLED = 'CANCELADA',
  SCHEDULED = 'MARCADA'
}

export const convertFrontendReservationStatusToBackend = (status: ReservationStatus): string => {
  switch (status) {
    case ReservationStatus.ON_GOING:
      return 'A_DECORRER'
    case ReservationStatus.DONE:
      return 'TERMINADA'
    case ReservationStatus.CANCELLED:
      return 'CANCELADA'
    case ReservationStatus.SCHEDULED:
      return 'MARCADA'
    default:
      throw new Error('Invalid reservation status')
  }
}

export const convertBackendReservationStatusToFrontend = (
  status: BackendReservationStatus
): ReservationStatus => {
  switch (status) {
    case BackendReservationStatus.ON_GOING:
      return ReservationStatus.ON_GOING
    case BackendReservationStatus.DONE:
      return ReservationStatus.DONE
    case BackendReservationStatus.CANCELLED:
      return ReservationStatus.CANCELLED
    case BackendReservationStatus.SCHEDULED:
      return ReservationStatus.SCHEDULED
    default:
      throw new Error('Invalid reservation status')
  }
}

export const convertBackendReservationToFrontend = (
  reservation: BackendReservation
): Reservation => {
  const rooms: Room[] = reservation.quartos.map((room) => ({
    id: room.id,
    typeId: room.tipoQuartoID,
    typeName: room.tipoQuartoNome,
    type: room.tipoQuartoNome,
    doorNumber: room.numPorta,
    status: room.estado as RoomStatus
  }))

  const services: Service[] = reservation.servicosExtras.map((service) => ({
    id: service.id,
    name: service.nome,
    price: service.preco
  }))

  const guest: Guest | undefined =
    reservation.hospede === null
      ? undefined
      : {
          id: reservation.hospede.id,
          email: reservation.hospede.email,
          name: reservation.hospede.nome,
          birthDate: new Date(reservation.hospede.dataNascimento),
          phoneNumber: reservation.hospede.numTelemovel,
          address: reservation.hospede.morada,
          cc: reservation.hospede.cc,
          nif: reservation.hospede.nif
        }

  return {
    id: reservation.id,
    guestId: reservation.hospedeId,
    guestName: reservation.hospedeNome,
    guest: guest,
    inDate: new Date(reservation.dataEntrada),
    outDate: new Date(reservation.dataSaida),
    price: reservation.preco,
    status: convertBackendReservationStatusToFrontend(
      reservation.estado as BackendReservationStatus
    ),
    rooms,
    services
  }
}

export const convertBackendReservationsToFrontend = (
  reservations: GetReservationsResponse
): Reservation[] => {
  return reservations.map((reservation) => {
    return convertBackendReservationToFrontend(reservation)
  })
}



export const convertBackendReservationsToFrontendAdmin = (
  reservations: BackendReservation[]
): Reservation[] => {
  return reservations.map((reservation) => {
    return convertBackendReservationToFrontend(reservation)
  })
}


export const convertBackendReservationsAdminToFrontend = (
  hotelReservations: Map<string, BackendReservation[]>
): Map<string, Reservation[]> => {

  const result : Map<string, Reservation[]> = new Map()

  Object.entries(hotelReservations).map( values => {
    result.set(values[0], convertBackendReservationsToFrontendAdmin(values[1]))
  })

  return result
}