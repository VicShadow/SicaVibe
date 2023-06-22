<script setup lang='ts'>
import { toRefs } from 'vue'

export interface RoomCardSelectorProps {
  id: number
  roomName: string
  description: string
  imgID: number
  price: number
  capacity: number
  numberOfRoomsSelected: number
}

const props = defineProps<RoomCardSelectorProps>()

const { roomName, description, imgID, price, capacity } = toRefs(props)
</script>

<template>
  <div class='card'>
    <div class='card-left'>
      <v-img :cover='true' class='img' src='https://images.unsplash.com/photo-1606258566788-7feca2a53560?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=687&q=80'
             height='200px' width='100%'></v-img>
      <div class='title-container'>
        <h1>{{ roomName }}</h1>
        <p class='description'>{{ description }}</p>
      </div>
    </div>
    <div class='card-right'>
      <span class='text-h5'>Nº People: {{ capacity }}</span>
      <span class='text-h5'>Price/Night {{ price }}€</span>
      <span class='text-h5'>{{ numberOfRoomsSelected }} rooms selected</span>
    </div>
  </div>
</template>

<style scoped>
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
