<script lang="ts" setup>
import TopNav from '@/components/navbar/TopNav.vue'
import SideNavReceptionist from '@/components/navbar/SideNavReceptionist.vue'
</script>

<template>
  <v-app class="h-100">
    <top-nav />
    <div class="h-100 d-flex justify-lg-start container">
      <side-nav-receptionist />
      <main class="h-100 w-100 d-flex flex-column pa-10">
        <RouterView />
      </main>
    </div>
  </v-app>
</template>

<style scoped></style>
