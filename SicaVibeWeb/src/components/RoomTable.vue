<script setup lang='ts'>

import { type Room } from '@/types/Room'
import { toRefs } from 'vue'

interface Props {
  rooms: Room[]
}

const props = defineProps<Props>()

const { rooms } = toRefs(props)

</script>

<template>
  <v-table>
    <thead>
    <tr>
      <th class='text-left px-0'>Identificador</th>
      <th class='text-left'>Descrição</th>
      <th class='text-left'>Estado</th>
      <th class='text-left'>Utilizador</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for='room in rooms' :key='room.id'>
      <td class='px-0'>{{ room.id }}</td>
      <td>{{ room.description }}</td>
      <td class='status'>{{ room.status }}</td> <!-- TODO: Add color for each type of status as in the design -->
      <td> {{ room.user_id ?? '' }}</td>
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
