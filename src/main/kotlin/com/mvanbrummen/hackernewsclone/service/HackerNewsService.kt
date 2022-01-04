package com.mvanbrummen.hackernewsclone.service

import com.mvanbrummen.hackernewsclone.gateway.HackerNewsClient
import com.mvanbrummen.hackernewsclone.gateway.api.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class HackerNewsService(
    private val hackerNewsClient: HackerNewsClient
) {

    fun getTopPosts(page: Int, size: Int): List<Item?> {
        val topStoryIds = hackerNewsClient.getTopStories()
            .drop(page * size)
            .take(size)

        return runBlocking {
            val result = topStoryIds.map {
                async(Dispatchers.IO) {
                    println("Calling item http ${Thread.currentThread().id}")
                    hackerNewsClient.getItem(it)
                }
            }

            result.awaitAll()
        }
    }

}