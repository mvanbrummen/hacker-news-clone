package com.mvanbrummen.hackernewsclone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HackerNewsCloneApplication

fun main(args: Array<String>) {
	runApplication<HackerNewsCloneApplication>(*args)
}
