<template>
  <div id="nav">
    <img src="./assets/y18.gif" />
    <router-link to="/" class="logo">HackerNews</router-link>
    | <router-link to="/new" class="nav-link">new</router-link> |
    <router-link to="/about" class="nav-link">about</router-link>
  </div>
  <router-view />
</template>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;

  font-family: Verdana, Geneva, sans-serif;
  font-size: 10pt;
  color: #828282;
  background-color: #f6f6ef;
  height: 1300px;
  width: 80vw;
  margin: auto;
}

#nav {
  padding: 2px;
  background-color: #ff6600;
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

img {
  height: 18px;
  width: 18px;
  border: 1px white solid;
  position: relative;
  top: 50%;
  transform: translateY(15%);
  margin-right: 5px;
}

#nav .nav-link.router-link-exact-active {
  color: #fff;
}
</style>
