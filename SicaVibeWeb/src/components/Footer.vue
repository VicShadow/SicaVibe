<template>
    <v-footer class="footer" color="#d9d9d9">
      <v-container class="container">
        <v-row no-gutters v-for="(item, i) in items">
            <h3 class="text"> {{ item.name }}</h3>
            <v-col class="cols" cols="12" v-for="tag in item.tags">
                <a target="_blank" v-bind:href="tag.url" class="links">{{ tag.urlname }}</a>
            </v-col>
        </v-row>
      </v-container>    
    </v-footer>
</template>

<script lang="ts" setup> 
  import items from "../Items";
</script>


<style scoped>

    .footer{
      position: absolute;
      bottom: 0;
      width: 100%;
      height: 13.5rem;
    }

    .container{
      display: flex;
      align-items: flex-start;
    }

    .cols{
      text-align: start;
      margin-top: 3%;
    }

    .text{
      color: black;
      font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
      font-weight: bolder;
    }

    .links{
      color: #5C677D;
    }

</style>