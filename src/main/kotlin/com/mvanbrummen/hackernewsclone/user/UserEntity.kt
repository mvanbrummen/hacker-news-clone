package com.mvanbrummen.hackernewsclone.user

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName = "HackerNewsClone")
class UserEntity(

    @DynamoDBAttribute(attributeName = "username")
    var username: String? = null,

    @DynamoDBAttribute(attributeName = "password_hash")
    var passwordHash: String? = null,

    @DynamoDBAttribute(attributeName = "created_date")
    var createdDate: String? = null,

    @DynamoDBHashKey(attributeName = "pk")
    var pk: String = "USERNAME#" + username,

    @DynamoDBRangeKey(attributeName = "sk")
    var sk: String = "USERNAME#" + username
) {
}