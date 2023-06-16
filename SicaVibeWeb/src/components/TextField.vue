<script lang="ts" setup>
import { defineProps, toRefs } from 'vue'

interface Props {
  type?: string
  label?: string
  maxWidth?: string
}

const props = defineProps<Props>()

const { type, label } = toRefs(props)

const maxWidth = props.maxWidth ?? 'unset'
</script>

<template>
  <input :placeholder="label" :type="type ?? 'text'" />
</template>

<style scoped>
input {
  border: 2px solid rgba(9, 30, 66, 0.141176);
  background: #ffffff;
  border-radius: 3px;
  padding: 6px 8px;
  box-sizing: border-box;
  max-width: v-bind(maxWidth);
}

input:focus-visible,
input:focus {
  outline: none;
  box-shadow: none;
}

input:hover {
  background: #f7f8f9;
}
</style>
