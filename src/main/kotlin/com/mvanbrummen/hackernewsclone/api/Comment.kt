package com.mvanbrummen.hackernewsclone.api

import com.mvanbrummen.hackernewsclone.gateway.api.Item

data class Comment(
    val comment: Item,
    val children: List<Comment>?
)
