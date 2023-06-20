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

export interface Reservation {
  id: number
  guestId: number
  guestName: string
  inDate: Date
  outDate: Date
  price: number
  status: ReservationStatus
  rooms: Room[]
  services?: Service[] // Only set when reservation is ON_GOING or DONE
}
