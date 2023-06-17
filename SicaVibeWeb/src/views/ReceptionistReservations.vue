<script lang="ts" setup>
import ReservationTable from '@/components/tables/ReservationTable.vue'
import type { Reservation } from '@/types/Reservation'
import { ReservationStatus } from '@/types/Reservation'
import TextField from '@/components/TextField.vue'
import { ref } from 'vue'

const id = ref('')

const reservations: Reservation[] = [
  {
    id: 1,
    userId: 1,
    status: ReservationStatus.DONE,
    checkedInAt: new Date('2021-10-10'),
    checkedOutAt: new Date('2021-10-11'),
    scheduledAt: new Date('2021-10-09'),
    scheduledTo: new Date('2021-10-10')
  },
  {
    id: 2,
    userId: 2,
    status: ReservationStatus.DONE,
    checkedInAt: new Date('2021-10-10'),
    checkedOutAt: new Date('2021-10-11'),
    scheduledAt: new Date('2021-10-09'),
    scheduledTo: new Date('2021-10-10')
  },
  {
    id: 3,
    userId: 3,
    status: ReservationStatus.DONE,
    checkedInAt: new Date('2021-10-10'),
    checkedOutAt: new Date('2021-10-11'),
    scheduledAt: new Date('2021-10-09'),
    scheduledTo: new Date('2021-10-10')
  },
  {
    id: 4,
    userId: 4,
    status: ReservationStatus.DONE,
    checkedInAt: new Date('2021-10-10'),
    checkedOutAt: new Date('2021-10-11'),
    scheduledAt: new Date('2021-10-09'),
    scheduledTo: new Date('2021-10-10')
  }
]

const addRoomHandler = () => {
  console.log('id=', id.value)
}
</script>

<template>
  <div>
    <v-breadcrumbs :items="['Reservations']" class="pa-0" />
    <div class="d-flex justify-space-between">
      <h1 class="text-h5 d-inline">Reservations</h1>
      <v-btn class="bg-blue-darken-2 elevation-0 text-capitalize" @click="addRoomHandler"
        >Make Reservation
      </v-btn>
    </div>
  </div>
  <TextField v-model:value="id" label="Identificador" max-width="250px" type="number"></TextField>
  <ReservationTable :reservations="reservations" />
</template>

<style scoped></style>
