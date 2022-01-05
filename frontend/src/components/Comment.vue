<template>
  <div class="comment-section">
    <div class="row hnUser">
      <span
        >{{ comment.comment.by }}
        {{ timeSinceDate(comment.comment.time) }}</span
      ><a href="javascript:void(0)"> [-]</a>
    </div>
    <div class="row comment">
      <span v-html="comment.comment.text"> </span>
    </div>
  </div>
</template>

<script>
import { timeSince } from "@/util/dateUtil.js";

export default {
  name: "Comment",
  props: {
    comment: Object,
  },
  methods: {
    timeSinceDate(dateSeconds) {
      const d = timeSince(dateSeconds * 1000);
      return " " + d;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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

.hnUser {
  font-family: Verdana, Geneva, sans-serif;
  font-size: 8pt;
  color: #828282;
}

.comment {
  font-family: Verdana, Geneva, sans-serif;
  font-size: 9pt;
  overflow-wrap: anywhere;
  color: #000000;
}
.comment-section {
  margin-bottom: 10px;
}
</style>
