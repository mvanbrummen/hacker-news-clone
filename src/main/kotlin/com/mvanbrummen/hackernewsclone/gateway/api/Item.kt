package com.mvanbrummen.hackernewsclone.gateway.api

data class Item(
    val id: Long,
    val type: String?,
    val time: Long?,
    val text: String?,
    val by: String?,
    val descendants: Long?,
    val score: Int?,
    val title: String?,
    val kids: List<Int> = emptyList(),
    val url: String?,
    val parent: Int?
)