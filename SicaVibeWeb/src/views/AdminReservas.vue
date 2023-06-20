<template>
    <div>
        <span class="title">Reservations</span>
        
        <div class="marginTop">
            <span>Filter: </span>
            <TextField @update:value="filterByHotel"
                v-model:value="hotelid" label="Hotel ID" max-width="100px" type="number">a</TextField>
        </div>

        <!-- <ReservationTable class="marginTop" :reservations="reservas" /> -->
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import TextField from '@/components/TextField.vue'
import ReservationTable from '@/components/tables/ReservationTable.vue'
import type { Reservation } from '@/types/Reservation'
import { getReservations } from '@/services/backend/reservations/adminGetReservations'
import { getToken } from '@/services/storage/sessionStorage'
import type { Token } from '@/types/Token'
import type { GetReservationsAdmin } from '@/services/backend/reservations/adminGetReservations'


const currentPage = ref<number>(1)
const pagesize = ref<number>(10)
const hotelid = ref<string>("")
const token : Token|null = getToken()

if (!token) {
  throw new Error('No token found')
}

const headersSimple = {
    token: token,
    page: currentPage.value,
    pagesize: pagesize.value,
}
const headersFilter = {
    token: token,
    page: currentPage.value,
    pagesize: pagesize.value,
    hotelid: Number(hotelid.value)
}


let reservas = ref<GetReservationsAdmin>([])
getReservations(headersSimple).then(res => {
    reservas.value = res
 })


function filterByHotel () {
    if (hotelid.value === "") getReservations(headersSimple).then(res => reservas.value = res)
    else {
        headersFilter.hotelid = Number(hotelid.value)
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

.flex {
  display: flex;
  gap: 10px;
}

.marginTop {
    margin-top: 20px;
}
</style>