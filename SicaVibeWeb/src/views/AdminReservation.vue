<script lang="ts" setup>
import { useRoute } from 'vue-router'
import { computed, ref } from 'vue'
import { type Reservation } from '@/types/Reservation'
import { formatDate } from '@/services/formatter'
import { getToken } from '@/services/storage/sessionStorage'
import { getReservation } from '@/services/backend/admin/getReservation'

const route = useRoute()

const { id } = route.params

const reservationID = computed(() => {
  return parseInt(id as string)
})

const token = getToken()

if (!token) {
  throw new Error('Token not found')
}

const reservation = ref<Reservation>()
getReservation({ token: token, reservationId: reservationID.value }).then(res => { reservation.value = res })

/* --------------------- Formatted values --------------------- */
const formattedStatus = computed(() => {
  if (!reservation.value) return ''
  return reservation.value.status
})

const formattedInDate = computed(() => {
  if (!reservation.value) return ''

  return formatDate(reservation.value.inDate)
})

const formattedOutDate = computed(() => {
  if (!reservation.value) return ''
  return formatDate(reservation.value.outDate)
})





const breadcrumbItems = computed(() => {
  return [
    {
      title: 'Reservations',
      to: '/receptionist/reservations',
      disabled: false,
      exact: true
    },
    {
      title: `Reservation id ${id}`,
      to: `reservations/${id}`,
      disabled: true
    }
  ]
})
</script>

<template>
  <div>
    <v-breadcrumbs :items="breadcrumbItems" class="pa-0" />
    <div class="d-flex justify-space-between">
      <h1 class="text-h5 d-inline">Reservation id {{ id }}</h1>
    </div>
  </div>

  <div class="reservation-card">
    <div>Made by user with id: {{ reservation?.guestId }}.</div>
    <div>Price: {{ reservation?.price }} €</div>
    <div>Guest Name: {{ reservation?.guestName }}</div>
    <div class="schedule">
      Schedule from
      <span class="text-h6">
        {{ formattedInDate }}
      </span>
      until
      <span class="text-h6">
        {{ formattedOutDate }}
      </span>
    </div>
    <div class="status">
      Reservation Status:
      <span class="text-capitalize text-h6">{{ formattedStatus }}</span>
    </div>
  </div>
 
</template>

<style scoped>
.actions {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  gap: 1rem;
}

.schedule {
  padding: 2rem;
  background: #e0e0e0;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  gap: 1rem;
}

.status {
  padding: 2rem;
  display: flex;
  flex-direction: column;
  gap: 0.25rem;
  background: #e0e0e0;
}

.reservation-card {
}
</style>
