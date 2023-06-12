export enum RoomStatus {
  OCCUPIED = 'ocupado',
  AVAILABLE = 'disponível',
  MAINTENANCE = 'manutenção',
  RESERVED = 'reservado',
}

export interface Room {
  id: number;
  description?: string;
  status: RoomStatus;
  user_id?: number; // Set when status is either OCCUPIED or RESERVED
}
