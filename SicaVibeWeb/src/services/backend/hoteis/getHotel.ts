import { backend } from '@/services/backend/backend'

export const getHotel = async (id: number) => {
    const res = await backend.get(`/data/hotel/${id}`)
  
    if (res.status !== 200) {
      throw new Error('Failed to get hoteis')
    }
  
    return res.data
}