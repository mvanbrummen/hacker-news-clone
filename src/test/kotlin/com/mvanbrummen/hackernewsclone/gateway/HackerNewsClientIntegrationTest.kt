package com.mvanbrummen.hackernewsclone.gateway

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HackerNewsClientIntegrationTest {

    @Autowired
    lateinit var hackerNewsClient: HackerNewsClient

    @Test
    internal fun `should return item when valid request`() {
        val result = hackerNewsClient.getItem(8863)

        assertThat(result).isNotNull
    }

    @Test
    internal fun `should return top stories wnen valid`() {
        assertThat(hackerNewsClient.getTopStories()).isNotNull
    }

    @Test
    internal fun `should return new stories wnen valid`() {
        assertThat(hackerNewsClient.getNewStories()).isNotNull
    }

    @Test
    internal fun `should return best stories wnen valid`() {
        assertThat(hackerNewsClient.getBestStories()).isNotNull
    }
}