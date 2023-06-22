<script setup lang='ts'>
import { computed, toRefs } from 'vue'

export interface RoomCardSelectorProps {
  id: number
  roomName: string
  description: string
  imgID: number
  price: number
  capacity: number
  numberOfRoomsSelected: number
}

export interface RoomCardSelectorEmits {
  (e: 'increaseRoomSelection', roomTypeId: number): void

  (e: 'decreaseRoomSelection', roomTypeId: number): void
}

const props = defineProps<RoomCardSelectorProps>()

const { roomName, description, imgID, price, capacity } = toRefs(props)

const emit = defineEmits<RoomCardSelectorEmits>()

const src = computed(() => {
  // TODO: get image from backend
  return import.meta.env.VITE_BACKEND_URL + "/imagem/" + imgID.value
})

</script>

<template>
  <div class='card'>
    <div class='card-left'>
      <v-img :cover='true' class='img' :src='src'
             height='100%' width='100%'></v-img>
      <div class='title-container'>
        <h1>{{ roomName }}</h1>
        <p class='description'>{{ description }}</p>
      </div>
    </div>
    <div class='card-right'>
      <span class='text-h6'>Nº People: {{ capacity }}</span>
      <span class='text-h6'>Price/Night {{ price }}€</span>
      <div class='input-room-number'>
        <button class='minus-button' @click='emit("decreaseRoomSelection", id)'>-</button>
        <span class='selected-rooms'>{{ numberOfRoomsSelected }}</span>
        <button class='plus-button' @click='emit("increaseRoomSelection", id)'>+</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.input-room-number {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
}

.selected-rooms {
  font-size: 1.28rem;
  border: 1px solid #000000;
  padding: 0.25rem 0.5rem;
}

.minus-button, .plus-button {
  height: 100%;
  aspect-ratio: 1;
  font-size: 1.5rem;
  font-weight: bold;
  background: #f7f7f7;
  padding: 0.25rem 0.5rem;
}

.title-container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-start;
  gap: 0.25rem;
  overflow: hidden;
}

.description {
  width: 100%;
  max-width: 450px;
  max-height: 160px;
  overflow: hidden;
  text-overflow: ellipsis;
}

.card {
  width: 100%;
  max-height: 180px;
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  justify-content: space-between;
  border-radius: 10px;
  background: #ffffff;
}

.card-left {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  justify-content: flex-start;
  gap: 1rem;
  overflow: hidden;
}

.card-right {
  padding: 1rem;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-between;
  gap: 1rem;
}

.img {
  max-height: 180px;
  max-width: 180px;
  aspect-ratio: 1;
  border-radius: 10px;
  overflow: clip;
}
</style>
