<script lang="ts" setup>
import type { Employee } from '@/services/backend/admin/getEmployees'
import { toRefs } from 'vue'

interface Props {
    users: Employee[]
}

const props = defineProps<Props>()

const { users } = toRefs(props)
</script>

<template>
    <v-table>
        <thead>
        <tr>
            <th class="text-left px-0">ID</th>
            <th class="text-left">Hotel Name</th>
            <th class="text-left">Name</th>
            <th class="text-left">Email</th>
            <th class="text-left">Phone Number</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="user in users" :key="user.id">
            <td class="px-0">{{ user.id }}</td>
            <td>{{ user.hotelName }}</td>
            <td>{{ user.nome }}</td>
            <td>{{ user.email }}</td>
            <td>{{ user.numTelemovel }}</td>
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