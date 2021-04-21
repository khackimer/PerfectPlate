<template>
  <div id="container">
    <div class="card">
      <h1 id="head" v-if="this.$route.query.matches=='empty'">You have no more matches!<br><br> 
        What would you like to do?</h1>
      <h1 id="head" v-if="this.$route.query.matches=='none'">There were no matches for your criteria.<br><br>  
        What would you like to do?</h1>  
      <div id="buttons">
        <button id="favs" type="submit" @click.prevent="viewFavorites">
          View Favorites
        </button>
        <button id="search" type="submit" @click.prevent="goHome">
          Start New Search
        </button>
        <button id="logOut" type="submit" @click.prevent="logOut">
          Log Out
        </button>
      </div>  
    </div>
  </div>
</template>
<script>
export default {
  name: "business-card",
  data() {
    return {
      restaurant: ""
    }
  },
  methods: {
    viewFavorites(){
      this.$router.push("/favorites");
    },
    goHome() {
      this.$router.push("/");
    },
    logOut(){
      this.$router.push("/logout");
    }
  }
}    
</script>

<style scoped>
#container {
  background-image: url(../assets/questionpageimg.jpg);
  background-size: cover;
  display: flex;
  height: 100vh;
  flex-flow: column;
  align-items: center;
}
.card {
  display: flex;
  flex-flow: column;
  padding: 20px;
  background-color: #111718a9;
  border: 3px solid #990000;
  border-radius: 25px;
  max-width: 450px;
  margin-top: 100px;
  overflow: hidden;
}
#head {
  align-self: center;
  text-align: center;
  color: white;
}
#favs, #search, #logOut {
  width: 200px;
  height: 50px;
  font-size: 15pt;
  padding: 0.7rem;
  border-radius: 10px;
  border: 3px solid #990000;
  background-color: #999999;
  margin-top: 10px;
  outline: none;
  font-weight: bold;
}
#buttons {
  display:flex;
  flex-direction: column;
  align-items: center;
}
#favs:hover{
   background: #990000;
}
#search:hover{
   background: #990000;
}
#logOut:hover{
   background: #990000;
}
</style>