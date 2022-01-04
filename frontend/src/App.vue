<template>
  <div id="nav">
    <router-link to="/" class="logo">HackerNews</router-link> |
    <router-link to="/about" class="nav-link">About</router-link>
  </div>
  <router-view />
</template>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;

  font-family: Verdana, Geneva, sans-serif;
  font-size: 10pt;
  color: #828282;
  background-color: #f6f6ef;
  height: 100vh;
  width: 80vw;
  margin: auto;
}

#nav {
  padding: 2px;
  background-color: #ff6600;
  height: 30px;
}

#nav a {
  color: #000000;
  text-decoration: none;
}

.logo {
  color: #000000;
  margin-right: 5px;
  font-family: Verdana, Geneva, sans-serif;
  font-size: 16px;
  font-weight: bold;
  color: #222222;
}

#nav .nav-link.router-link-exact-active {
  color: #fff;
}
</style>
