<script lang="ts" setup>
import type { Props as SideNavItemProps } from '@/components/SideNavItem.vue'
import SideNavItem from '@/components/SideNavItem.vue'
import { ref } from 'vue'
import HotelAvatar from '@/components/HotelAvatar.vue'

const items = ref<SideNavItemProps[]>([
  { title: 'Reservas', icon: '', value: '/admin/reservations' },
  { title: 'Funcionários', icon: '', value: '/admin/employees' },
  { title: 'Quartos', icon: '', value: '/admin/rooms' },
  { title: 'Promoções', icon: '', value: '/admin/promotions' }
])
</script>

<template>
  <v-navigation-drawer class="position-sticky px-2">
    <HotelAvatar img="https://picsum.photos/200/300" />
    <v-list v-for="item in items" :key="item.title" density="compact">
      <side-nav-item :icon="item.icon" :title="item.title" :value="item.value" />
    </v-list>
  </v-navigation-drawer>
</template>

<style scoped></style>
