<template>
    <v-app>
      <NavBar/>

      <!-- Hotel Intro -->
      <section class="paddingTotal">
        <div class="flex">
          <div>
            <div class="title"> {{ hotel?.nome.split(" ")[1] }}</div>
            <span class="normalText"> {{  hotel?.descricao }}</span>

            <template v-if="hotel?.servicoExtraSet">
              <div class="amenities">Main Amenities</div>

              <div class="flex">
                <span v-for="servico in hotel.servicoExtraSet" :key="servico.id">
                  - {{ servico.nome }}
                </span>
              </div>
            </template>
          </div>

          <v-img
            class="image"
            cover
            :src="imageUrl"
          ></v-img>
        </div>
      </section>


      <!-- RESERVATION BUTTON -->
      <div class="btn paddingHorizontal">
        <v-btn @click='bookReservationOnClick' rounded="lg" color="#CD519D">BOOK A RESERVATION</v-btn>
      </div>


      <!-- HOTEL ROOMS -->
      <div class="paddingHorizontal titleRooms"> {{ hotel?.nome.split(" ")[1] }} Rooms</div>

      <div class="paddingHorizontal">
        <TipoQuartoCard class="mt-10"
        v-for="tipo in hotel?.tipoDeQuartoSet"
        :key="tipo.id"
        :tipo-quarto="tipo"/>
      </div>


      </v-app>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import NavBar from '@/components/navbar/NavBar.vue'
import { useRouter } from 'vue-router'
import type {Hotel} from '@/types/Hotel'
import { getHotel } from '@/services/backend/hoteis/getHotel'
import TipoQuartoCard from '@/components/TipoQuartoCard.vue'


const router = useRouter()

const hotelid = Number(router.currentRoute.value.params.id)

let hotel = ref<Hotel>()

fetchHotel()

let imageUrl = ""

function fetchHotel () {
  getHotel(hotelid).then(res => {
    hotel.value = res
    imageUrl = import.meta.env.VITE_BACKEND_URL + "/imagem/" + hotel.value?.imgID
  })
}

const bookReservationOnClick = () => {
  router.push('/guest/make-reservation/' + hotelid)
}
</script>

<style scoped>

.paddingHorizontal {
  padding-left: 30px;
  padding-right: 30px;
}

.paddingTotal {
  padding: 30px;
}

section{
  margin-top: 80px;
  background-color: #F1F1F1;
}

.flex {
  display: flex;
  gap: 30px;
  justify-content: space-between;
}

@media (max-width: 800px) {
  .flex {
    flex-direction: column;
  }
}

.card {
  flex:1;
  max-width: 300px;
}

.title {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 50px;
}

.titleRooms {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 40px;
}

.image {
  border-radius: 15px;
  width: 500px;
}

.normalText {
  font-weight: 400;
  font-size: 15px;
}

.amenities {
  color: #388BFF;
  font-style: normal;
  font-weight: 500;
  font-size: 23px;
  margin-top: 20px;
}

.btn {
  display: flex;
  justify-content: end;
  color: white;
  margin-top: 20px;
}
</style>

