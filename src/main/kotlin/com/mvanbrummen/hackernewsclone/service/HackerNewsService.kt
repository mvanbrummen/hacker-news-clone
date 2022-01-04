package com.mvanbrummen.hackernewsclone.service

import com.mvanbrummen.hackernewsclone.gateway.HackerNewsClient
import com.mvanbrummen.hackernewsclone.gateway.api.Item
import org.springframework.stereotype.Service

@Service
class HackerNewsService(
    private val hackerNewsClient: HackerNewsClient
) {

    fun getTopPosts(page: Int, size: Int): List<Item?> {
        val topStoryIds = hackerNewsClient.getTopStories()
            .drop(page * size)
            .take(size)
        return topStoryIds.map(hackerNewsClient::getItem)
    }

}