package com.mvanbrummen.hackernewsclone.service

import com.mvanbrummen.hackernewsclone.api.Comment
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

    private val COMMENT_PAGE_SIZE = 10

    fun getPost(id: Long): Item? {
        return hackerNewsClient.getItem(id)
    }

    fun getPostComments(id: Long, page: Int): List<Comment> {
        val item = hackerNewsClient.getItem(id)

        val parentCommentIds = item?.kids
            ?.drop(page * COMMENT_PAGE_SIZE)
            ?.take(COMMENT_PAGE_SIZE)

        return getComments(parentCommentIds ?: emptyList())
    }

    private fun getComments(ids: List<Long>) : List<Comment> {
       return getItemsParallel(ids)
            .filterNotNull()
            .map {
                Comment(
                    it,
                    children = getComments(it.kids)
                )
            }
    }

    fun getTopPosts(page: Int, size: Int): List<Item> {
        val topStoryIds = hackerNewsClient.getTopStories()
        return getPagedItems(topStoryIds, page, size)
    }

    fun getNewPosts(page: Int, size: Int): List<Item> {
        val newStoryIds = hackerNewsClient.getNewStories()
        return getPagedItems(newStoryIds, page, size)
    }

    private fun getPagedItems(itemIds: List<Long>, page: Int, size: Int): List<Item> {
        val topStoryIds = itemIds
            .drop(page * size)
            .take(size)
        return getItemsParallel(topStoryIds).filterNotNull()
    }

    private fun getItemsParallel(ids: List<Long>): List<Item?> {
        return runBlocking {
            val result = ids.map {
                async(Dispatchers.IO) {
                    logger.debug("Calling item http ${Thread.currentThread().id}")
                    hackerNewsClient.getItem(it)
                }
            }

            result.awaitAll()
        }
    }



}