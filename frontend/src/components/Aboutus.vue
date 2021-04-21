<template>
  <body>
    <div class="about-section">
      <h1>About Us</h1>
      <li>The final capstone</li>
      <li>Team Name: Perfect Plate</li>
      <li>Project Name: Restaurant Tinder</li>
      <li>Team Members: Nicholas, Kurt, Dhaka and Hemu</li>

      <li>
        Objective: Created a web application to help food lovers to match
        perfect plate.
      </li>
    </div>

    <h2 style="text-align: center">Our Team</h2>

    <div class="row">
      <div class="column">
        <div class="card">
          <img src="../assets/Nick.jpg" alt="Nick" style="width: 100%" />
          <div class="container">
            <h2>Nicholas</h2>
            <p class="title">Connect to know more:</p>
            <p>
              <a class="button"
                href="https://www.linkedin.com/in/nicholasbruceweller"
                target="_blank">linkedin</a>
            </p>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="../assets/Kurt.png" alt="Kurt" style="width: 100%" />
          <div class="container">
            <h2>Kurt</h2>
            <p class="title">Connect to know more:</p>

            <p>
              <a
                class="button"
                href="https://www.linkedin.com/in/khackimer"
                target="_blank"
                >linkedin</a
              >
            </p>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="../assets/Dhaka.jpg" alt="Dhaka" style="width: 100%" />
          <div class="container">
            <h2>Dhaka</h2>
            <p class="title">Connect to know more:</p>

            <p>
              <a
                class="button"
                href="https://www.linkedin.com/in/dhakaramkadarya"
                target="_blank"
                >linkedin</a
              >
            </p>
          </div>
        </div>
      </div>

      <div class="column">
        <div class="card">
          <img src="../assets/Hemu.jpg" alt="Hemu" style="width: 100%" />
          <div class="container">
            <h2>Hemu</h2>
            <p class="title">Connect to know more:</p>

            <p>
              <a
                class="button"
                href="https://www.linkedin.com/in/hemu182"
                target="_blank"
                >linkedin</a
              >
            </p>
          </div>
        </div>
      </div>
      <hr />
      <p class="createdby">© Created & Designed by Perfect Plate Team</p>
      <p class="forperfect">Designed for Perfect Plate</p>
    </div>
  </body>
</template>

<script>
</script>

<style scoped>
* {
  box-sizing: border-box;
}
.row {
  display: flex;
  flex-wrap: wrap;
}
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
  background-color: rgba(138, 116, 116, 0.788);
}

.column {
  display: flex;
  flex: 25%;
  padding: 20px;
  background-color: rgba(185, 8, 8, 0.63);
  
}

.card {
  border-radius: 30px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  margin: 0px;
  
}

.about-section {
  padding: 50px;
  text-align: center;
  background-color: #474e5d;
  color: white;
}

.container {
  padding: 0 16px;
}

.title {
  color: rgb(22, 19, 19);
}

.button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
}

.button:hover {
  background-color: #555;
}

@media screen and (max-width: 650px) {
  .column {
    width: 100%;
    display: block;
  }
}
h2 {
  padding-top: 10px;
  padding-bottom: 10px;
}
hr {
  margin-top: 50px;
  background-color: #ccc;
}

.createdby {
  color: #050505;
  font-family: "Courgette", cursive;
  font-size: 20px;
  margin-left: 10px;
  margin-top: 7px;
}

.forperfect {
  color: #050505;
  display: inline;
  float: left;
  font-size: 20px;
  margin-left: 1043px;
  margin-top: -34px;
  font-family: "Courgette", cursive;
}
li {
  font-size: 20px;
  color: lightcoral;
}
/* img {
  max-width: 100%;
  height: auto;
} */
</style>