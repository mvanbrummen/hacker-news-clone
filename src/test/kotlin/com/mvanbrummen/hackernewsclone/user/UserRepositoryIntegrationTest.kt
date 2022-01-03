package com.mvanbrummen.hackernewsclone.user

import com.mvanbrummen.hackernewsclone.LocalDBCreationExtension
import com.mvanbrummen.hackernewsclone.config.DynamoDBIntegrationTestConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(LocalDBCreationExtension::class)
internal class UserRepositoryIntegrationTest {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var dynamoDBIntegrationTestConfig: DynamoDBIntegrationTestConfig

    @BeforeEach
    internal fun setUp() {
        dynamoDBIntegrationTestConfig.localSetup()
    }

    @AfterEach
    internal fun tearDown() {
//        assertThat(dynamoDBIntegrationTestConfig.itemCount()).isZero
        dynamoDBIntegrationTestConfig.clearTable() // TODO clean up the items instead
    }

    @Test
    internal fun `should create a user when valid`() {
        userRepository.createUser("mvanbrummen", "passwordhash123")

        assertThat(dynamoDBIntegrationTestConfig.itemCount()).isEqualTo(1)
    }

    @Test
    internal fun `should find a user when valid username`() {
        userRepository.createUser("mvanbrummen", "passwordhash123")

        val result = userRepository.getUserByUsername("mvanbrummen")

        assertThat(result).isNotNull
    }

    @Test
    internal fun `should return null when user not found`() {
        val result = userRepository.getUserByUsername("needleUser")

        assertThat(result).isEqualTo(null)
    }
}