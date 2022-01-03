package com.mvanbrummen.hackernewsclone.user

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import com.mvanbrummen.hackernewsclone.LocalDBCreationExtension
import org.joda.time.LocalDate
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
@ExtendWith(LocalDBCreationExtension::class)
internal class UserEntityIntegrationTest {
    @Autowired
    lateinit var dynamoDb: AmazonDynamoDB
    lateinit var dynamoDBMapper: DynamoDBMapper

    @BeforeEach
    internal fun setUp() {
        dynamoDBMapper = DynamoDBMapper(dynamoDb)

        val createTableRequest = dynamoDBMapper.generateCreateTableRequest(UserEntity::class.java).apply {
            provisionedThroughput = ProvisionedThroughput(5L, 5L)
        }
        dynamoDb.createTable(createTableRequest)
    }

    @Test
    fun `should create user when valid request`() {
        val userEntity = UserEntity(
            "mvanbrummen",
            "passsowrdhash123",
            LocalDate.now().toString(),
            "USERNAME#mvanbrummen",
            "USERNAME#mvanbrummen"
        )

        dynamoDBMapper.save(userEntity)
    }

}