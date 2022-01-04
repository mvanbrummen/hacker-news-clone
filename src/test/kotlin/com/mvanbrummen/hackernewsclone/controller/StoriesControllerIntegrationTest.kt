package com.mvanbrummen.hackernewsclone.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
internal class StoriesControllerIntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    internal fun `should return response when topstories requested`() {
        webTestClient.get().uri("/v1/topstories")
            .exchange()
            .expectBody()
    }
}