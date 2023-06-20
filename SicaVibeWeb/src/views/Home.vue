<template>
    <v-app id="page">
      <div class="group1">
        <NavBar/>
        <h1 class="text-h4" id="texth3" >Your perfect stay,</h1>
        <h1 class="text-h4" id="texth31">every time</h1>
        <!--<img src = "/torreBelem.jpg" alt="img" class="image-fit" />-->
      </div>
      <div class="content">
        <h1 class="text-h4" id="texth4">Our Hotels</h1>
        <img src = "/hotel1.jpg" alt="img" class="image1" />
        <div class="container">
          
        </div>
        <h1 class="text-h4" id="texth41">About Us</h1>

        <img src = "/Hotel.jpg" alt="img" class="image2" />
      </div>
      <Footer></Footer>
    </v-app>
</template>

<script lang="ts" setup>
  import NavBar from '@/components/NavBar.vue'
  import Footer from '@/components/Footer.vue'
  import type HotelCards from '@/components/HotelCards.vue';
</script>

<style scoped>
  #page{
    position: relative;
    min-height: 100vh;
  }

  #content{
    padding-bottom: 13.5rem;
  }

  #Footer{
    bottom: 0;
  }

  .group1{
    position: relative;
    height: 70vh;
  }

  .image-fit{
    position: absolute;
    width: 100%;
    height: 100%;
    object-fit: cover;
    box-shadow: inset 700px 200px 250px 5px rgba(255, 255, 255, 0.2);
    border-radius: 0px 0px 20px 20px;
  }

  #texth3{
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-weight: bolder;
    z-index: 1;
    position: absolute;
    top:40%;
    left: 11%;
    color: #023E7D;
  }

  #texth31{
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-weight: bolder;
    z-index: 1;
    position: absolute;
    top:47%;
    left: 15%;
    color: #023E7D;
  }

  #texth4{
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-weight: bolder; 
    color: #023E7D;
    position: absolute;
    top:70%;
    left: 10%;
    position: absolute;
  }

  
  #texth41{
    font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
    font-weight: bolder; 
    color: #023E7D;
    position: absolute;
    top:80%;
    left: 10%;
    position: absolute;
  }


  .image1{
    position: absolute;
    width: 300px;
    height: 286px;
    left: 50%;
    top: 1092px;
    border-radius: 197.5px;
  }

  .image2{
    position: absolute;
    width: 414px;
    height: 414px;
    left: 63%;
    top: 1200px;
    border-radius: 211.5px;
  }

</style>
  
