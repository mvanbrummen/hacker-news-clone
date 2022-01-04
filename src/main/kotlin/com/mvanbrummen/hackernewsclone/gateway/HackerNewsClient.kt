package com.mvanbrummen.hackernewsclone.gateway

import com.mvanbrummen.hackernewsclone.gateway.api.Item
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${hackernews.api.baseurl}", name = "hackernews")
interface HackerNewsClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/item/{id}.json"])
    fun getItem(@PathVariable id: Long): Item?

    @RequestMapping(method = [RequestMethod.GET], value = ["/topstories.json"])
    fun getTopStories(): List<Long>

    @RequestMapping(method = [RequestMethod.GET], value = ["/newstories.json"])
    fun getNewStories(): List<Long>

    @RequestMapping(method = [RequestMethod.GET], value = ["/beststories.json"])
    fun getBestStories(): List<Long>

}