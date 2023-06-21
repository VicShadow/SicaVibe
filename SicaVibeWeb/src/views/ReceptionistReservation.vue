<script lang="ts" setup>
import { useRoute } from 'vue-router'
import { computed, ref } from 'vue'
import { ReservationStatus } from '@/types/Reservation'
import { formatDate } from '@/services/formatter'
import ConfirmationModal from '@/components/modals/ConfirmationModal.vue'
import { getToken } from '@/services/storage/sessionStorage'
import { useReservation } from '@/hooks/useReservation'
import { VSkeletonLoader } from 'vuetify/labs/components'
import { useReservationMutation } from '@/hooks/useReservationMutation'

const isCheckInModalOpen = ref(false)
const isCheckOutModalOpen = ref(false)
const isCancelModalOpen = ref(false)

const route = useRoute()

const { id } = route.params

const reservationId = computed(() => {
  return parseInt(id as string)
})

const token = getToken()

if (!token) {
  throw new Error('Token not found')
}

const { reservation, isLoading, isError, isSuccess, error } = useReservation({
  token,
  reservationId
})

const { checkInMutation, checkOutMutation, cancelMutation } = useReservationMutation({
  token,
  reservationId: reservationId
})

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

const isCheckInDisabled = computed(() => {
  if (!reservation.value) return true

  return reservation.value.status !== ReservationStatus.SCHEDULED
})

const isCheckOutDisabled = computed(() => {
  if (!reservation.value) return true

  return reservation.value.status !== ReservationStatus.ON_GOING
})

const isCancelDisabled = computed(() => {
  if (!reservation.value) return true

  return reservation.value.status !== ReservationStatus.SCHEDULED
})

/* --------------------- Handlers --------------------- */
const checkInHandler = () => {
  checkInMutation.mutate()

  isCheckInModalOpen.value = false
}

const checkOutHandler = () => {
  checkOutMutation.mutate()

  isCheckOutModalOpen.value = false
}

const cancelHandler = async () => {
  cancelMutation.mutate()

  isCancelModalOpen.value = false
}

/* --------------------- Modals --------------------- */
const openCheckInModal = () => {
  isCheckInModalOpen.value = true
}

const openCheckOutModal = () => {
  isCheckOutModalOpen.value = true
}

const openCancelModal = () => {
  isCancelModalOpen.value = true
}

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
      <div class="actions">
        <v-btn
          :disabled="isCheckInDisabled"
          :ripple="false"
          class="bg-blue-darken-2 elevation-0 text-capitalize"
          @click="openCheckInModal"
        >
          Check In
        </v-btn>
        <v-btn
          :disabled="isCheckOutDisabled"
          :ripple="false"
          class="bg-blue-darken-2 elevation-0 text-capitalize"
          @click="openCheckOutModal"
        >
          Check Out
        </v-btn>
        <v-btn
          :disabled="isCancelDisabled"
          :ripple="false"
          class="bg-red-darken-3 elevation-0 text-capitalize"
          @click="openCancelModal"
        >
          Cancel
        </v-btn>
      </div>
    </div>
  </div>
  <v-skeleton-loader v-if="isLoading" type="table" />

  <div v-if="isError" class="text-h6 text-red-darken-3">{{ error }}</div>

  <div v-if="isSuccess && reservation" class="reservation-card">
    <div>Made by user with id: {{ reservation.guestId }}.</div>
    <div>Price: {{ reservation.price }} €</div>
    <div>Guest Name: {{ reservation.guestName }}</div>
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
  <ConfirmationModal
    v-model:is-open="isCheckInModalOpen"
    :is-open="isCheckInModalOpen"
    message="Are you sure you want to check in the reservation?"
    title="Check In"
    @cancel="isCheckInModalOpen = false"
    @confirm="checkInHandler"
  />
  <ConfirmationModal
    v-model:is-open="isCheckOutModalOpen"
    :is-open="isCheckOutModalOpen"
    message="Are you sure you want to check out the reservation?"
    title="Check Out"
    @cancel="isCheckOutModalOpen = false"
    @confirm="checkOutHandler"
  />
  <ConfirmationModal
    v-model:is-open="isCancelModalOpen"
    :is-open="isCancelModalOpen"
    message="Are you sure you want to cancel the reservation?"
    title="Cancel"
    @cancel="isCancelModalOpen = false"
    @confirm="cancelHandler"
  />
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
