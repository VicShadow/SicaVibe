<script lang="ts" setup>
import { toRefs } from 'vue'
import type { Reservation } from '@/types/Reservation'
import { useRouter } from 'vue-router'
import { formatDate } from '@/services/formatter'

interface Props {
  reservations: Reservation[],
  isAdmin?: boolean
}

const props = defineProps<Props>()

const { reservations } = toRefs(props)

const router = useRouter()

const onReservationClick = (id: number) => {
  if (!props.isAdmin) router.push(`/receptionist/reservations/${id}`)
  else router.push(`/admin/reservation/${id}`)
}
</script>

<template>
  <v-table class="table">
    <thead>
      <tr>
        <th class="text-left px-0">Id</th>
        <th class="text-left">Guest Id</th>
        <th class="text-left">Guest Name</th>
        <th class="text-left">In Date</th>
        <th class="text-left">Out Date</th>
        <th class="text-left">Price</th>
        <th class="text-left">Status</th>
        <th class="text-left">Room Number</th>
        <th class="text-left">Any Services?</th>
        <th class="text-left w-0"></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="reservation in reservations" :key="reservation.id">
        <td class="px-0">{{ reservation.id }}</td>
        <td>{{ reservation.guestId }}</td>
        <td>{{ isAdmin ? reservation.guest?.name : reservation.guestName }}</td>
        <td>{{ formatDate(reservation.inDate) }}</td>
        <td>{{ formatDate(reservation.outDate) }}</td>
        <td>{{ reservation.price }}</td>
        <td class="status">{{ reservation.status }}</td>
        <!-- TODO: Add color for each type of status as in the design -->
        <td>{{ reservation.rooms.length }}</td>
        <td>{{ !reservation.services || reservation.services.length === 0 ? 'No' : 'Yes' }}</td>
        <td>
          <v-btn class="text-capitalize" variant="tonal" @click="onReservationClick(reservation.id)"
            >See Reservation
          </v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>

<style scoped>
.table {
  width: 100%;
}

.status {
  color: var(--color-text);
  font-weight: bold;
  text-transform: capitalize;
}
</style>
