<template>
  <div id="login-container">
    <form id="form" class="form-signin" @submit.prevent="login">
      <div id="header">
        <h1 id="signIn" class="h3 mb-3 font-weight-normal">Please Sign In!</h1>
        <img id="ppLogo" src="@/assets/ppLogo.png" />
      </div>
      <div id="tagGroup">  
        <div id="invalid" class="alert alert-danger" role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div id="register" class="alert alert-success" role="alert"
          v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <p id="tagLine">Perfect Plate Welcomes Everyone</p>
      </div> 
      <div id="logIn"> 
        <input type="text" id="user" class="form-control"
        placeholder="Username" v-model="user.username" required autofocus/>
        <input type="password" id="pass" class="form-control" placeholder="Password"
          v-model="user.password" required/>
      </div> 
      <div id="footer"> 
        <button id="signButton" type="submit" class="btn btn-primary">Sign in</button>
        <router-link id="accountLink" :to="{ name: 'register' }">Need an account?</router-link>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
      .login(this.user)
      .then((response) => {
        if (response.status == 200) {
          this.$store.commit("SET_AUTH_TOKEN", response.data.token);
          this.$store.commit("SET_USER", response.data.user);
          this.$router.push("/");
        }
      })
      .catch((error) => {
        const response = error.response;
        if (response.status === 401) {
          this.invalidCredentials = true;
        }
      });
    },
  },
};
</script>

<style scoped>
/* This is the background */
#login-container {
  display: flex;
  background-image: url(../assets/image.jpg);
  background-size: cover;
  height: 100vh;
  overflow: auto;
}
/* This is the central form */
#form {
  display: flex;
  flex-direction: column;
  background-color: #111718a9;
  max-width: 450px;
  padding: 30px;
  margin: auto;
  border-radius: 25px;
  border: 3px solid #990000;
  background-color: #111718a9;
  color: white;
}
/* This controls the top two elements */
#header {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
/* This is the Perfect Plate logo */
#ppLogo {
  display: flex;
  max-width: 200px;
  flex-wrap: wrap;
  align-self: center;
  justify-self: center;
}
/* This is "Please Sign In!" */
#signIn {
  display: flex;
  justify-self: center;
  text-align: center;
  align-items: center;
  color: #cccccc;
  font-size: 26pt;
}
/* This is the messages and taglines in middle */
#tagGroup {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  align-content: center;
  text-align: center;
  color: #cccccc;
}
/* This is "Perfect Plate Welcomes..." */
#tagLine {
  display: flex;
  font-size: 22pt;
}
/* This controls both text inputs together */
#logIn {
  display: flex;
  flex-flow: column;
  justify-content: space-evenly;
  padding-bottom: 10px;
}
/* These are the text inputs */
#user:focus,
#pass:focus {
  background-color: #cccccc;
}
#user, #pass {
  display: flex;
  justify-content: center;
  max-width: 400px;
  padding: 15px;
  margin: 5px 0 0px 0;
  border-radius: 10px;
  background-color: white;
  border: 3px solid #990000;
  outline: none;
  font-size: 12pt;
}
/* This is the last two elements */
#footer {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
/* This is the sign-in button */
#signButton {
  padding: 0.8rem 1rem;
  border-radius: 10px;
  border: 3px solid #990000;
  background-color: #999999;
  font-size: 15pt;
  outline: none;
}
#signButton:hover {
  background: rgb(209, 68, 43);  
}
/* This is the link to new account */
#accountLink{
  display: flex;
  color: #cccccc;
  text-decoration: none;
  font-size: 20pt;
  align-items: flex-end;
}
/* This code below is for username and password placeholder to jump */
input::-webkit-input-placeholder {
  font-family: "roboto", sans-serif;
  -webkit-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}
input:focus::-webkit-input-placeholder,
input:valid::-webkit-input-placeholder {
  color: #111312;
  font-size: 12px;
  -webkit-transform: translateY(-20px);
  transform: translateY(-15px);
  visibility: visible !important;
}
/* ::-webkit-scrollbar{
  display: none;
} */
</style>
