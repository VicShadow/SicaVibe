<template>
    <v-card class="reservation" color="white" >
     
        <v-col cols="10">
            <v-row class="top">
                <v-col>{{  reservation.inDate.toISOString().split("T")[0]  }}</v-col>
                <v-col><v-img class="image-fill" contain src="../arrow.jpg"></v-img></v-col>
                <v-col>{{  reservation.outDate.toISOString().split("T")[0] }}</v-col>
                <v-col><v-btn  :class="getButtonClass(reservation.status)">{{reservation.status}}</v-btn></v-col>
            </v-row>
            <v-row>
                <v-col class="text"> Rooms 
                    <template v-for="room in reservation.rooms">
                        <div>{{ room.typeName }}</div>
                    </template></v-col>
                <v-col class="text"> Services 
                    <template v-for="service in reservation.services">
                        <div>{{ service.name }}</div>
                    </template></v-col>
            </v-row>
            <v-row class="d-flex align-center">
                <v-col class="total-text">
                  Total: <span class="price-text">{{ reservation.price }}€</span>
                </v-col>
                <v-col class="d-flex justify-center pa-10">
                  <v-spacer></v-spacer>
                  <v-btn class="buttonCancel" 
                          :disabled="reservation.status != 'Scheduled'"
                          :ripple="false"
                          @click="openCancelReservationModal">Cancel</v-btn>
                </v-col>
            </v-row>
        </v-col>
     
    </v-card>
    <CancelModal
    v-model:is-open="isCancelReservationModalOpen"
    :is-open="isCancelReservationModalOpen"
    message="Are you sure you want to cancel this reservation?"
    title="Cancel Reservation"
    @cancel="isCancelReservationModalOpen = false"
    @confirm="CancelReservationHandler"
    :error-message-cancel-reservation="errorMessageCancelReservation"
    />
    <transition name="fade">
      <div v-if="errorMessageCancelReservation !== ''" class="confirmation-overlay">
        <div class="confirmation-message">
            {{ errorMessageCancelReservation }}
        </div>
      </div>
    </transition>
</template>
  


<script lang="ts" setup>
import { ref } from 'vue'
import CancelModal from '@/components/modals/DeleteModal.vue'
import { toRefs } from 'vue'
import type { Reservation } from '@/types/Reservation'
import { differenceInHours, isAfter } from 'date-fns';
import { getToken } from '@/services/storage/sessionStorage'
import { cancelReservation } from '@/services/backend/reservations/hospedeCancelReservation';

interface Props {
  reservation: Reservation,
}

const emit = defineEmits(['canceled'])

const tokenUser = localStorage.getItem("token")

const isCancelReservationModalOpen = ref(false)

const errorMessageCancelReservation= ref('')
errorMessageCancelReservation.value = ''


const openCancelReservationModal = () => {
  const currentDate = new Date();
  const reservationDate = new Date(reservation.value.inDate);
  const timeDifferenceInHours = differenceInHours(reservationDate, currentDate);

  if (timeDifferenceInHours > 24 && isAfter(reservationDate,currentDate)) {    
    isCancelReservationModalOpen.value = true;
  } else {
    errorMessageCancelReservation.value = 'It is not possible to cancel a reservation with less than 24 hours.'
    setTimeout(() => {
      errorMessageCancelReservation.value = '';
    }, 4000);
  }
}

const CancelReservationHandler = () => {
  errorMessageCancelReservation.value = ""

  cancelReservation({token: tokenUser ?? "", reservaid: reservation.value.id}).then( (res) => {
    if (res) {
      emit('canceled')
      isCancelReservationModalOpen.value = false
    }
    else errorMessageCancelReservation.value = "Error canceling Reservation, please try again later"
  })
}

const props = defineProps<Props>()

const { reservation } = toRefs(props)

const getButtonClass = (status) => {
  switch (status) {
    case 'On going':
      return 'buttonOngoing';
    case 'Cancelled':
      return 'buttonCancelled';
    case 'Scheduled':
      return 'buttonScheduled';
    case 'Done':
      return 'buttonDone';
    default:
      return '';
  }
}
</script>

<style scoped>

.top{
  margin-top: 2rem;
}
.reservation{
  background-color: #f1f2f4;
  padding: 2rem;
  border-radius: 0.5em;

  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 2rem;
  margin-bottom: 20px;
}

.confirmation-message {
  background-color: white;
  padding: 20px;
  border-radius: 8px;
}
.confirmation-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
}
.image-fill {
  max-height: 30px;
  max-width: 30px;
}

.total-text {
  font-weight: bold;
  color: #0d47a1;
  font-size: 20px;
}
.price-text {
  font-weight: bold;
  color: black;
  padding-left: 0.3rem;
}

.text {
  font-weight: bold;
  color: black;
}
.buttonCancel {
  color: black;
  background-color: #CFD8DC;
}

.buttonOngoing {
  color: white;
  background-color: rgb(105, 218, 105);
  border-radius: 20px;
}

.buttonCancelled {
  color: white;
  background-color: red;
  border-radius: 20px;
}

.buttonScheduled {
  color: white;
  background-color: #5cc2ee;
  border-radius: 20px;
}

.buttonDone{
  color: black;
  background-color: white;
  border-radius: 20px;
}
</style>

