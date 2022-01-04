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

}