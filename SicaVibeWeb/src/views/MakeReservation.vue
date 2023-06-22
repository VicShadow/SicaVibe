<script setup lang='ts'>
import Steps from '@/components/Steps.vue'
import { computed, ref } from 'vue'
import { useRouter } from 'vue-router'
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

const router = useRouter()
const currentStep = ref(0)
const showSuccess = ref(false)

const hotelId = ref(1) // TODO: HARDCODED HOTEL ID

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
  /*
  .min(new Date(new Date().getDate() + 1), 'Start date must be in the future')
  .max(new Date(new Date().getDate() + 30), 'Start date must be within 30 days')
  .required('Start date is required')
   */
)


const {
  value: endDate,
  errorMessage: endDateErrorMessage
} = useField<string>(() => 'endDate',
  yup.string()
  /*
  .min(startDate.value + 1, 'Start date must be after start date')
  .max(new Date(new Date().getDate() + 30), 'Start date must be within 30 days')
  .required('End date is required')
   */
)

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
      hotelId: hotelId.value
    })

    const fetchedRoomTypes = await getRoomTypes({
      hotelId: hotelId.value
    })

    console.log('available rooms', fetchedAvailableRooms)
    console.log('room types', fetchedRoomTypes)


    availableRooms.value = joinRoomTypes(fetchedRoomTypes, fetchedAvailableRooms)

    console.log('available rooms', availableRooms.value)
  } catch (e) {
    console.log(e)
  }
}

const fetchServices = async (): Promise<void> => {
  const fetchedServices = await getExtraServices({
    hotelId: hotelId.value
  })

  console.log('services', fetchedServices)

  services.value = fetchedServices
}

const makeReservation = async (): Promise<void> => {
  // TODO: Make reservation
}

const nights = computed(() => {
  if (startDate.value && endDate.value) {
    const start = new Date(startDate.value)
    const end = new Date(endDate.value)
    const diff = Math.abs(end.getTime() - start.getTime())
    return Math.ceil(diff / (1000 * 60 * 60 * 24))
  }
  return 0
})


const advanceStep = () => {
  if (currentStep.value === 0) {
    fetchAvailableRooms()
  } else if (currentStep.value === 1) {
    if (Object.entries(selectedRooms.value).length === 0) {
      return
    }
    fetchServices()
  } else if (currentStep.value === 3) {
    makeReservation()
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
  currentStep.value = -1
  showSuccess.value = true

  setTimeout(async () => {
    await router.push('/')
  }, 2000)
}

const increaseRoomSelection = (roomId: number) => {
  if (selectedRooms.value[roomId]) {
    selectedRooms.value[roomId]++
  } else {
    selectedRooms.value[roomId] = 1
  }
}

const selectService = (serviceId: number) => {
  if (selectedServices.value.includes(serviceId)) {
    selectedServices.value = selectedServices.value.filter(id => id !== serviceId)
  } else {
    selectedServices.value.push(serviceId)
  }

  console.log('selected services', selectedServices.value)
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
          <TextField class='date-input' type='date' v-model:value='startDate' :error='startDateErrorMessage' />
        </div>
        <div class='end-date'>
          <span class='text-md-h6 font-weight-bold'>End Date</span>
          <TextField class='date-input' type='date' v-model:value='endDate' :error='startDateErrorMessage' />
        </div>
        <div class='nights'>
          <span class='text-md-h6 font-weight-bold'>Nights</span>
          <span class='date-input'> {{ nights }} </span>
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
          :img-i-d='roomType.imgID' @click='increaseRoomSelection(roomType.id)' :number-of-rooms-selected='selectedRooms[roomType.id] || 0' />
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
        <Invoice :nights='nights' :selectedRooms='selectedRooms' :services='services' :selected-services='selectedServices'  :rooms='availableRooms || []' />
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
.rooms {
  width: 100%;
  height: 100%;
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
  max-height: 600px;
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
