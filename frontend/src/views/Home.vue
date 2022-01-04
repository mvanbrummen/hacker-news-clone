<template>
  <items :itemList="this.$store.state.topStories"></items>
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
  beforeCreate() {
    this.$store.dispatch("fetchTopStories");
  },
};
</script>
