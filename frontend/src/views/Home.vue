<template>
  <items :itemList="topStories" :page="page"></items>
</template>

<script>
// @ is an alias to /src
import Items from "@/components/Items.vue";
import { mapActions } from "vuex";

export default {
  name: "Home",
  components: {
    Items,
  },
  methods: {
    ...mapActions(["fetchTopStories"]),
  },
  computed: {
    topStories() {
      return this.$store.state.topStories;
    },
    page() {
      return this.$route.query.page ? parseInt(this.$route.query.page) : 0;
    },
  },
  watch: {
    $route() {
      this.fetchTopStories(this.page);
    },
  },
  beforeCreate() {
    this.$store.dispatch("fetchTopStories", this.page);
  },
};
</script>
