<template>
  <items :itemList="newStories" :page="page"></items>
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
    ...mapActions(["fetchNewStories"]),
  },
  computed: {
    newStories() {
      return this.$store.state.newStories;
    },
    page() {
      return this.$route.query.page ? parseInt(this.$route.query.page) : 0;
    },
  },
  watch: {
    $route() {
      this.fetchNewStories(this.page);
    },
  },
  beforeCreate() {
    this.$store.dispatch("fetchNewStories", this.page);
  },
};
</script>
