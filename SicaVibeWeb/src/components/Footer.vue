<template>
  <footer class='footer'>
    <v-container class='container'>
      <v-row :key='item.name' no-gutters v-for='item in items'>
        <h3 class='text'> {{ item.name }}</h3>
        <v-col :key='tag.urlname' class='cols' cols='12' v-for='tag in item.tags'>
          <a target='_blank' v-bind:href='tag.url' class='links'>{{ tag.urlname }}</a>
        </v-col>
      </v-row>
    </v-container>
  </footer>
</template>

<script lang='ts' setup>
import items from '../Items'
</script>


<style scoped>

.footer {
  width: 100%;
  background: #d9d9d9;
}

.container {
  display: flex;
  align-items: flex-start;
}

.cols {
  text-align: start;
  margin-top: 3%;
}

.text {
  color: black;
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  font-weight: bolder;
}

.links {
  color: #5C677D;
}

@media (max-width: 900px){

}

</style>
