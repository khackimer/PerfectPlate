<template>
  <div id="register-container">
      <form id="register" sclass="form-register" @submit.prevent="register">
        <img id="ppLogo" src="@/assets/ppLogo.png" />
        <h1 id="create" class="h3 mb-3 font-weight-normal">Create an Account</h1>
        <div id="alert" class="alert alert-danger" role="alert" v-if="registrationErrors">
          {{ registrationErrorMsg }}
        </div>
        <div id="inputs">
          <input type="text" id="user" class="form-control" placeholder="Username"
            v-model="user.username" required autofocus/>
          <input type="password" id="pass" class="form-control" placeholder="Password"
            v-model="user.password" required/>
          <input type="password" id="confirm" class="form-control" placeholder="Confirm Password"
            v-model="user.confirmPassword" required/>
        </div> 
        <div id="footer">   
          <button id="submit" class="btn btn-lg btn-primary btn-block" type="submit">
            Create Account
          </button>
          <router-link id="accountLink" :to="{ name: 'login' }">
            Have an account?
          </router-link>
        </div>  
      </form>
  </div>
</template>
<script>
import authService from "../services/AuthService";
export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
#register-container {
  display: flex;
  background-image: url(../assets/image.jpg);
  background-size: cover;
  height: 100vh;
  overflow: auto;
}
#register {
  display: flex;
  flex-flow: column;
  max-width: 400px;
  border-radius: 25px;
  padding: 30px;
  border: 3px solid #990000;
  background-color: #111718a9;
  margin: auto;
}
#ppLogo {
  display: flex;
  max-width: 200px;
  margin: auto;
}
#alert {    
  color: rgba(244, 2, 2, 0.847);   
 font-weight: bold;
 font-size: 20px;
 }
#create {
  display: flex;
  align-self: center;
  color: #cccccc;
  padding-bottom: 20px;
  font-size: 26pt;
}
#inputs {
  display: flex;
  flex-flow: column;
  justify-items: center;
}
#user:focus, 
#pass:focus, 
#confirm:focus {
  background-color: #cccccc;
}
#user, 
#pass, 
#confirm {
  display: flex;
  height: 30px;
  max-width: 370px;
  border-radius: 10px;
  border: 3px solid #990000;
  outline: none;
  align-self: center;
}
form input {
  width: 100%;
  margin-bottom: 1rem;
  padding: 10px;
  border: 3px solid #990000;
  border-radius: 10px;
}
#accountLink {
  grid-area: account;
  color: #cccccc;
  text-decoration: none;
  font-size: 20pt;
  padding-left: 30px;
}

/* This is the last two elements */
#footer {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
#submit {
  padding: 0.8rem 1rem;
  border-radius: 10px;
  border: 3px solid #990000;
  background-color: #999999;
  font-size: 15pt;
  outline: none;
}
#submit:hover {
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