<template>
  <h1>Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("")
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  },
};
</script>
<style scoped>
/* ::-webkit-scrollbar{
  display: none;
} */
</style>