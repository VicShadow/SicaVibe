<template>
  <v-card @click="clickedCard"
    class="vcard"
    color="black" variant="tonal">
  
    <v-img class="hotelImage"
      aspect-ratio="4/3"
      height="150"
      cover
      :src="imageUrl">
    </v-img>

    <div class="card">
      <v-card-title> {{ nameSplit }} </v-card-title>
      <v-card-text> {{  desc }} </v-card-text>
    </div>

  </v-card>
</template>




<script lang="ts" setup>
import router from '@/router';


interface Props {
  hotelid: number,
  hotelName: string,
  hotelDescription: string,
  imageID: number
}

const props = defineProps<Props>();

const nameSplit = props.hotelName.split(" ")[1]
const imageUrl = import.meta.env.VITE_BACKEND_URL + "/imagem/" + props.imageID
const desc = limit(props.hotelDescription, 200)

function limit (string = '', limit = 0) {  
  return string.substring(0, limit) + "..."
}

function clickedCard () {
  router.push({ name:'hotel', params:{ id:props.hotelid }})
}

</script>





<style scoped>
.card {
  border-radius: 15px;
}

.container {
  padding-top: 20px;
  padding-left: 5px;
  padding-right: 5px;
  margin-top: 100px;
  
}

.vcard:hover {
  box-shadow: 0px 10px 20px grey;
}

 
.hotelImage {
  border-radius: 15px 15px 0 0;
}

</style>