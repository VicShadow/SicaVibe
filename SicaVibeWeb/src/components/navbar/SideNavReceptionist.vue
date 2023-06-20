<script lang="ts" setup>
import type { Props as SideNavItemProps } from '@/components/navbar/SideNavItem.vue'
import SideNavItem from '@/components/navbar/SideNavItem.vue'
import { ref } from 'vue'
import HotelAvatar from '@/components/HotelAvatar.vue'
import { useRouter } from 'vue-router'

const items = ref<SideNavItemProps[]>([
  { title: 'Reservas', icon: '', value: '/receptionist/reservations' },
  { title: 'Quartos', icon: '', value: '/receptionist/rooms' },
  { title: 'Promoções', icon: '', value: '/receptionist/promotions' }
])

const router = useRouter()

const currentRoute = router.currentRoute.value.path

const isSelected = (value: string) => {
  return value === currentRoute
}
</script>

<template>
  <v-navigation-drawer class="position-sticky px-2">
    <HotelAvatar img="https://picsum.photos/200/300" />
    <v-list v-for="item in items" :key="item.title" density="compact">
      <SideNavItem
        :icon="item.icon"
        :selected="isSelected(item.value)"
        :title="item.title"
        :value="item.value"
      />
    </v-list>
  </v-navigation-drawer>
</template>

<style scoped></style>
