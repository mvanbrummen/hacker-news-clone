package com.mvanbrummen.hackernewsclone.user

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import org.joda.time.LocalDate
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val amazonDynamoDB: AmazonDynamoDB,
    private val dynamoDBMapper: DynamoDBMapper
) {

    fun getUserByUsername(username: String): UserEntity? {
        val users = dynamoDBMapper.query(
            UserEntity::class.java, DynamoDBQueryExpression<UserEntity?>()
                .withKeyConditionExpression("pk = :v_pk")
                .withExpressionAttributeValues(mapOf(":v_pk" to AttributeValue("USERNAME#$username")))
        )

        if (users.size > 1) throw IllegalStateException("Username $username was not unique")

        if (users.isEmpty()) {
            return null
        }
        return users.first()
    }

    fun save(userEntity: UserEntity) = dynamoDBMapper.save(userEntity)

    fun createUser(username: String, passwordHash: String) {
        if (getUserByUsername(username) != null) {
            throw IllegalArgumentException("User already exists for username $username")
        }

        dynamoDBMapper.save(
            UserEntity(
                username = username,
                passwordHash = passwordHash,
                createdDate = LocalDate.now().toString()
            )
        )
    }
}