<script setup lang='ts'>

import { Room } from '@/types/Room'

interface Props {
  rooms: Room[]
}

const props = defineProps<Props>()

</script>

<template>
  <v-table>
    <thead>
    <tr>
      <th class='text-left'>Identificador</th>
      <th class='text-left'>Descrição</th>
      <th class='text-left'>Estado</th>
      <th class='text-left'>Utilizador</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for='room in props.rooms' :key='room.id'>
      <td>{{ room.id }}</td>
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
