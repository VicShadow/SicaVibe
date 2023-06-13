<script setup lang='ts'>
import TopNav from '../components/TopNav.vue'
import SideNav from '../components/SideNav.vue'

interface Props {
}

defineProps<Props>()
</script>

<template>
  <v-app class='h-100'>
    <top-nav />
    <div class='h-100 d-flex justify-lg-start container'>
      <side-nav />
      <main class='h-100 w-100'>
        <slot />
      </main>
    </div>
  </v-app>

</template>

<style scoped>
.container {
  gap: 2%;
}

main {
  padding-right: 2%;
}
</style>
