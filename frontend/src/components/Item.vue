<template>
  <div class="story" :key="key">
    <div class="row">
      <span class="rank title">{{ rank }}.</span>
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
        ><a v-bind:href="'#'">{{ item.by }}</a>
      </span>
      <span class="age">
        <a v-bind:href="'#'"> {{ timeSinceDate(item.time) }}</a></span
      >
      |
      <span class="comments"
        ><router-link :to="{ path: '/item', query: { id: item.id } }"
          >{{ item.descendants }} comments</router-link
        ></span
      >
    </div>
  </div>
</template>

<script>
import { timeSince } from "@/util/dateUtil.js";

export default {
  name: "Item",
  props: {
    item: {
      type: Object,
      required: true,
    },
    page: Number,
    rank: Number,
    key: Number,
  },
  methods: {
    getDomainForUrl(url) {
      if (url === undefined || url === null) {
        return "";
      }
      const u = new URL(url);
      return `(${u.hostname})`;
    },
    timeSinceDate(dateSeconds) {
      const d = timeSince(dateSeconds * 1000);
      return " " + d;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
</style>
