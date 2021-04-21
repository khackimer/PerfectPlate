<template>
  <div id="container">
    <div id="row">
      <button id="rejectBtn" type="submit" @click.prevent="addReject">
          <div id="thumb">👎</div>REJECT
      </button>
      <div class="card">
        <h1 id="name">{{ restaurant.name }}</h1>
        <div id="imageGroup">
          <img id="image" v-if="restaurant.image_url != ''" 
              :src="`${restaurant.image_url}`" />
          <img id="image" v-else src="../assets/logo.png" />    
          <div id="yelpPrice">
            <a id="link" href="https://www.yelp.com/" target="_blank">
              <img id="yelpLogo" src="@/assets/yelpLogo.png"/>
            </a>
            <p id="price">Price: {{ restaurant.price }}</p>
          </div>
        </div>    
        <div id="midRow">  
          <p id="contacts">
            {{ restaurant.location.display_address[0] }} <br>
            {{ restaurant.location.display_address[1] }} <br> 
            {{ restaurant.display_phone }} 
          </p>
          <a id="reviews" :href="`${restaurant.url}`" target="_blank">
            Reviews: {{ restaurant.review_count }} <br>
            Check Out Our Reviews!
          </a>
        </div>  
        <img id="stars" :src="getStars" />
      </div>  
      <button id="likeBtn" type="submit" @click.prevent="addFavorite">
        <div id="thumb">👍</div>LIKE
      </button>
    </div>
  </div>
</template>

<script>
import yelpService from '../services/YelpService.js';

