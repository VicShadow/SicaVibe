<template>
  <div>
    <span class='title'>Reservations</span>

    <div class='marginTop'>
      <span>Filter: </span>
      <input
        placeholder='Hotel ID'
        type="number"
        @input.prevent='event => filterByHotel(event.target.value)'
      />

    </div>

    <div v-for='[key, value] in reservas' :key='key' class='container'>
      <div class='tableTitle'>{{ key }}</div>
      <ReservationTable :reservations='value' :is-admin='true' />

    </div>
  </div>
</template>

<script setup lang='ts'>
import { ref } from 'vue'
import ReservationTable from '@/components/tables/ReservationTable.vue'
import type { Reservation } from '@/types/Reservation'
import { getToken } from '@/services/storage/sessionStorage'
import type { Token } from '@/types/Token'
import { getReservations } from '@/services/backend/reservations/adminGetReservations'


const currentPage = ref<number>(1)
const pagesize = ref<number>(10)
const token: Token | null = getToken() // TODO: Migrate to use the useUserStore() hook

if (!token) {
  throw new Error('No token found')
}

const headersSimple = {
  token: token,
  page: currentPage.value,
  pagesize: pagesize.value
}
const headersFilter = {
  token: token,
  page: currentPage.value,
  pagesize: pagesize.value,
  hotelid: 0
}


let reservas = ref<Map<string, Reservation[]>>()
getReservations(headersSimple).then(res => reservas.value = res)


function filterByHotel(id: number) {
  if (!id) getReservations(headersSimple).then(res => reservas.value = res)
  else {
    headersFilter.hotelid = id
    getReservations(headersFilter).then(res => reservas.value = res)
  }
}

</script>

<style scoped>
.title {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 30px;
}

.tableTitle {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 20px;
}

.container {
  margin-top: 20px;
}

.flex {
  display: flex;
  gap: 10px;
}

.marginTop {
  margin-top: 20px;
}

input {
  border: 2px solid rgba(9, 30, 66, 0.141176);
  background: #ffffff;
  border-radius: 3px;
  padding: 6px 8px;
  box-sizing: border-box;
}

input:focus-visible,
input:focus {
  outline: none;
  box-shadow: none;
}

input:hover {
  background: #f7f8f9;
}
</style>
