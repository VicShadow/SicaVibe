<script lang="ts" setup>
import { toRefs } from 'vue'
import type { Reservation } from '@/types/Reservation'
import { useRouter } from 'vue-router'

interface Props {
  reservations: Reservation[]
}

const props = defineProps<Props>()

const { reservations } = toRefs(props)

const router = useRouter()

const onReservationClick = (id: number) => {
  router.push(`/receptionist/reservations/${id}`)
}
</script>

<template>
  <v-table class="table">
    <thead>
      <tr>
        <th class="text-left px-0">Identificador</th>
        <th class="text-left">Descrição</th>
        <th class="text-left">Estado</th>
        <th class="text-left w-0">Utilizador</th>
        <th class="text-left w-0" />
      </tr>
    </thead>
    <tbody>
      <tr v-for="reservation in reservations" :key="reservation.id">
        <td class="px-0">{{ reservation.id }}</td>
        <td>{{ reservation.description }}</td>
        <td class="status">{{ reservation.status }}</td>
        <!-- TODO: Add color for each type of status as in the design -->
        <td>{{ reservation.userId ?? '' }}</td>
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
  //max-width: 1000px; width: 100%;
}

.status {
  color: var(--color-text);
  font-weight: bold;
  text-transform: capitalize;
}
</style>
