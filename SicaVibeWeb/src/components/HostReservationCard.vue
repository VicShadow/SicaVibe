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
            </v-row>
            <v-row>
                <v-col class="text"> Rooms </v-col>
                <v-col class="text"> Extras </v-col>
            </v-row>
            <v-row class="d-flex align-center">
                <v-col class="text-center total-text">
                    Total: 
                    <span class="price-text">{{ reservation.price }}€</span>
                </v-col>
                <v-col class="d-flex justify-center pa-10">
                    <div class="button-container">
                        <v-spacer></v-spacer>
                        <v-btn class="buttonCancel">Cancel</v-btn>
                        <v-btn class="buttonExtend">Extend</v-btn>
                    </div>
                </v-col>
            </v-row>
        </v-col>
      </v-row>
    </v-card>
  </template>
  


<script lang="ts" setup>

const reservation = {
    "id" : "1",
    "guestId" : "2",
    "guestName" : "Filipa",
    "inDate" : "10/10/2001",
    "outDate" : "11/10/2001",
    "price" : "100",
    "status" : "",
    "quartos" : []
}

</script>



<style scoped>

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
</style>