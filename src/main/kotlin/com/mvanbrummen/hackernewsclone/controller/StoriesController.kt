package com.mvanbrummen.hackernewsclone.controller

import com.mvanbrummen.hackernewsclone.api.Comment
import com.mvanbrummen.hackernewsclone.gateway.api.Item
import com.mvanbrummen.hackernewsclone.service.HackerNewsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = ["*"])
class StoriesController(
    private val hackerNewsService: HackerNewsService
) {
    private val DEFAULT_PAGE_SIZE = 30
    private val DEFAULT_PAGE = 0

    @GetMapping("/topstories")
    fun getTopStories(@RequestParam page: Int?): List<Item> {
        return hackerNewsService.getTopPosts(page ?: DEFAULT_PAGE, DEFAULT_PAGE_SIZE)
    }

    @GetMapping("/newstories")
    fun getNewStories(@RequestParam page: Int?): List<Item> {
        return hackerNewsService.getNewPosts(page ?: DEFAULT_PAGE, DEFAULT_PAGE_SIZE)
    }

    @GetMapping("/stories/{id}")
    fun getStory(@PathVariable id: Long): Item? = hackerNewsService.getPost(id)

    @GetMapping("/stories/{id}/comments")
    fun getStoryComments(@PathVariable id: Long, @RequestParam page: Int?): List<Comment> = hackerNewsService.getPostComments(id, page ?: 0)

}