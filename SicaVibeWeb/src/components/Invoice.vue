<script setup lang='ts'>

import type { ExtraService } from '@/services/backend/reservations/getExtraServices'
import type { RoomTypeAvailable } from '@/types/Hotel'
import { computed, toRefs } from 'vue'

interface SelectedRooms {
  [key: number]: number // room id: number of rooms
}

type SelectedServices = number[]

export interface InvoiceProps {
  nights: number
  rooms: RoomTypeAvailable[]
  services: ExtraService[]
  selectedRooms: SelectedRooms
  selectedServices: SelectedServices
}

const props = defineProps<InvoiceProps>()

const { nights, rooms, services, selectedRooms, selectedServices } = toRefs(props)

const roomsTotal = computed(() => {
  let total = 0
  for (const room of rooms.value) {
    total += room.preco * (selectedRooms.value[room.id] || 0) * nights.value
  }
  return total
})

const servicesTotal = computed(() => {
  let total = 0
  for (const serviceId of selectedServices.value) {
    const service = services.value.find(service => service.id === serviceId)
    if (service) {
      total += service.preco
    }
  }
  return total
})

const total = computed(() => {
  return roomsTotal.value + servicesTotal.value
})
</script>

<template>
  <div class='invoice'>
    <h2 class='invoice__header'>Invoice</h2>
    <div class='invoice__body'>
      <div class='invoice__body__rooms'>
        <h3 class='invoice__body__rooms__title'>Rooms</h3>
        <div class='room-line'>
          <div class='rooms'>
            <div class='room' v-for='[roomId, numberOfRooms] in Object.entries(selectedRooms)' :key='roomId'>
              <span>{{ rooms.find(room => room.id === Number(roomId))?.nome }}</span>
              <span>{{ rooms.find(room => room.id === Number(roomId))?.preco }} €</span>
              <span>x{{ numberOfRooms }}</span>
              <span> {{ nights }} nights</span>
            </div>
          </div>
          <span class='rooms-total'>
              {{ roomsTotal }} €
            </span>
        </div>
      </div>
      <div class='invoice__body__services'>
        <h3 class='invoice__body__services__title'>Services</h3>
        <div class='service-line'>
          <div class='services'>
            <div class='service' v-for='service in selectedServices' :key='services.find(s => s.id === service)?.id'>
              <span>{{ services.find(s => s.id === service)?.nome }}</span>
              <span>{{ services.find(s => s.id === service)?.preco }} €</span>
            </div>
          </div>
          <span class='services-total'>
          {{ servicesTotal }} €
        </span>
        </div>
      </div>
    </div>
    <div class='invoice__footer'>
      <h3 class='total'>Total</h3>
      <span class='total-value'>{{ total }} €</span>
    </div>
  </div>
</template>

<style scoped>
.room-line, .service-line {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.rooms-total, .services-total {
  min-width: 80px;
  font-weight: bolder;
  font-size: 1.5rem;
}


.total-value {
  min-width: 80px;
  font-weight: bolder;
  font-size: 1.5rem;
}

.room {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 0.5rem;
  background-color: #f5f5f5;
  padding: 0.5rem 1rem;
  gap: 1rem;
}

.service {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 0.5rem;
  background-color: #f5f5f5;
  padding: 0.5rem 1rem;
  gap: 1rem;
}


.invoice {
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  border-radius: 0.5rem;
  background-color: #f5f5f5;
  padding: 1rem;
}

.invoice__header {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  font-weight: bolder;
}

.invoice__body {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.invoice__body__rooms {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.invoice__body__rooms__title, .invoice__body__services__title, .total {
  font-weight: bold;
  padding: 0 0.5rem;
}

.rooms {
  width: 100%;
  display: flex;
  flex-direction: row;
  gap: 1rem;
}

.invoice__body__services {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.services {
  display: flex;
  flex-direction: row;
  gap: 1rem;
}


.invoice__footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

</style>
