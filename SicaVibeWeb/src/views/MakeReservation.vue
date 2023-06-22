<script setup lang='ts'>
import Steps from '@/components/Steps.vue'
import { computed, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import Check from '@/assets/icons/Check.vue'
import { useField } from 'vee-validate'
import * as yup from 'yup'
import TextField from '@/components/TextField.vue'
import { AvailableRooms, getAvailableRooms } from '@/services/backend/rooms/getAvailableRooms'
import { getToken } from '@/services/storage/sessionStorage'
import type { Token } from '@/types/Token'
import { getRoomTypes, RoomTypes } from '@/services/backend/rooms/getRoomTypes'
import { getExtraServices } from '@/services/backend/reservations/getExtraServices'
import ServiceCard from '@/components/ServiceCard.vue'
import RoomCardSelector from '@/components/RoomCardSelector.vue'
import type { RoomTypeAvailable } from '@/types/Hotel'
import Invoice from '@/components/Invoice.vue'
import { formatDateBackendFromStr } from '@/services/formatter'
import { makeReservation as makeReservationBackend } from '@/services/backend/reservations/makeReservation'

const router = useRouter()
const currentStep = ref(0)
const showSuccess = ref(false)

const route = useRoute()

const hotelId  = route.params.hotelId as number

const token = getToken() as Token

if (!token) {
  router.push('/login')
}


/*                                          Input variables                                          */
const {
  value: startDate,
  errorMessage: startDateErrorMessage
} = useField<string>(() => 'startDate',
  yup.string()
    .required('Start date is required')
)


const {
  value: endDate,
  errorMessage: endDateErrorMessage
} = useField<string>(() => 'endDate',
  yup.string()
    .required('End date is required')
)

const nights = computed(() => {
  if (startDate.value && endDate.value) {
    const start = new Date(startDate.value)
    const end = new Date(endDate.value)
    const diff = end.getTime() - start.getTime()
    return Math.ceil(diff / (1000 * 60 * 60 * 24))
  }
  return 0
})

const errorNights = computed(() => {
  if (startDate.value && endDate.value && nights.value < 1) {
    return 'End date must be after start date'
  }
  return ''
})

const availableRooms = ref<RoomTypeAvailable[]>()

const services = ref([])

const selectedRooms = ref({})

const selectedServices = ref([])


const joinRoomTypes = (roomTypes: RoomTypes, availableRooms: AvailableRooms): RoomTypeAvailable[] => {
  return roomTypes.map(roomType => {
    const roomsAvailable = availableRooms[roomType.id]
    return {
      ...roomType,
      roomsAvailable
    }
  })
}

const fetchAvailableRooms = async (): Promise<void> => {
  try {
    const fetchedAvailableRooms = await getAvailableRooms({
      token,
      inDate: '23/06/2023',//formatDateBackendFromStr(startDate.value),
      outDate: '28/06/2023',//formatDateBackendFromStr(endDate.value),
      hotelId: hotelId
    })

    const fetchedRoomTypes = await getRoomTypes({
      hotelId: hotelId
    })
    availableRooms.value = joinRoomTypes(fetchedRoomTypes, fetchedAvailableRooms)

  } catch (e) {
    console.log(e)
  }
}

const fetchServices = async (): Promise<void> => {
  services.value = await getExtraServices({
    hotelId: hotelId
  })
}

const makeReservation = async (): Promise<boolean> => {
  try {
    await makeReservationBackend({
      token,
      hotelId: hotelId,
      inDate: formatDateBackendFromStr(startDate.value),
      outDate: formatDateBackendFromStr(endDate.value),
      rooms: selectedRooms.value,
      services: selectedServices.value
    })

    return true
  } catch (e) {
    console.log(e)
  }
  return false
}

const advanceStep = () => {
  if (currentStep.value === 0) {
    if (!startDate.value || !endDate.value || nights.value < 1) {
      return
    }
    fetchAvailableRooms()
  } else if (currentStep.value === 1) {
    if (Object.entries(selectedRooms.value).length === 0) {
      return
    }
    fetchServices()
  }
  currentStep.value++
}

const showSteps = computed(() => {
  return !showSuccess.value && currentStep.value >= 0 && currentStep.value <= 3
})

const cancelOnClick = async () => {
  await router.push('/')
}

const submitOnClick = async () => {
  const success = await makeReservation()
  if (!success) {
    return
  }

  currentStep.value = -1
  showSuccess.value = true

  setTimeout(async () => {
    await router.push('/hostprofile')
  }, 2000)
}

const increaseRoomSelection = (roomId: number) => {
  if (selectedRooms.value[roomId]) {
    selectedRooms.value[roomId]++
  } else {
    selectedRooms.value[roomId] = 1
  }
}

const decreaseRoomSelection = (roomId: number) => {
  if (selectedRooms.value[roomId] === 1) {
    selectedRooms.value = Object.fromEntries(Object.entries(selectedRooms.value).filter(([key, _]) => key !== roomId.toString()))
  } else {
    selectedRooms.value[roomId]--
  }
}

const selectService = (serviceId: number) => {
  if (selectedServices.value.includes(serviceId)) {
    selectedServices.value = selectedServices.value.filter(id => id !== serviceId)
  } else {
    selectedServices.value.push(serviceId)
  }
}
</script>

<template>
  <div class='container'>
    <Steps v-if='showSteps' :num='5' :current='currentStep + 1' />
    <div v-if='currentStep === 0' class='step'>
      <h1 class='title'>Choose a date</h1>
      <div class='date-form'>
        <div class='start-date'>
          <span class='text-md-h6 font-weight-bold'>Start Date</span>
          <TextField class='date-input' type='date' v-model:value='startDate' />
          <span class='error-message'>{{ startDateErrorMessage }}</span>
        </div>
        <div class='end-date'>
          <span class='text-md-h6 font-weight-bold'>End Date</span>
          <TextField class='date-input' type='date' v-model:value='endDate' :error='endDateErrorMessage' />
          <span class='error-message'>{{ endDateErrorMessage }}</span>
        </div>
        <div class='nights'>
          <span class='text-md-h6 font-weight-bold'>Nights</span>
          <span class='date-input'> {{ nights }} </span>
          <span class='error-message'>{{ errorNights }}</span>
        </div>
      </div>
    </div>

    <div v-if='currentStep === 1' class='step'>
      <h1 class='title'>Choose the available Rooms</h1>
      <div v-if='availableRooms' class='rooms'>
        <RoomCardSelector
          v-for='roomType in availableRooms' :key='roomType.id' :id='roomType.id' :room-name='roomType.nome'
          :capacity='roomType.capacidade'
          :price='roomType.preco' :available='roomType.roomsAvailable' :description='roomType.descricao'
          :img-i-d='roomType.imgID' @increaseRoomSelection='(roomId) => increaseRoomSelection(roomId)'
          @decreaseRoomSelection='(roomId) => decreaseRoomSelection(roomId)'
          :number-of-rooms-selected='selectedRooms[roomType.id] || 0' />
      </div>
    </div>

    <div v-if='currentStep === 2' class='step'>
      <h1 class='title'>Choose the desired Services</h1>
      <div class='services'>
        <ServiceCard v-for='service in services' :key='service.id' :id='service.id' :name='service.nome'
                     :price='service.preco' @click='selectService(service.id)'
                     :is-selected='selectedServices.includes(service.id)' />
      </div>

    </div>
    <div v-if='currentStep === 3' class='step'>
      <h1 class='title'>Confirm the invoice</h1>
      <div class='invoice'>
        <Invoice :nights='nights' :selectedRooms='selectedRooms' :services='services'
                 :selected-services='selectedServices' :rooms='availableRooms || []' />
      </div>

    </div>
    <div v-if='showSuccess' class='success-step'>
      <Check size='60px' />
      <h1 class='title'>Reservation was made successfully!</h1>

    </div>
    <div class='actions'>
      <v-btn v-if='currentStep == 0' @click='cancelOnClick' class='btn' :ripple='false' :elevation='0'>Cancel</v-btn>
      <v-btn v-if='currentStep > 0' @click='currentStep--' class='btn' :ripple='false' :elevation='0'>Previous</v-btn>
      <v-btn v-if='currentStep < 3 && !showSuccess' @click='advanceStep' class='btn' :ripple='false' :elevation='0'>
        Next
      </v-btn>
      <v-btn v-if='currentStep === 3 ' @click='submitOnClick' class='btn' :ripple='false' :elevation='0'>
        Submit
      </v-btn>
    </div>
  </div>
</template>

<style scoped>
.invoice {
  width: 100%;
}


.error-message {
  color: red;
  font-size: 0.9rem;
}

.rooms {
  width: 100%;
  height: 100%;
  max-height: 300px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  gap: 2rem;
  overflow: auto;
}

.services {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  gap: 2rem;
}

.start-date, .end-date, .nights {
  width: 100%;
  max-width: 150px;
}

.date-input {
  width: 100%;
  background: #ececec;
  border-width: 0;
  border-radius: 10px;
  padding: 1rem;
}

.date-form {
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  gap: 2rem;
}

.nights {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
}

.title {
  color: #023E7D;
}

.btn {
  border: 1px solid #d9d9d9;
  text-transform: capitalize;
}

.container {
  padding: 4%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: space-between;
  gap: 2rem;
  max-height: 800px;
  max-width: 1000px;
  background: #f3f3f3;
  margin: 0 auto;
}

.actions {
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}

.step {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: flex-start;
  gap: 1.5rem;
}

.success-step {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 2rem;
  height: 100%;
  width: 100%;
}
</style>
