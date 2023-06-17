<script lang="ts" setup>
import RoomTable from '@/components/RoomTable.vue'
import { Room, RoomStatus } from '@/types/Room'
import TextField from '@/components/TextField.vue'
import { ref } from 'vue'
import AddRoomModal from '@/components/modals/AddRoomModal.vue'

const isModalOpen = ref(false)

const id = ref('')

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

const addRoomHandler = () => {
  console.log('id=', id.value)
  isModalOpen.value = true
}
</script>

<template>
  <div>
    <v-breadcrumbs :items="['Quartos']" class="pa-0" />
    <div class="d-flex justify-space-between">
      <h1 class="text-h5 d-inline">Quartos</h1>
      <v-btn class="bg-blue-darken-2 elevation-0 text-capitalize" @click="addRoomHandler"
        >Adicionar Quarto
      </v-btn>
    </div>
  </div>
  <TextField v-model:value="id" label="Identificador" max-width="250px" type="number"></TextField>
  <RoomTable :rooms="rooms" />
  <AddRoomModal v-model:is-modal-open="isModalOpen" />
</template>

<style scoped></style>
