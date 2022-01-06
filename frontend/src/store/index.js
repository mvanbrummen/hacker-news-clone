import axios from "axios";
import { createStore } from "vuex";

const BASE_URL = process.env.API_BASE_URL
  ? process.env.API_BASE_URL
  : "http://localhost:8080/v1";

export default createStore({
  state: {
    topStories: [],
    newStories: [],
    story: {},
    comments: [],
    loadingComments: false,
  },
  mutations: {
    setTopStories(state, topStories) {
      state.topStories = topStories;
    },
    setNewStories(state, newStories) {
      state.newStories = newStories;
    },
    setStory(state, story) {
      state.story = story;
    },
    setComments(state, comments) {
      state.comments = comments;
    },
    setLoadingComments(state, loadingComments) {
      state.loadingComments = loadingComments;
    },
  },
  actions: {
    async fetchTopStories({ commit }, page = 0) {
      const data = await axios.get(`${BASE_URL}/topstories?page=${page}`);
      commit("setTopStories", data.data);
    },
    async fetchNewStories({ commit }, page = 0) {
      const data = await axios.get(`${BASE_URL}/newstories?page=${page}`);
      commit("setNewStories", data.data);
    },
    async fetchStory({ commit }, id) {
      const data = await axios.get(`${BASE_URL}/stories/${id}`);
      commit("setStory", data.data);
    },
    async fetchComments({ commit }, id) {
      commit("setLoadingComments", true);
      console.log("making comments request");
      const data = await axios.get(`${BASE_URL}/stories/${id}/comments`);
      console.log(data.data);
      commit("setLoadingComments", false);
      commit("setComments", data.data);
    },
  },
  modules: {},
});
