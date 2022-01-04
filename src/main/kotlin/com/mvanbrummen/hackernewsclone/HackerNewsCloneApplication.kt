package com.mvanbrummen.hackernewsclone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class HackerNewsCloneApplication

fun main(args: Array<String>) {
	runApplication<HackerNewsCloneApplication>(*args)
}
