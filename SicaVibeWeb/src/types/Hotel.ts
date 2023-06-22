import type { RoomType } from '@/services/backend/rooms/getRoomTypes'

export interface Hotel {
  nome: string,
  descricao: string,
  imgID: number,
  endereco: string,
  servicoExtraSet: ServicoExtra[],
  tipoDeQuartoSet: TipoQuarto[],
  id: number
}

export interface TipoQuarto {
  nome: string,
  capacidade: number,
  preco: number,
  descricao: string,
  imgID: number,
  id: number
}

export interface ServicoExtra {
  nome: string,
  preco: number,
  id: number
}

export interface RoomTypeAvailable extends RoomType {
  roomsAvailable: number
}
