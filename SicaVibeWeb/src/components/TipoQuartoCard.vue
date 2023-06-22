<template>
  <v-card
    class='vcard flex'
    color='black'
    variant='tonal'
    rounded='lg'>

    <v-img class='hotelImage'
           aspect-ratio='4/3'
           width='300'
           :cover='true'
           :src='imageUrl'>
    </v-img>

    <div class='card'>
      <v-card-title> {{ tipoQuarto.nome }}</v-card-title>
      <v-card-text>
        <div>{{ tipoQuarto.descricao }}</div>

        <div class='marginTop'>
          <span class='boldText'>Capacity: </span>
          {{ tipoQuarto.capacidade }} people
        </div>

        <div class='marginTop'>
          <span class='boldText'>Price per Night: </span>
          {{ tipoQuarto.preco }}€
        </div>
      </v-card-text>
    </div>

  </v-card>
</template>


<script lang='ts' setup>
import type { TipoQuarto } from '@/types/Hotel'


interface Props {
  tipoQuarto: TipoQuarto
}

const props = defineProps<Props>()

const imageUrl = import.meta.env.VITE_BACKEND_URL + '/imagem/' + props.tipoQuarto.imgID

</script>


<style scoped>
.card {
  border-radius: 15px;
}

.marginTop {
  margin-top: 10px;
}

.boldText {
  color: #023E7D;
  font-weight: bold;
  font-size: 17px;
}

.hotelImage {
  border-radius: 15px;
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

</style>
