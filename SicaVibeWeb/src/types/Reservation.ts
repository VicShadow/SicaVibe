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
  userId: number
  description?: string
  status: ReservationStatus
  scheduledAt: Date
  scheduledTo: Date
  checkedInAt?: Date // Only set when reservation is ON_GOING or DONE
  checkedOutAt?: Date // Only set when reservation is DONE
  services?: Service[] // Only set when reservation is ON_GOING or DONE
}
