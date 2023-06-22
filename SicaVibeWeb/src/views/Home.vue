<template>
  <section class='section-1'>
    <NavBar transparent />
    <h1 class='text-h4' id='texth3'>Your perfect stay,</h1>
    <h1 class='text-h4' id='texth31'>every time</h1>
    <img src='/torreBelem1.jpg' alt='img' class='image-fit' />
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
        <div class='item' id='item2'>
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
  width: 278px;
  height: 260px;
  border-radius: 100%;
  position: absolute;
  left: 9.5%;
  top: -20%;
}

.image2 {
  width: 380px;
  height: 355px;
  border-radius: 100%;
  position: absolute;
  left: 37%;
  top: -10%;
}

@media (max-width: 1300px) {

  .image1{
    width: 268px;
    height: 250px;
    left: 9.5%;
    top: -10%;
  }

  .image2{
    width: 350px;
    height: 325px;
    left: 37.5%;
    top: 10%;
  }
  
}

@media (max-width: 1200px) {

  .image1{
    width: 230px;
    height: 218px;
    left: 9.5%;
  }

  .image2{
    width: 310px;
    height: 295px;
    left: 35%;
    top: 20%;
  }

}

@media (max-width: 980px) {

  .image1{
    display: none;
  }

  #item2{
    position: unset;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
  }

  .image2{
    position: unset;
  }

}

@media(max-width:820px) {
  
  .text-h4{
    display: none;
  }

  .card {
    flex: 50%;
  }

  .text{
    flex-direction: column;
  }

  #item2{
    padding-top: 2rem;
  }
  
}

@media (max-width: 500px) {

  .flex {
    flex-direction: column;
  }
}
</style>