export default {
  name: "business-card",
  data() {
    return {
      restaurant: '',
    };
  },
  methods: {
    addFavorite() {
      yelpService
      .addFavorites(this.$store.state.restaurants[0].id)
      .then((response) => {
        if(response.status === 201) {
          this.$store.commit("REMOVE_RESTAURANT");
          if(this.$store.state.restaurants[0] == null) {
            this.$router.push({
                path: "/question",
                query: { matches: "empty" }, 
              });
          } else {
            this.restaurant = this.$store.state.restaurants[0];
          }
        }
      });
    },
    addReject() {
      this.$store.commit("ADD_REJECTS", this.restaurant);
      this.$store.commit("REMOVE_RESTAURANT");
      if(this.$store.state.restaurants[0] == null) {
        this.$router.push({
                path: "/question",
                query: { matches: "empty" }, 
              });
      } else {
        this.restaurant = this.$store.state.restaurants[0];
      }    
    }
  },
  created() {
    this.restaurant = this.$store.state.restaurants[0];
    if(this.restaurant == null) {
      this.$router.push({
                path: "/question",
                query: { matches: "none" }, 
              });
    }
  },
  computed: {
    getStars() {
      const rating = this.restaurant.rating;
      if (rating == 0.0) {
        return require("@/assets/extra_large_0.png");
      } else if (rating == 1.0) {
        return require("@/assets/extra_large_1.png");
      } else if (rating == 1.5) {
        return require("@/assets/extra_large_1_half.png");
      } else if (rating == 2.0) {
        return require("@/assets/extra_large_2.png");
      } else if (rating == 2.5) {
        return require("@/assets/extra_large_2_half.png");
      } else if (rating == 3.0) {
        return require("@/assets/extra_large_3.png");
      } else if (rating == 3.5) {
        return require("@/assets/extra_large_3_half.png");
      } else if (rating == 4.0) {
        return require("@/assets/extra_large_4.png");
      } else if (rating == 4.5) {
        return require("@/assets/extra_large_4_half.png");
      } else {
        return require("@/assets/extra_large_5.png");
      }
    }
  }
};
</script>
<style scoped>
#container {
  display: flex;
  background-image: url(../assets/businesscardimg.jpg);
  background-size: cover;
  height: 100vh;
  overflow: auto;
}
#row {
  display: flex;
  margin: auto;
}
.card {
  display: flex;
  flex-flow: column;
  align-items: center;
  padding: 20px;
  background-color: #111718a9;
  border: 3px solid #990000;
  border-radius: 25px;
  max-width: 800px;
  margin: auto;
  align-self: center;
}
#name {
  display: flex;
  border-radius: 10px;
  background-color: #fcf9f9;
  justify-content: center;
  text-align: center;
  align-self: center;
  padding: 10px;
  margin: auto;
  border: 4px solid black; 
  color: #c41200;
}
#imageGroup {
  display: flex;
  flex-flow: column;
  padding-top: 10px;
  margin: auto;
}
#image {
  display: flex;
  border: 3px solid #990000;
  border-radius: 80%;
  margin: auto;
  width: 300px;
  height: 300px;
}
#yelpPrice {
  display: flex;
  flex-flow: row-reverse;
}
#yelpLogo {
  display: flex;
  width: 150px;
}
#price {
  display: flex;
  font-size: 22pt;
  font-weight: bold;
  color: green;
  justify-content: center;
  text-align: center;
  align-self: center;
  padding: 10px;
  margin: auto;
}
#info {
  display: flex;
  flex-flow: column;
  text-decoration: none;
  color: black;
  font-size: 15pt;
}
#reviews {
  text-decoration: navajowhite;
  color:black;
  cursor: pointer;
}
#midRow {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
#contacts {
  display: flex;
  background-color: white;
  border-radius: 8px;
  font-size: 15pt;
  font-weight: bold;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: fit-content; 
  width: 200px;
  margin: 5px;
  border: 4px solid black; 
}
#reviews {
  display: flex;
  background-color: white;
  border-radius: 8px;
  font-size: 15pt;
  font-weight: bold;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: fit-content;
  width: 200px;
  margin: 5px;
  border: 4px solid black; 
  
}
#stars {
  display: flex;
  max-width: 500px;
  margin-top: 10px;
  justify-content: center;
}
#likeBtn,
#rejectBtn {
  display: flex;
  flex-flow: column;
  width: 160px;
  height: 300px;
  font-size: 25pt;
  justify-content: center;
  align-items: center;
  margin: auto;
  font-weight: bold;
  border-radius: 10px;
  outline: none;
} 
#thumb {
  font-size: 50pt;
}
#btnRow {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
#likeBtn{
  color: #FFF;
  background: #44CC44;
  padding: 15px 20px;
  box-shadow: 0 4px 0 0 #2EA62E;
}
#likeBtn:hover {
  background: #6FE76F;
  box-shadow: 0 4px 0 0 #7ED37E;
}
#rejectBtn{
  color: #FFF;
  background: tomato;
  padding: 15px 20px;
  box-shadow: 0 4px 0 0 #CB4949;
}
#rejectBtn:hover {
  background: rgb(255, 147, 128);
  box-shadow: 0 4px 0 0 #EF8282;
}
@media screen and (max-width: 800px){
#row {
  display: flex;
  flex-wrap: wrap;
}
.card {
  order: -1;
  display: flex;
  flex-flow: column;
  align-items: center;
  padding: 5px;
  background-color: #111718a9;
  border: 3px solid #990000;
  border-radius: 25px;
  max-width: 800px;
  margin: auto;
  align-self: center;
}
#name {
  display: flex;
  flex-wrap: wrap;
  font-size: 18pt;
  border-radius: 20px;
  background-color: #fcf9f9;
  justify-content: center;
  text-align: center;
  align-self: center;
  margin: auto;
  border: 4px solid black; 
  color: #c41200;
}
#imageGroup {
  display: flex;
  flex-flow: column;
  padding-top: 10px;
  margin: auto;
}
#image {
  display: flex;
  border: 3px solid #990000;
  border-radius: 80%;
  margin: auto;
  width: 250px;
  height: 250px;
}
#yelpPrice {
  display: flex;
  flex-flow: row-reverse;
}
#yelpLogo {
  display: flex;
  width: 150px;
}
#price {
  display: flex;
  font-size: 22pt;
  font-weight: bold;
  color: green;
  justify-content: center;
  text-align: center;
  align-self: center;
  padding: 10px;
  margin: auto;
}
#info {
  display: flex;
  flex-flow: column;
  text-decoration: none;
  color: black;
  font-size: 15pt;
}
#reviews {
  text-decoration: navajowhite;
  color:black;
  cursor: pointer;
}
#midRow {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
#contacts {
  display: flex;
  background-color: white;
  border-radius: 8px;
  font-size: 15pt;
  font-weight: bold;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: fit-content; 
  width: 200px;
  margin: 5px;
  border: 4px solid black; 
}
#reviews {
  display: flex;
  background-color: white;
  border-radius: 8px;
  font-size: 15pt;
  font-weight: bold;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: fit-content;
  width: 200px;
  margin: 5px;
  border: 4px solid black; 
}
#stars {
  display: flex;
  max-width: 500px;
  margin-top: 10px;
  justify-content: center;
}
#likeBtn {
  order: -1;
  flex-basis: 100%;
  display: flex;
  height: 80px;
  font-size: 16pt;
  font-weight: bold;
  border-radius: 10px;
  outline: none;
} 
#rejectBtn{
  flex-basis: 100%;
  display: flex;
  height: 80px;
  font-size: 16pt;
  font-weight: bold;
  border-radius: 10px;
  outline: none;
} 
#thumb {
  font-size: 25pt;
}
#likeBtn {
  color: #FFF;
  background: #44CC44;
  padding: 15px 20px;
  box-shadow: 0 4px 0 0 #2EA62E;
}
#likeBtn:hover {
  background: #6FE76F;
  box-shadow: 0 4px 0 0 #7ED37E;
}
#rejectBtn{
  color: #FFF;
  background: tomato;
  padding: 15px 20px;
  box-shadow: 0 4px 0 0 #CB4949;
}
#rejectBtn:hover {
  background: rgb(255, 147, 128);
  box-shadow: 0 4px 0 0 #EF8282;
}
}
</style>