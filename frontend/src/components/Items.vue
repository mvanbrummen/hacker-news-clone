<template>
  <div class="container u-pull-left">
    <div v-for="(item, idx) in itemList" :key="idx" class="story">
      <div class="row">
        <span class="rank title">{{ idx + 1 }}.</span>
        <a v-bind:href="item.url"> {{ item.title }}</a>
        <span class="sitestr comhead"
          ><a v-bind:href="item.url" class="title">
            {{ getDomainForUrl(item.url) }}</a
          ></span
        >
      </div>

      <div class="row subtext">
        <span class="score">{{ item.score }} points</span> by
        <span class="user"
          ><a v-bind:href="'#'">{{ item.by }}</a></span
        >
        <span class="age">
          <a v-bind:href="'#'"> {{ item.time }} ago</a></span
        >
        |
        <span class="comments"
          ><a v-bind:href="'#'">{{ item.descendants }} comments</a></span
        >
      </div>
    </div>

    <div class="row">
      <span class="moreLink title"
        ><router-link :to="{ path: '/', query: { page: page + 1 } }"
          >More</router-link
        ></span
      >
    </div>
    <footer></footer>
  </div>
</template>

<script>
export default {
  name: "Items",
  props: {
    itemList: {
      type: Array,
      required: false,
    },
    page: Number,
  },
  methods: {
    getDomainForUrl(url) {
      if (url === undefined || url === null) {
        return "";
      }
      const u = new URL(url);
      return `(${u.hostname})`;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container {
  margin-top: 8px;
  margin-left: 2px;
}
.story {
  margin-bottom: 3px;
}
.title {
  font-family: Verdana, Geneva, sans-serif;
  font-size: 10pt;
  color: #828282;
}
a {
  color: #000000;
  text-decoration: none;
}
.title a {
  word-break: break-word;
}
a:visited {
  color: #828282;
  text-decoration: none;
}
.comhead {
  font-family: Verdana, Geneva, sans-serif;
  font-size: 8pt;
  color: #828282;
}
.subtext {
  font-family: Verdana, Geneva, sans-serif;
  font-size: 7pt;
  color: #828282;
  margin-left: 15px;
}

.moreLink {
  margin-left: 15px;
  margin-top: 30px;
}

footer {
  height: 30px;
  margin-top: 20px;
  width: 80vw;
  border-top-width: 2px;
  border-top-style: solid;
  border-top-color: #ff6600;
}
</style>
