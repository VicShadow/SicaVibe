import { backend } from '@/services/backend/backend'

export interface GetReservationsProps {
  // TODO: Define props
}

export const getReservations = async (props: GetReservationsProps) => {
  // TODO: Not implemented yet
  const res = await backend.get('/reservations')

  if (res.status !== 200) {
    // TODO: Improve error handling
    throw new Error('Failed to get reservations')
  }

  return res.data
}
