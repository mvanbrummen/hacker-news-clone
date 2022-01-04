import axios from "axios";
import { createStore } from "vuex";

const BASE_URL = process.env.API_BASE_URL
  ? process.env.API_BASE_URL
  : "http://localhost:8080/v1";

export default createStore({
  state: {
    topStories: [],
  },
  mutations: {
    setTopStories(state, topStories) {
      state.topStories = topStories;
    },
  },
  actions: {
    async fetchTopStories({ commit }, page = 0) {
      const data = await axios.get(`${BASE_URL}/topstories?page=${page}`);
      commit("setTopStories", data.data);
    },
  },
  modules: {},
});
