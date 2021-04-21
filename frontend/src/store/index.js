import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
Vue.use(Vuex)
/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}
export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    rejects: [],
    favorites: [],
    restaurants: [],
    restaurant: {
      id: '',
      name: '',
      image_url: '',
      url: '',
      review_count: Number,
      categories: [],
      rating: Number,
      location: [],
      display_phone: '',
      price: ''
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
      state.rejects = [];
      state.restaurants = [];
      state.restaurant = {};
    },
    ADD_RESTAURANTS(state, data) {
      state.restaurants = [];
      let rejectSet = new Set();
      state.rejects.forEach(reject => {
        rejectSet.add(reject.id);
      });
      data.forEach(business => {
        state.restaurant = business;
        if(!rejectSet.has(state.restaurant.id)){
          state.restaurants.push(state.restaurant);
        }
      });
    },
    REMOVE_RESTAURANT(state) {
      state.restaurants.shift();
    },
    ADD_REJECTS(state, business) {
      state.restaurant = business;
      state.rejects.push(state.restaurant);
    },
    MAKE_FAVORITES(state, data) {
      state.favorites = [];
      data.forEach(business => {
        state.restaurant = business;
        state.favorites.push(state.restaurant);
      });
    },
    DELETE_FAVORITES(state, businessID) {
      let temporary = state.favorites.filter((favorite) => {
        return businessID != favorite.id;
      });
      state.favorites = temporary;
    }
  
  }
})