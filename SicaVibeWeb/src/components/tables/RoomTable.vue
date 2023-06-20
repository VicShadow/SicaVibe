<script lang="ts" setup>
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
        <th class="text-left px-0">Id</th>
        <th class="text-left">TypeId</th>
        <th class="text-left">TypeName</th>
        <th class="text-left">DoorNumber</th>
        <th class="text-left">Status</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="room in rooms" :key="room.id">
        <td class="px-0">{{ room.id }}</td>
        <td>{{ room.typeId }}</td>
        <td>{{ room.typeName }}</td>
        <td>{{ room.doorNumber }}</td>
        <td class="status">{{ room.status }}</td>
        <!-- TODO: Add color for each type of status as in the design -->
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
