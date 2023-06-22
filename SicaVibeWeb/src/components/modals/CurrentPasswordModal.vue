<script lang="ts" setup>
import { toRefs } from 'vue'
import TextField from '@/components/TextField.vue'

interface Props {
  title: string
  input?: string
  type?: string 
  options?: {
    width?: string
    color?: string
    zIndex?: number
    noconfirm?: boolean
  }
  isOpen: boolean
  errorMessageCurrentPassword: string
}

const props = defineProps<Props>()

const { title, options, isOpen, errorMessageCurrentPassword } = toRefs(props)

const emit = defineEmits(['confirm', 'cancel'])

const confirm = () => {
  emit('confirm')
}
const cancel = () => {
  emit('cancel')
}

const showCancel = () => {
  return !options?.value?.noconfirm
}
</script>

<template>
  <v-dialog v-model="isOpen" max-width="400px" @keydown.esc="cancel">
    <v-card>
      <!--suppress HtmlUnknownBooleanAttribute -->
      <v-toolbar dark dense flat>
        <v-toolbar-title class="text-body-2 font-weight-bold grey--text text-md-h6">
          {{ title }}
        </v-toolbar-title>
      </v-toolbar>
      <TextField v-if="input" :type="type ?? 'text'" id="currentPassword"></TextField>
      <div v-if="errorMessageCurrentPassword" class="error-message">{{ errorMessageCurrentPassword }}</div>
      <v-card-actions class="pt-3">
        <v-spacer></v-spacer>
        <v-btn
          v-if="showCancel"
          class="body-2 font-weight-bold text-capitalize"
          color="grey"
          @click="cancel"
        >
          Cancel
        </v-btn>
        <v-btn class="body-2 font-weight-bold text-capitalize bg-blue-darken-2" @click="confirm"
          >OK
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<style scoped>
.error-message {
  color: red;
}
</style>
