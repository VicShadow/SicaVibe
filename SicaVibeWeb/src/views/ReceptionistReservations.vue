<script lang="ts" setup>
import ReservationTable from '@/components/tables/ReservationTable.vue'
import TextField from '@/components/TextField.vue'
import { ref } from 'vue'
import { useReservations } from '@/hooks/useReservations'
import { getToken } from '@/services/storage/sessionStorage'
import { VSkeletonLoader } from 'vuetify/labs/components'

const guestName = ref('')
const currentPage = ref(1)
const pagesize = ref(10)
new Date()
new Date()
const token = getToken()

if (!token) {
  throw new Error('No token found')
}

const { reservations, isLoading } = useReservations({
  token,
  guestName: guestName,
  page: currentPage,
  pagesize: pagesize
})

const addRoomHandler = () => {}
</script>

<template>
  <div>
    <v-breadcrumbs :items="['Reservations']" class="pa-0" />
    <div class="d-flex justify-space-between">
      <h1 class="text-h5 d-inline">Reservations</h1>
      <v-btn class="bg-blue-darken-2 elevation-0 text-capitalize" @click="addRoomHandler">
        Make Reservation
      </v-btn>
    </div>
  </div>
  <TextField v-model:value="guestName" label="Guest Name" max-width="250px" type="text"></TextField>
  <v-skeleton-loader v-if="isLoading" type="table" />
  <ReservationTable v-if="reservations" :reservations="reservations" />
</template>

<style scoped></style>
