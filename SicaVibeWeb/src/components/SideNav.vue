<script setup lang='ts'>
import type { Props as SideNavItemProps } from '@/components/SideNavItem.vue'
import SideNavItem from '@/components/SideNavItem.vue'
import { ref } from 'vue'

const items = ref<SideNavItemProps[]>([
  { title: 'Reservas', icon: '', value: '/reservas' },
  { title: 'Funcionários', icon: '', value: '/funcionarios' },
  { title: 'Quartos', icon: '', value: '/admin/rooms' },
  { title: 'Promoções', icon: '', value: '/promocoes' }
])


</script>

<template>
  <v-navigation-drawer class='position-sticky px-2'>
    <v-list density='compact' v-for='item in items' :key='item.title'>
      <side-nav-item :title='item.title' :icon='item.icon' :value='item.value' />
    </v-list>
  </v-navigation-drawer>
</template>

<style scoped>
</style>
