<template>
  <StoryDetail :item="story" :comments="comments"></StoryDetail>
  <div class="row" v-if="isLoadingComments">
    <p>Loading comments...</p>
  </div>
</template>

<script>
// @ is an alias to /src
import { mapActions } from "vuex";
import StoryDetail from "@/components/StoryDetail.vue";

export default {
  name: "Story",
  components: { StoryDetail },
  methods: {
    ...mapActions(["fetchStory", "fetchComments"]),
  },
  computed: {
    story() {
      return this.$store.state.story;
    },
    comments() {
      return this.$store.state.comments;
    },
    isLoadingComments() {
      return this.$store.state.loadingComments;
    },
  },
  watch: {
    $route() {
      this.fetchStory(this.$route.query.id);
      this.fetchComments(this.$route.query.id);
    },
  },
  beforeCreate() {
    this.$store.dispatch("fetchStory", this.$route.query.id);
    this.$store.dispatch("fetchComments", this.$route.query.id);
  },
};
</script>
