<template>
  <div class="container u-pull-left">
    <Item :item="item" :rank="1" class="item"></Item>

    <Comment
      v-for="(comment, idx) in comments"
      :comment="comment"
      :key="idx"
      class="comments"
    ></Comment>

    <footer></footer>
  </div>
</template>

<script>
import Item from "@/components/Item.vue";
import Comment from "@/components/Comment.vue";

export default {
  name: "StoryDetail",
  components: { Item, Comment },
  props: {
    item: {
      type: Object,
      required: true,
    },
    comments: Array,
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
.item {
  margin-bottom: 20px;
}
.comments {
  margin-left: 10px;
}
</style>
