<script lang='ts' setup>
</script>

<template>
  <div class='navbar'>
    <div class='left'>
      <div class='circle'></div>
      <span class='header-text'>SicaVibe</span>
    </div>
    <div class='right'>
      <router-link to='/login'>
        <v-btn class='bt1' density='comfortable' rounded='xl' variant='outlined'> Login</v-btn>
      </router-link>
      <router-link to='/signup'>
        <v-btn class='bt2' density='comfortable' rounded='xl'> Sign up</v-btn>
      </router-link>
    </div>
  </div>
</template>

<style scoped>
.navbar {
  position: fixed;
  background: transparent;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  padding: 1rem;
  width: 100%;
}

.left {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  gap: 1rem;
}

.header-text {
  font-weight: bold;
  font-size: 2rem;
  color: #023e7d;
}

.circle {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #023e7d;
  margin-left: 10px;
  margin-right: -7px;
}

.bt1 {
  background-color: white;
  color: #023e7d;
  margin-right: 10px;
}

.bt2 {
  background-color: #023e7d;
  color: white;
}
</style>
