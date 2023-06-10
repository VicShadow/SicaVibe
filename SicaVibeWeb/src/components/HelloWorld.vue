
<template>
    <h1 class="green">{{ msg }}</h1>
    <h3>
      A = {{ a }}
    </h3>

    <button @click="a = 'bd'">change A</button>
</template>


<script setup lang="ts">
import { ref } from 'vue'

defineProps({
  msg: String
})

const a = ref("asdasda")


</script>




<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}
</style>
