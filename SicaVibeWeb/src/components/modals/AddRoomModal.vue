<script lang="ts" setup>
import { ref, toRefs } from 'vue'
import TextField from '@/components/TextField.vue'

interface Props {
  isModalOpen: boolean
}

const props = defineProps<Props>()

defineEmits(['update:isModalOpen'])

const { isModalOpen } = toRefs(props)

const loading = ref(false)

const addRoomHandler = () => {
  loading.value = true
  console.log('addRoomHandler')
  setTimeout(() => (loading.value = false), 1000)
  // TODO: Implement add room action
}
</script>

<template>
  <v-dialog v-model="isModalOpen" max-width="1000px">
    <v-card class="pa-2">
      <v-card-title>
        <span class="text-h5">Add New Room</span>
      </v-card-title>
      <div>
        <TextField label="Room Description" />
      </div>
      <v-card-actions class="d-flex justify-lg-end">
        <v-btn
          :ripple="false"
          color="primary"
          variant="outlined"
          @click="$emit('update:isModalOpen', false)"
          >Close Dialog
        </v-btn>
        <v-btn :loading="loading" :ripple="false" color="primary" @click="addRoomHandler"
          >Add Room
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<style scoped></style>
