<template>
  <div id="app">
    <nav-bar />
    <router-view />
  </div>
</template>

<script>
import NavBar from '@/views/NavBar.vue'

export default {
  components: {
    NavBar
  }
}

</script>

<style>
#app {
  overflow: auto;
}
::-webkit-scrollbar{
  display: none;
}
*{
  margin:0;
  padding:0;
}

</style>

