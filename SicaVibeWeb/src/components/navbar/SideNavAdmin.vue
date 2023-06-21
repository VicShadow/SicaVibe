<script lang="ts" setup>
import type { Props as SideNavItemProps } from '@/components/navbar/SideNavItem.vue'
import SideNavItem from '@/components/navbar/SideNavItem.vue'
import { ref } from 'vue'
import SicaVibeAvatar from '@/components/SicaVibeAvatar.vue'
import { useRouter } from 'vue-router'

const items = ref<SideNavItemProps[]>([
  { title: 'Reservations', icon: '', value: '/admin/reservations' },
  { title: 'Employees', icon: '', value: '/admin/employees' },
  { title: 'Rooms', icon: '', value: '/admin/rooms' },
  // { title: 'Promoções', icon: '', value: '/admin/promotions' }
])

const router = useRouter()

const isSelected = (value: string) => {
  const currentRoute = router.currentRoute.value.path
  return value === currentRoute
}

isSelected('/admin/reservations')
</script>

<template>
  <v-navigation-drawer class="position-sticky px-2">
    <SicaVibeAvatar />
    <v-list v-for="item in items" :key="item.title" density="compact">
      <SideNavItem
        :icon="item.icon"
        :selected="isSelected(item.value)"
        :title="item.title"
        :value="item.value"
        @click.prevent=""
      />
    </v-list>
  </v-navigation-drawer>
</template>

<style scoped></style>
