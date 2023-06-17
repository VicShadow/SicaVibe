<script lang="ts" setup>
import { toRefs } from 'vue'
import type { Reservation } from '@/types/Reservation'

interface Props {
  reservations: Reservation[]
}

const props = defineProps<Props>()

const { reservations } = toRefs(props)
</script>

<template>
  <v-table>
    <thead>
      <tr>
        <th class="text-left px-0">Identificador</th>
        <th class="text-left">Descrição</th>
        <th class="text-left">Estado</th>
        <th class="text-left">Utilizador</th>
        <th class="text-left">Serviços</th>
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
          <v-btn class="text-capitalize" variant="tonal">See Services</v-btn>
        </td>
      </tr>
    </tbody>
  </v-table>
</template>

<style scoped>
.status {
  color: var(--color-text);
  font-weight: bold;
  text-transform: capitalize;
}
</style>
