import type { Room } from '@/types/Room'

export enum ReservationStatus {
  ON_GOING = 'On going',
  DONE = 'Done',
  CANCELLED = 'Cancelled',
  SCHEDULED = 'Scheduled'
}

export interface Service {
  id: number
  name: string
  price: number
}

/*
"hospede": {
      "email": "string",
      "password": "string",
      "salt": "string",
      "nome": "string",
      "dataNascimento": "2023-06-19T14:06:29.573Z",
      "numTelemovel": "string",
      "morada": "string",
      "cc": "string",
      "nif": "string",
      "id": 0,
      "ormid": 0
    },
 */
export interface Guest {
  id: number
  email: string
  name: string
  birthDate: Date
  phoneNumber: string
  address: string
  cc: string
  nif: string
}

export interface Reservation {
  id: number
  guestId: number
  guestName: string
  guest?: Guest
  inDate: Date
  outDate: Date
  price: number
  status: ReservationStatus
  rooms: Room[]
  services?: Service[] // Only set when reservation is ON_GOING or DONE
}
