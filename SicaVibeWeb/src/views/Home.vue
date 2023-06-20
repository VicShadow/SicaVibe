<template>
  <v-app class="padding">
    <NavBar />
    
    <section>
      <span class="title">Our Hotels</span>
      <div class="flex">
        <HotelCard class="card" v-for="hotel in hoteis" :key="hotel.id" :hotelid="hotel.id" :hotel-name="hotel.nome" :hotel-description="hotel.descricao" :image-i-d="hotel.imgID"/>
      </div>
    </section>

    
  </v-app>
</template>



<script lang="ts" setup>
import { ref } from 'vue'
import NavBar from '@/components/navbar/NavBar.vue'
import HotelCard from '@/components/HotelCards.vue'
import type {Hotel} from '@/types/Hotel'
import { getHoteis } from '@/services/backend/hoteis/getHoteis'

let hoteis = ref<Hotel[]>([])

fetchHoteis()

function fetchHoteis () {
  getHoteis().then(res => hoteis.value = res)
}

</script>


<style scoped>

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

.padding {
  padding: 30px;
}

.title {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 30px;
}
</style>