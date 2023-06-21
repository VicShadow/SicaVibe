<script lang="ts" setup>
import RoomTable from '@/components/tables/RoomTable.vue'
import TextField from '@/components/TextField.vue'
import { ref } from 'vue'
import AddRoomModal from '@/components/modals/AddRoomModal.vue'
import { useRooms } from '@/hooks/useRooms'
import { VSkeletonLoader } from 'vuetify/labs/components'

const isModalOpen = ref(false)

const id = ref<number>()

const { rooms, isLoading, isSuccess, isError } = useRooms({ id })

const addRoomHandler = () => {
  isModalOpen.value = true
}
</script>

<template>
  <div>
    <v-breadcrumbs :items="['Rooms']" class="pa-0" />
    <div class="d-flex justify-space-between">
      <h1 class="text-h5 d-inline">Rooms</h1>
      <v-btn class="bg-blue-darken-2 elevation-0 text-capitalize" @click="addRoomHandler"
        >Add New Room
      </v-btn>
    </div>
  </div>
  <TextField
    v-model.number:value="id"
    label="Identificador"
    max-width="250px"
    type="number"
  ></TextField>
  <v-alert v-if="isError" class="mt-4" type="error">
    <span class="text-h6">Error loading rooms</span>
  </v-alert>
  <v-skeleton-loader v-if="isLoading" type="table" />
  <RoomTable v-if="isSuccess && rooms" :rooms="rooms" />
  <AddRoomModal v-model:is-modal-open="isModalOpen" />
</template>

<style scoped></style>
