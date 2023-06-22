<script setup lang='ts'>

import { toRefs } from 'vue'

interface StepsProps {
  num: number
  current: number
}

const props = defineProps<StepsProps>()

const { current } = toRefs(props)
</script>

<template>
  <div class='steps'>
    <span class='step' :class='{ active: 1 <= current }'>1</span>
    <span class='separator' :class='{ active: 2 <= current }'></span>
    <span class='step' :class='{ active: 2 <= current }'>2</span>
    <span class='separator' :class='{ active: 3 <= current }'></span>
    <span class='step' :class='{ active: 3 <= current }'>3</span>
    <span class='separator' :class='{ active: 4 <= current }'></span>
    <span class='step' :class='{ active: 4 <= current }'>4</span>
  </div>
</template>

<style scoped>
.steps {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  height: 100%;
  max-height: 60px;
  gap: 2%;
}

.step {
  width: 100%;
  max-width: 60px;
//padding: 0.6% 2%; aspect-ratio: 1;
  border-radius: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  color: #989898;
  background-color: #d9d9d9;
  font-size: large;
}

.separator {
  width: 100%;
  min-height: 5px;
  height: 1%;
  border-radius: 10px;
  background: #d9d9d9;
}

.active {
  background-color: #79b979;
  color: #619461;
}
</style>
