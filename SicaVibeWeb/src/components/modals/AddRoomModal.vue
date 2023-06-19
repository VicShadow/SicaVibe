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
  setTimeout(() => (loading.value = false), 1000)
  // TODO: Implement add room action
}
</script>

<template>
  <v-dialog v-model="isModalOpen" max-width="800px">
    <div class="pa-6 card bg-white rounded-sm">
      <v-card-title class="pa-0">
        <span class="text-h5">Add New Room</span>
      </v-card-title>
      <div class="fields">
        <span class="text-subtitle-1">Room Details</span>
        <TextField class="w-100" label="Room Description" />
      </div>
      <v-card-actions class="pa-0 w-100 d-flex justify-end">
        <v-btn
          class="cancel-btn"
          :ripple="false"
          variant="text"
          @click="$emit('update:isModalOpen', false)"
        >
          Cancel
        </v-btn>
        <v-btn :loading="loading" :ripple="false" class="add-btn" @click="addRoomHandler">
          Add Room
        </v-btn>
      </v-card-actions>
    </div>
  </v-dialog>
</template>

<style scoped>
.card {
  display: flex;
  flex-direction: column;
  align-items: start;
  justify-content: start;
  gap: 1.5rem;
}

.fields {
  display: flex;
  flex-direction: column;
  align-items: start;
  justify-content: start;
  gap: 1rem;
  width: 100%;
}

.cancel-btn {
  text-transform: capitalize;
}

.add-btn {
  color: white;
  background: #0c66e4;
  text-transform: capitalize;
}
</style>
