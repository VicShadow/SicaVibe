<script lang="ts" setup>
import RoomTable from '@/components/tables/RoomTable.vue'
import { Room, RoomStatus } from '@/types/Room'
import TextField from '@/components/TextField.vue'
import { ref } from 'vue'
import AddRoomModal from '@/components/modals/AddRoomModal.vue'

const isModalOpen = ref(false)

const id = ref('')

const rooms: Room[] = [
  {
    id: 1,
    typeId: 1,
    typeName: 'Single',
    doorNumber: 101,
    status: RoomStatus.OCCUPIED
  }
]

const addRoomHandler = () => {
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
