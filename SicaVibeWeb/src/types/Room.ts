export enum RoomStatus {
  OCCUPIED = 'ocupado',
  AVAILABLE = 'disponível',
  MAINTENANCE = 'manutenção',
  RESERVED = 'reservado'
}

export interface Room {
  id: number
  typeId: number
  typeName: string
  doorNumber: number
  status: string
}
