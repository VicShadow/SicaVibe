<script lang='ts' setup>
import RoomTable from '@/components/tables/RoomTable.vue'
import TextField from '@/components/TextField.vue'
import { ref } from 'vue'
import AddRoomModal from '@/components/modals/AddRoomModal.vue'
import { useHotelRooms } from '@/hooks/useHotelRooms'
import { VSkeletonLoader } from 'vuetify/labs/components'

const isModalOpen = ref(false)

const hotelId = ref<number>()

const { hotelRooms, isLoading, isSuccess, isError } = useHotelRooms({ hotelId })

const addRoomHandler = () => {
  isModalOpen.value = true
}
</script>

<template>
  <div>
    <v-breadcrumbs :items="['Rooms']" class='pa-0' />
    <div class='d-flex justify-space-between'>
      <h1 class='text-h5 d-inline'>Rooms</h1>
      <v-btn class='bg-blue-darken-2 elevation-0 text-capitalize' @click='addRoomHandler'
      >Add New Room
      </v-btn>
    </div>
  </div>
  <TextField
    v-model.number:value='hotelId'
    label='Hotel Id'
    max-width='250px'
    type='number'
  ></TextField>
  <v-alert v-if='isError' class='mt-4' type='error'>
    <span class='text-h6'>Error loading rooms</span>
  </v-alert>
  <v-skeleton-loader v-if='isLoading' type='table' />
  <div v-if='hotelRooms && isSuccess'>
    <div v-for='[hotelId, rooms] in Object.entries(hotelRooms)' :key='hotelId' class='container'>
      <div class='tableTitle'>Hotel id: {{ hotelId }}</div>
      <RoomTable v-if='isSuccess && rooms' :rooms='rooms' />
    </div>
  </div>

  <AddRoomModal v-model:is-modal-open='isModalOpen' />
</template>

<style scoped>

.tableTitle {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 20px;
}

</style>
