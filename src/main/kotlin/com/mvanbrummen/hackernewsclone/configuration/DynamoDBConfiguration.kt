package com.mvanbrummen.hackernewsclone.configuration

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class DynamoDBConfiguration(
    @Value("\${amazon.region}") private val region: String,
    @Value("\${dynamodb.endpoint.url}") private val dynamoDBEndpoint: String
) {

    @Bean
    fun amazonDynamoDB(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder
            .standard()
            .withEndpointConfiguration(EndpointConfiguration(dynamoDBEndpoint, region))
            .build()
    }
}