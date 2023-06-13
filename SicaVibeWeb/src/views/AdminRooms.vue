<script lang="ts" setup>
import RoomTable from '@/components/RoomTable.vue'
import { Room, RoomStatus } from '@/types/Room'

const rooms: Room[] = [
  {
    id: 1,
    description: 'Room 1',
    status: RoomStatus.OCCUPIED,
    user_id: 2
  },
  {
    id: 2,
    description: 'Room 2',
    status: RoomStatus.AVAILABLE
  },
  {
    id: 3,
    description: 'Room 3',
    status: RoomStatus.MAINTENANCE
  },
  {
    id: 4,
    description: 'Room 4',
    status: RoomStatus.RESERVED,
    user_id: 1
  },
  {
    id: 5,
    description: 'Room 5',
    status: RoomStatus.AVAILABLE
  }
]
</script>

<template>
  <v-breadcrumbs :items="['Quartos']" class="px-0"></v-breadcrumbs>
  <div class="d-flex justify-space-between">
    <h1 class="text-h5 d-inline">Quartos</h1>
    <v-btn class="bg-blue-darken-2 elevation-0"> Adicionar Quarto</v-btn>
  </div>
  <v-responsive max-width="344">
    <v-text-field hide-details label="Identificador" single-line></v-text-field>
  </v-responsive>
  <RoomTable :rooms="rooms" />
</template>

<style scoped></style>
