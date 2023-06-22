import { backend } from '@/services/backend/backend'

export interface MakeReservationProps {
  token: string
  hotelId: number
  inDate: string
  outDate: string
  rooms: {
    [key: number]: number // roomType: number of rooms
  }[]
  services: number[] // service ids
}

const MAKE_RESERVATION_ENDPOINT = '/hospede/make-reservation'

export type Price = number

export const makeReservation = async (
  {
    token,
    hotelId,
    inDate,
    outDate,
    rooms,
    services
  }: MakeReservationProps) : Promise<Price> => {
  const headers = {
    token
  }

  const body = {
    hotelid: hotelId,
    dataentrada: inDate,
    datasaida: outDate,
    quartos: rooms,
    servicosextra: services
  }

  const response = await backend.post(MAKE_RESERVATION_ENDPOINT, body, { headers })

  if (response.status !== 200) {
    throw new Error('Failed to make reservation')
  }

  return response.data as Price
}
