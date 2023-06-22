<template>
    <v-card class="reservation" color="white">
      <v-row>
        <v-col cols="2">
          <v-img class="hotelImage"
            aspect-ratio="4/3"
            height="150"
            cover
            :src="imageUrl"
          ></v-img>
        </v-col>
        <v-col cols="10">
            <v-row>
                <v-col>{{  reservation.inDate  }}</v-col>
                <v-col><v-img class="image-fill" contain src="../arrow.jpg"></v-img></v-col>
                <v-col>{{  reservation.outDate }}</v-col>
                <v-col><v-btn :class="getButtonClass(reservation.status)">{{reservation.status}}</v-btn></v-col>
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
                <v-col class="text-center total-text">
                    Total: 
                    <span class="price-text">{{ reservation.price }}€</span>
                </v-col>
                <v-col class="d-flex justify-center pa-10">
                    <div class="button-container">
                        <v-spacer></v-spacer>
                        <v-btn class="buttonCancel" 
                                :ripple="false"
                                @click="openCancelReservationModal">Cancel</v-btn>
                        <v-btn class="buttonExtend">Extend</v-btn>
                    </div>
                </v-col>
            </v-row>
        </v-col>
      </v-row>
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

interface Props {
  reservation: Reservation,
}

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
    errorMessageCancelReservation.value = 'It is not possible to cancel a reservation with less than 24 hours notice.'
    setTimeout(() => {
      errorMessageCancelReservation.value = '';
    }, 4000);
  }
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

.reservation{
  width: 100%;
  background-color: #f1f2f4;
  padding: 2rem;
  border-radius: 0.5em;

  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 2rem;
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

.buttonExtend {
  color: white;
  background-color: #0d47a1;
}

.button-container {
  width: 100%;
  display: flex;
  flex-direction: center;
  justify-content: center;
  gap: 1rem;
}


.buttonOngoing {
  color: white;
  background-color: rgb(105, 218, 105);
}

.buttonCancelled {
  color: white;
  background-color: red;
}

.buttonScheduled {
  color: white;
  background-color: #5cc2ee;
}

.buttonDone{
  color: black;
  background-color: white;
}
</style>

