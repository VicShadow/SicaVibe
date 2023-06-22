<template>
  <section class='section-1'>
    <NavBar transparent />
    <h1 class='text-h4' id='texth3'>Your perfect stay,</h1>
    <h1 class='text-h4' id='texth31'>every time</h1>
    <img src='/torreBelem.jpg' alt='img' class='image-fit' />
  </section>
  <section class='group-padding'>
    <section class='card-group'>
      <span class='title1'>Our Hotels</span>
      <div class='flex'>
        <HotelCard class='card' v-for='hotel in hoteis' :key='hotel.id' :hotelid='hotel.id' :hotel-name='hotel.nome'
                   :hotel-description='hotel.descricao' :image-i-d='hotel.imgID' />
      </div>
    </section>
    <section class='about-us'>
      <span>About Us</span>
      <div class='text'>
        <div class='item'>
          <p class='aboutus'>
            Welcome to our chain of hotels, where we redefine <strong>hospitality</strong> and <strong>luxury</strong>
            with every stay! So why settle for an ordinary hotel experience when you can indulge in the extraordinary
            with us? <br>
            From the moment you step into our beautifully-appointed lobbies, you'll be greeted by <strong>warm
            smiles</strong> and <strong>attentive service</strong>. Our staff is dedicated to ensuring that your stay
            with us is nothing short of perfect, and we take great pride in providing our guests with <strong>the
            highest level of comfort and luxury</strong>. <br><br>
            But what really sets us apart is our commitment to <strong>sustainability </strong> and <strong>responsible
            tourism</strong>. We're dedicated to reducing our environmental footprint and giving back to the
            communities in which we operate, so you can rest easy knowing that your stay with us is also benefiting
            the planet and its people. <br>
            So whether you're planning a romantic getaway, a family vacation, or a business trip, we invite you to
            experience the luxury and hospitality of our chain of hotels. We can't wait to welcome you to our family!
            <br>
          </p>
        </div>
        <div class='item'>
          <img src='/hotel1.jpg' alt='img' class='image1' />
          <img src='/Hotel.jpg' alt='img' class='image2' />
        </div>
      </div>
    </section>
  </section>
  <Footer />
</template>


<script lang='ts' setup>

import { ref } from 'vue'
import NavBar from '@/components/navbar/NavBar.vue'
import HotelCard from '@/components/HotelCards.vue'
import Footer from '@/components/Footer.vue'
import type { Hotel } from '@/types/Hotel'
import { getHoteis } from '@/services/backend/hoteis/getHoteis'

let hoteis = ref<Hotel[]>([])

fetchHoteis()

function fetchHoteis() {
  getHoteis().then(res => hoteis.value = res)
}

</script>


<style scoped>

.section-1 {
  position: relative;
}

.image-fit {
  width: 100%;
  object-fit: cover;
  box-shadow: inset 700px 200px 250px 5px rgba(255, 255, 255, 0.2);
}

.text-h4 {
  font-weight: bolder;
  z-index: 1;
  color: #023E7D;
}

#texth3 {
  position: absolute;
  top: 23%;
  left: 15%;
}

#texth31 {
  position: absolute;
  top: 30%;
  left: 19%;
}

.group-padding {
  padding: 2rem 4rem;
}

.card-group {
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

span {
  color: #023E7D;
  font-style: normal;
  font-weight: 500;
  font-size: 30px;
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
  flex: 1;
  max-width: 300px;
}

.text {
  display: flex;
}

.item {
  position: relative;
  flex: 50%;
  display: flex;
}

.about-us {
  padding: 4rem 0;
  display: flex;
  flex-direction: column;
  gap: 2rem;
}

.aboutus {
  color: #5C677D;
  text-align: left;
}

.image1 {
  width: 282px;
  height: 264px;
  border-radius: 100%;
  left: 9.5%;
  top: -0.5%;

  position: absolute;
}

.image2 {
  display: none;
  width: 390px;
  height: 375px;
  border-radius: 100%;
  position: absolute;
  left: 37%;
  top: 10%;
  max-width: 300px;
  max-height: 200px;
  aspect-ratio: 1;
}

</style>
