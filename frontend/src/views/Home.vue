<template>  
  <div id="apps">
    <form>
      <div id="headers">
        <img id="ppLogo" src="@/assets/ppLogo.png" />
        <div id="zipCode">
          <h1 id="zipHead">Enter your ZIP!</h1>
          <br>
          <input id="zipBox" v-model="business.zipCode"
            type="text" placeholder="5-Digit Zip Code"
            maxlength="5" minlength="5" pattern="[0-9]*"/>
        </div>  
      </div>
      <div id="travelRow">    
        <h2 id="travel">How far are you willing to travel for food?</h2>
        <div>&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <select id="radius" v-model="business.radius" >
          <option value=''>Any Distance</option>
          <option value='1610'>1 Mile</option>
          <option value='16100'>10 Miles</option>
          <option value='40000'>25 Miles</option>
        </select> 
      </div>
      <div id="grouping">
      <h1 id="mood">What are you in the mood for?</h1>
      <div id="category">
        <div>
          <input class="cat" value="pizza" name="pizza" v-model="business.category" type="radio"/>
          <label for="pizza">🍕 Pizza</label>
        </div>
        <div>
          <input class="cat" value="barbeque" name="barbeque" v-model="business.category" type="radio"/>
          <label for="barbeque">🍖 BBQ</label>
        </div>
        <div>
          <input class="cat" value="seafood" name="seafood" v-model="business.category" type="radio"/>
          <label for="seafood">🦀 Seafood</label>
        </div>
        <div>
          <input class="cat" value="fine-dining" v-model="business.category" type="radio"/>
          <label for="four">🥂 Fine Dining</label>
        </div>
        <div>
          <input class="cat" value="fast-food" name="fastfood" v-model="business.category" type="radio"/>
          <label for="fastfood">🍔 Fast Food</label>
        </div>
        <div>
          <input class="cat" value="steakhouse" v-model="business.category" type="radio"/>
          <label for="six">🥩 Steakhouse</label>
        </div>
        <div>
          <input class="cat" value="thai" name="thai" v-model="business.category" type="radio"/>
          <label for="thai">🍱 Thai</label>
        </div>
        <div>
          <input class="cat" value="chinese" name="chinese" v-model="business.category" type="radio"/>
          <label for="chinese">🍜 Chinese</label>
        </div>
        <div>
          <input class="cat" value="sushi" name="sushi" v-model="business.category" type="radio"/>
          <label for="sushi">🍣 Sushi</label>
        </div>
        <div>
          <input class="cat" value="indian" name="indian" v-model="business.category" type="radio"/>
          <label for="indian">🥘 Indian</label>
        </div>
        <div>
          <input class="cat" value="italian" name="italian" v-model="business.category" type="radio"/>
          <label for="italian">🍝 Italian</label>
        </div>
        <div>
          <input class="cat" value="mexican" name="mexican" v-model="business.category" type="radio"/>
          <label for="mexican">🌮 Mexican</label>
        </div>
      </div>
      </div>  
      <button id="mySearch" type="submit" v-on:click.prevent="search">
        Find your Perfect Plate!
      </button>
    </form>
  </div>
</template>
<script>
import yelpService from '../services/YelpService.js'

export default {
  name: 'business-search',
  data() {
    return {
      business: {
        zipCode: '',
        category: '',
        radius: ''
      },
    };
  },
  methods: {
    changeCategory(category){
      this.business.category = category;
    },
    search() {
      if(this.business.radius === ''){
        yelpService
        .getRestaurantsNoRadius(this.business.zipCode, this.business.category)
        .then((response) => {
          this.$store.commit("ADD_RESTAURANTS", response.data);
          this.$router.push("/businesses/matches");
        });
      } else {
      yelpService
        .getRestaurantsWithRadius(this.business.zipCode, this.business.category, this.business.radius)
        .then((response) => {
          this.$store.commit("ADD_RESTAURANTS", response.data);
          this.$router.push("/businesses/matches");
        });
      }  
    }
  }
};
</script>

<style scoped>
#apps  {
  display: flex;
  flex-flow: column;
  background-image: url(../assets/homeimg.jpg);
  background-size: cover;
  align-items: center;
  background-position-y: -400px;
  height: 100vh;
  margin-bottom: 0;
}
h1 {
  color: white;
  text-align: center;
}
form {
  display: flex;
  flex-flow: column;
  justify-content: flex-start;
  background-color: #111718a9;
  padding: 20px;
  max-width: 1000px;
  margin-top: 100px;
  border-radius: 25px;
  border: 3px solid #990000;
}
#headers {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}
#ppLogo {
  display: flex;
  max-width: 250px;
  min-width: 200px;
}
#zipCode {
  display: flex;
  flex-flow: column;
  justify-content: center;
  align-items: center;
  padding-bottom: 30px
}
#zipHead {
  display: flex;
  justify-self: center;
}
#zipBox {
  display: flex;
  border: 3px solid #990000;
  border-radius: 10px;
  justify-self: center;
  outline: none;
  width: 50%;
  height: 40px;
  text-align: center;
}
#travelRow {
  display: flex;
  align-items: center;
}
#travel {
  display: flex;
  color: white;
  text-align: center;
}
#radius {
  display: flex;
  outline: none;
  height: 50px;
  width: 130px;
  border: 3px solid #990000;
  border-radius: 10px;
}
#category {
  display: flex;
  flex-wrap: wrap;
}
.cat {
  display: flex;
  width: 50%;
  height: 40px;
  text-align: center;
}
div {
  position: relative;
  margin: auto;
  margin-bottom: 10px;
}
label {
  float: left;
  clear: none;
  display: block;
  padding: 0px 1em 0px 8px;
  position: absolute;
  color: black;
  width: 80%;
  height: 100%;
  background: white;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 3px solid #990000;
  border-radius: 10px;
  pointer-events: none;
}
input:checked + label {
  background: #999999;
  font-weight: bold;
  color: black;
}
input[type="radio"] {
  float: left;
  width:150px;
  clear:none;
  margin: 2px 0 0 2px;
}
#mySearch {
  display: flex;
  max-width: 250px;
  align-self: center;
  font-size: 15pt;
  font-weight: bold;
  padding: 0.8rem;
  border-radius: 10px;
  border: 3px solid #990000;
  background-color: #999999;
  margin: auto;
  outline: none;
}
#mySearch:hover {
  background: #990000;
}
</style>