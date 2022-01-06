<template>
  <div class="comment-section" v-bind:style="{ marginLeft: depth * 10 + 'px' }">
    <div class="row hnUser">
      <span
        >{{ comment.comment.by }}
        {{ timeSinceDate(comment.comment.time) }}</span
      ><a href="javascript:void(0)" v-on:click="toggleHideComment">
        {{
          hideComment
            ? ` [${
                comment.children && comment.children.length
                  ? comment.children.length + " more"
                  : "+"
              }]`
            : " [-]"
        }}</a
      >
    </div>
    <div class="children-section" v-show="!hideComment">
      <div class="row comment">
        <span v-html="comment.comment.text"> </span>
      </div>

      <div v-if="comment.children && comment.children.length">
        <Comment
          v-for="(childComment, idx) in comment.children"
          :comment="childComment"
          :key="idx"
          :depth="depth + 1"
        ></Comment>
      </div>
    </div>
  </div>
</template>

<script>
import { timeSince } from "@/util/dateUtil.js";

export default {
  name: "Comment",
  data() {
    return {
      hideComment: false,
    };
  },
  props: {
    comment: Object,
    depth: {
      type: Number,
      required: false,
      default: 1,
    },
  },
  methods: {
    timeSinceDate(dateSeconds) {
      const d = timeSince(dateSeconds * 1000);
      return " " + d;
    },
    toggleHideComment() {
      this.hideComment = !this.hideComment;
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
