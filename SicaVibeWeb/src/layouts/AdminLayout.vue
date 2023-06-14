<script lang="ts" setup>
import TopNav from '../components/TopNav.vue'
import SideNav from '../components/SideNav.vue'

interface Props {}

defineProps<Props>()
</script>

<template>
  <v-app class="h-100">
    <top-nav />
    <div class="h-100 d-flex justify-lg-start container">
      <side-nav />
      <main class="h-100 w-100 d-flex flex-column py-2">
        <router-view />
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
  gap: 1rem;
}
</style>
