<template>
  <div class="container u-pull-left">
    <Item
      v-for="(item, idx) in itemList"
      :item="item"
      :key="idx"
      :rank="idx + 1"
    ></Item>

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
import Item from "@/components/Item.vue";

export default {
  name: "Items",
  components: { Item },
  props: {
    itemList: {
      type: Array,
      required: false,
    },
    page: Number,
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container {
  margin-top: 8px;
  margin-left: 2px;
}
.title {
  font-family: Verdana, Geneva, sans-serif;
  font-size: 10pt;
  color: #828282;
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
</style>
