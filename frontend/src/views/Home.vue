<template>
  <items :itemList="itemList"></items>
</template>

<script>
// @ is an alias to /src
import Items from "@/components/Items.vue";

export default {
  name: "Home",
  data() {
    return {
      itemList: [
        {
          id: 29781928,
          type: "story",
          time: 1641224975,
          text: null,
          by: "eversowhatev",
          descendants: 22,
          score: 85,
          title: "Choose-Your-Own-Adventure AI Dungeon Games",
          kids: [
            29787207, 29783808, 29788967, 29789154, 29788247, 29785209,
            29787789, 29784220, 29783932, 29787188,
          ],
          url: "https://www.gwern.net/CYOA",
          parent: null,
        },
        {
          id: 33333,
          type: "story",
          time: 1641224975,
          text: null,
          by: "eversowhatev",
          descendants: 22,
          score: 85,
          title: "Testing some VueJs",
          kids: [
            29787207, 29783808, 29788967, 29789154, 29788247, 29785209,
            29787789, 29784220, 29783932, 29787188,
          ],
          url: "https://www.gwern.net/CYOA",
          parent: null,
        },
      ],
    };
  },
  components: {
    Items,
  },
};
</script>
