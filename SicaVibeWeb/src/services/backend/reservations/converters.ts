import { type Reservation, ReservationStatus, type Service } from '@/types/Reservation'
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

export const convertReservationStatusToBackend = (status: ReservationStatus): string => {
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

  return {
    id: reservation.hospedeId,
    guestId: reservation.hospedeId,
    guestName: reservation.hospedeNome,
    inDate: new Date(reservation.dataEntrada),
    outDate: new Date(reservation.dataSaida),
    price: reservation.preco,
    status: reservation.estado as ReservationStatus,
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
