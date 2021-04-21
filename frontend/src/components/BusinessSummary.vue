<template>
  <div class= "fav">
    <div id="card" class="business-summary" :restaurant='restaurant'>
      <a id="link" :href="`${restaurant.url}`" target="_blank">  
        <h1 id="name">{{ restaurant.name }}</h1>
        <div id="contact">
          <h2>{{ restaurant.location.display_address[0] }} <br>
            {{ restaurant.location.display_address[1] }}</h2>
          <h2>{{ restaurant.display_phone }}</h2>
        </div>  
      </a>
      <div id="bottomRow">
        <img id="stars" :src="getStars" /> 
        <button id="removeBtn" v-on:click.prevent="submit">Remove from list</button>
      </div>   
    </div> 
  </div>
</template>

<script>
import yelpService from "@/services/YelpService.js"

export default {
    name: "business-summary",
    props: {
      restaurant: {
        id: String,
        name: String,
        location: Array,
        display_phone: String,
        rating: Number
      }
    },
    methods: {
      submit() {
        yelpService.deleteFavorites(this.restaurant.id);
        location.reload();
      }
    },
    computed: {
      getStars() {
        const rating = this.restaurant.rating;
        if (rating == 0.0) {
          return require("@/assets/small_0.png");
        } else if (rating == 1.0) {
          return require("@/assets/small_1.png");
        } else if (rating == 1.5) {
          return require("@/assets/small_1_half.png");
        } else if (rating == 2.0) {
          return require("@/assets/small_2.png");
        } else if (rating == 2.5) {
          return require("@/assets/small_2_half.png");
        } else if (rating == 3.0) {
          return require("@/assets/small_3.png");
        } else if (rating == 3.5) {
          return require("@/assets/small_3_half.png");
        } else if (rating == 4.0) {
          return require("@/assets/small_4.png");
        } else if (rating == 4.5) {
          return require("@/assets/small_4_half.png");
        } else {
          return require("@/assets/small_5.png");
        }
    }
  }
}
</script>

<style>
#card{
  display: flex;
  flex-flow: column;
  justify-content: flex-end;
  background-color: rgb(226, 226, 226);
  border:20px solid #990000; 
  padding: 5px;
  border-radius:10px;
  min-width: 320px;
  height: 220px;
  margin-bottom: 10px;
}
#name {
  display: flex;
  flex-wrap: wrap;
  color: #990000;
}
 #contact{ 
  display: flex; 
  flex-flow: column; 
} 
#link {
  text-decoration: none;
  color: black;
  cursor: pointer;
}
#bottomRow {
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
}
#stars {
  padding-right: 30px;
}
#removeBtn{
  color: #FFF;
  background: #990000;
  width: 150px;
  height: 60px; 
  font-size: 18pt;
  font-weight: bold;
  border-radius: 10px;
  outline:none;
}
#removeBtn:hover {
  background: rgb(255, 147, 128);  
}




</style>

