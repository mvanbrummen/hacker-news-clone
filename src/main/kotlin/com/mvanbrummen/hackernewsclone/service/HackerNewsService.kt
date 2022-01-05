package com.mvanbrummen.hackernewsclone.service

import com.mvanbrummen.hackernewsclone.gateway.HackerNewsClient
import com.mvanbrummen.hackernewsclone.gateway.api.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HackerNewsService(
    private val hackerNewsClient: HackerNewsClient
) {
    private val logger: Logger = LoggerFactory.getLogger(HackerNewsService::class.java)

    fun getPost(id: Long): Item? {
        return hackerNewsClient.getItem(id)
    }

    fun getTopPosts(page: Int, size: Int): List<Item?> {
        val topStoryIds = hackerNewsClient.getTopStories()
        return getPagedItems(topStoryIds, page, size)
    }

    fun getNewPosts(page: Int, size: Int): List<Item?> {
        val newStoryIds = hackerNewsClient.getNewStories()
        return getPagedItems(newStoryIds, page, size)
    }

    fun getPagedItems(itemIds: List<Long>, page: Int, size: Int): List<Item?> {
        val topStoryIds = itemIds
            .drop(page * size)
            .take(size)

        return runBlocking {
            val result = topStoryIds.map {
                async(Dispatchers.IO) {
                    logger.debug("Calling item http ${Thread.currentThread().id}")
                    hackerNewsClient.getItem(it)
                }
            }

            result.awaitAll()
        }
    }
}