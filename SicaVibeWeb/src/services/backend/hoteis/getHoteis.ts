import { backend } from '@/services/backend/backend'

export const getHoteis = async () => {
    const res = await backend.get('/data/hoteis')
  
    if (res.status !== 200) {
      throw new Error('Failed to get hoteis')
    }
  
    return res.data
  }