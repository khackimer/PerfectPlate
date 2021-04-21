<template>
  <div v-if="this.$store.state.token != ''">
    <div id="nav" v-if="displayBar">
      <div id="spacerOne">&nbsp;</div>
      <div class="center">
        <router-link class="center" id="search" 
          v-if="notSearch" :to="{ name: 'home' }">New Search</router-link>
        <div class="center" id="pipe" v-if="displayPipe">|</div>
        <router-link class="center" id ="favorites" 
          v-if="notFavs" :to="{ name: 'favorites' }">My Favorites</router-link>
      </div> 
      <div id="spacerTwo">&nbsp;</div>
      <router-link id="logOut" :to="{ name: 'logout' }">Logout</router-link>
    </div> 
  </div>
</template>

<script>
export default {
  computed: {
    notSearch() {
      return this.$route.name != 'home';
    },
    notFavs() {
      return this.$route.name != 'favorites';
    },
    displayPipe() {
      return this.$route.name != 'home' && this.$route.name != 'favorites';
    },
    displayBar() {
      return !this.$route.query.matches;
    }
  }
}
</script>

<style scoped>
#nav {
  display: flex;
  background-color:  #111718a9;
  align-items: space-around;
  justify-content: center;
  height: 70px;
  border: 3px solid #990000;
}
.center{
  color: black;
  text-decoration: none;
  display: flex;
  align-items: center;
}
#search,
#favorites {
  display: flex;
  justify-content: center;
  align-self: center;
  color: black;
  font-size: 20pt;
  font-weight: 600;
  text-decoration: none;
  margin-right: 2px;
  padding: 5px;
  background: white;
  border-radius: 10px;
  border: 3px solid #990000;
}
#logOut {
  display: flex;
  justify-content: center;
  align-self: center;
  color: black;
  font-size: 20pt;
  font-weight: 600;
  text-decoration: none;
  margin-right: 2px;
  padding: 5px;
  background: white;
  border-radius: 10px;
  border: 3px solid #990000;
}
#logOut:hover,
#favorites:hover,
#search:hover {
  background: rgb(167, 82, 67); 
} 
#spacerOne {
  display: flex;
  flex-grow: 1.25;
}
#spacerTwo {
  display: flex;
  flex-grow: 1;
}
#pipe {
  font-size: 35pt;
}
/* ::-webkit-scrollbar{
  display: none;
} */

@media screen and (max-width: 460px){
#nav {
  display: flex;
  background-color:  #111718a9;
  align-items: center;
  justify-content: center;
  height: 45px;
  border: 3px solid #990000;
}
.center{
  color: black;
  text-decoration: none;
  display: flex;
  align-items: center;
}
#search,
#favorites {
  display: flex;
  justify-self: center;
  align-self: center;
  color: black;
  font-size: 10pt;
  font-weight: 600;
  text-decoration: none;
  margin-right: 2px;
  padding: 5px;
  background: white;
  border-radius: 10px;
  border: 3px solid #990000;
}
#logOut {
  display: flex;
  justify-content: center;
  align-self: center;
  color: black;
  font-size: 10pt;
  font-weight: 600;
  text-decoration: none;
  margin-right: 2px;
  padding: 5px;
  background: white;
  border-radius: 10px;
  border: 3px solid #990000;
}
#logOut:hover,
#favorites:hover,
#search:hover {
  background: rgb(167, 82, 67); 
} 
#spacerOne {
  visibility: hidden;
}
#spacerTwo {
  visibility: hidden;
}
#pipe {
  visibility: hidden;
}
}
</style>