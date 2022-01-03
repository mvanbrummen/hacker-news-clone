package com.mvanbrummen.hackernewsclone.config

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput
import com.mvanbrummen.hackernewsclone.user.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class DynamoDBIntegrationTestConfig {
    companion object {
        val TABLE_NAME = "HackerNewsClone"
    }

    @Autowired
    lateinit var amazonDynamoDB: AmazonDynamoDB

    @Autowired
    lateinit var dynamoDBMapper: DynamoDBMapper

    fun localSetup() {
        val tablesResult = amazonDynamoDB.listTables()
        if (!tablesResult.tableNames.contains(TABLE_NAME)) {
            // Single table design: any of the domain class will contain the data needed to create the table
            val tableRequest: CreateTableRequest = dynamoDBMapper.generateCreateTableRequest(UserEntity::class.java)
            tableRequest.provisionedThroughput = ProvisionedThroughput(5L, 5L)
            amazonDynamoDB.createTable(tableRequest)
        }
    }

    fun itemCount(): Long = amazonDynamoDB.describeTable(TABLE_NAME).table.itemCount

    fun clearTable() = amazonDynamoDB.deleteTable(TABLE_NAME)

}