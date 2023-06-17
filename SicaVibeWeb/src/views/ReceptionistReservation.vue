<script lang="ts" setup>
import { useRoute } from 'vue-router'
import { computed, ref } from 'vue'
import { Reservation, ReservationStatus } from '@/types/Reservation'
import { formatDate } from '@/services/formatter'
import ConfirmationModal from '@/components/modals/ConfirmationModal.vue'

const isCheckInModalOpen = ref(false)
const isCheckOutModalOpen = ref(false)

const route = useRoute()

const { id } = route.params

const mockReservation: Reservation = {
  id: 1,
  userId: 1,
  status: ReservationStatus.DONE,
  checkedInAt: new Date('2021-10-10'),
  checkedOutAt: new Date('2021-10-11'),
  scheduledUntil: new Date('2021-10-09'),
  scheduledAt: new Date('2021-10-09'),
  scheduledTo: new Date('2021-10-10')
}

const { userId, status, checkedInAt, checkedOutAt, scheduledAt, scheduledTo, scheduledUntil } =
  mockReservation

const formattedStatus = computed(() => {
  return status === ReservationStatus.DONE ? 'Done' : 'Pending'
})

const formattedScheduledAt = computed(() => {
  return formatDate(scheduledAt)
})

const formattedScheduledTo = computed(() => {
  return formatDate(scheduledTo)
})

const formattedScheduledUntil = computed(() => {
  return formatDate(scheduledUntil)
})

const formattedCheckedInAt = computed(() => {
  if (!checkedInAt) return 'Not checked in'
  return formatDate(checkedInAt)
})

const formattedCheckedOutAt = computed(() => {
  if (!checkedOutAt) return 'Not checked out'
  return formatDate(checkedOutAt)
})

const isCheckInDisabled = computed(() => {
  // TODO: Implement check-in disabled check
  return false
})

const isCheckOutDisabled = computed(() => {
  // TODO: Implement check-out disabled check
  return true
})

const checkInHandler = () => {
  // TODO: Implement check-in handler
  isCheckInModalOpen.value = false
  console.log('Check In')
}

const checkOutHandler = () => {
  // TODO: Implement check-out handler
  isCheckOutModalOpen.value = false
  console.log('Check Out')
}

const openCheckInModal = () => {
  isCheckInModalOpen.value = true
}

const openCheckOutModal = () => {
  isCheckOutModalOpen.value = true
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
      </div>
    </div>
  </div>
  <div class="reservation-card">
    <div>Made by user with id: {{ userId }}.</div>
    <!-- TODO: Add user name -->
    <div class="schedule">
      Schedule from
      <span class="text-h6">
        {{ formattedScheduledTo }}
      </span>
      until
      <span class="text-h6">
        {{ formattedScheduledUntil }}
      </span>
    </div>
    <div class="checks">
      <div>Checked in at {{ formattedCheckedInAt }}.</div>
      <div>Checked out at {{ formattedCheckedOutAt }}.</div>
    </div>
    <div class="status">
      Reservation Status:
      <span class="text-capitalize text-h6">{{ formattedStatus }}</span>
    </div>
  </div>
  <ConfirmationModal
    v-model:is-open="isCheckInModalOpen"
    :is-open="isCheckInModalOpen"
    message="Are you sure you want to check in?"
    title="Check In"
    @cancel="isCheckInModalOpen = false"
    @confirm="checkInHandler"
  />
  <ConfirmationModal
    v-model:is-open="isCheckOutModalOpen"
    :is-open="isCheckOutModalOpen"
    message="Are you sure you want to check out?"
    title="Check Out"
    @cancel="isCheckOutModalOpen = false"
    @confirm="checkOutHandler"
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

.checks {
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
