<template>
  <StoryDetail :item="story"></StoryDetail>
</template>

<script>
// @ is an alias to /src
import { mapActions } from "vuex";
import StoryDetail from "@/components/StoryDetail.vue";

export default {
  name: "Story",
  components: { StoryDetail },
  methods: {
    ...mapActions(["fetchStory"]),
  },
  computed: {
    story() {
      return this.$store.state.story;
    },
  },
  watch: {
    $route() {
      this.fetchStory(this.$route.query.id);
    },
  },
  beforeCreate() {
    this.$store.dispatch("fetchStory", this.$route.query.id);
  },
};
</script>
