<script lang="ts" setup>
import { useRoute } from 'vue-router'
import { computed, ref, toRefs } from 'vue'
import { Reservation, ReservationStatus } from '@/types/Reservation'
import { formatDate } from '@/services/formatter'
import ConfirmationModal from '@/components/modals/ConfirmationModal.vue'
import { RoomStatus } from '@/types/Room'
import { checkInReservation } from '@/services/backend/reservations/checkInReservation'
import { getToken } from '@/services/storage/sessionStorage'
import { checkOutReservation } from '@/services/backend/reservations/checkOutReservation'

const isCheckInModalOpen = ref(false)
const isCheckOutModalOpen = ref(false)
const isCancelModalOpen = ref(false)

const route = useRoute()

const { id } = route.params

const mockReservation = ref<Reservation>({
  id: 1,
  guestId: 1,
  inDate: new Date(),
  outDate: new Date(),
  price: 100,
  status: ReservationStatus.DONE,
  rooms: [
    {
      id: 1,
      typeId: 1,
      typeName: 'Single',
      doorNumber: 1,
      status: RoomStatus.AVAILABLE
    }
  ]
})

const { guestId, inDate, outDate, price, status } = mockReservation // TODO: Add toRefs when the reservation becomes reactive

/* --------------------- Formatted values --------------------- */
const formattedStatus = computed(() => {
  return status === ReservationStatus.DONE ? 'Done' : 'Pending'
})

const formattedInDate = computed(() => {
  return formatDate(inDate)
})

const formattedOutDate = computed(() => {
  return formatDate(outDate)
})

const isCheckInDisabled = computed(() => {
  // TODO: Implement check-in disabled check
  return false
})

const isCheckOutDisabled = computed(() => {
  // TODO: Implement check-out disabled check
  return true
})

const isCancelDisabled = computed(() => {
  // TODO: Implement cancel disabled check
  return false
})

/* --------------------- Handlers --------------------- */
const token = getToken()

if (!token) {
  throw new Error('Token not found')
}

const checkInHandler = async () => {
  // TODO: Implement check-in handler
  const reservation = await checkInReservation(token, id as number)

  if (reservation) {
    mockReservation.value = reservation
  }

  isCheckInModalOpen.value = false
}

const checkOutHandler = async () => {
  // TODO: Implement check-out handler

  const reservation = await checkOutReservation(token, id as number)

  if (reservation) {
    mockReservation.value = reservation
  }

  isCheckOutModalOpen.value = false
}

const cancelHandler = async () => {
  // TODO: Implement cancel handler
  const reservation = await checkOutReservation(token, id as number)

  if (reservation) {
    mockReservation.value = reservation
  }

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
  <div class="reservation-card">
    <div>Made by user with id: {{ guestId }}.</div>
    <div>Price: {{ price }} €</div>
    <!-- TODO: Add user name -->
    <div class="schedule">
      Schedule from
      <!--
      <span class="text-h6">
        {{ formattedInDate }}
      </span>
      until
      <span class="text-h6">
        {{ formattedOutDate }}
      </span>
      -->
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
