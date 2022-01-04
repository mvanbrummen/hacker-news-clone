package com.mvanbrummen.hackernewsclone.controller

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
    fun getTopStories(@RequestParam page: Int?): List<Item?> {
        return hackerNewsService.getTopPosts(page ?: DEFAULT_PAGE, DEFAULT_PAGE_SIZE)
    }
}