import { backend } from '@/services/backend/backend'
import { type Reservation, ReservationStatus, type Service } from '@/types/Reservation'
import type { Token } from '@/types/Token'
import type { Room, RoomStatus } from '@/types/Room'

export interface GetReservationsProps {
  token: Token
  type?: ReservationStatus
  guestCC?: string
  guestName?: string
  page: number
  pagesize: number
}

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

interface BackendReservation {
  hospedeId: number
  hospede: Hospede | null
  dataEntrada: string
  dataSaida: string
  preco: number
  estado: string
  quartos: Quarto[]
  servicosExtras: ServicoExtra[]
}

export type GetReservationsResponse = BackendReservation[]

const GET_RESERVATIONS_ENDPOINT = '/funcionario/list-reservations'

const convertReservationStatus = (status: ReservationStatus): string => {
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

const convertBackendReservationsToFrontend = (
  reservations: GetReservationsResponse
): Reservation[] => {
  return reservations.map((reservation) => {
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
      inDate: new Date(reservation.dataEntrada),
      outDate: new Date(reservation.dataSaida),
      price: reservation.preco,
      status: reservation.estado as ReservationStatus,
      rooms,
      services
    }
  })
}

export const getReservations = async ({
  type,
  guestCC,
  guestName,
  page,
  pagesize,
  token
}: GetReservationsProps): Promise<Reservation[]> => {
  let headers = {
    token,
    page,
    pagesize
  }

  if (type) {
    headers = {
      ...headers,
      // @ts-ignore
      type: convertReservationStatus(type)
    }
  }

  if (guestCC) {
    headers = {
      ...headers,
      // @ts-ignore
      guestCC
    }
  }

  if (guestName) {
    headers = {
      ...headers,
      // @ts-ignore
      guestName
    }
  }

  const res = await backend.get(GET_RESERVATIONS_ENDPOINT, {
    headers
  })

  if (res.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  const backendData = res.data as GetReservationsResponse

  return convertBackendReservationsToFrontend(backendData)
}
