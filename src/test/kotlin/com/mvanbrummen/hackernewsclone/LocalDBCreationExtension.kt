package com.mvanbrummen.hackernewsclone

import com.amazonaws.services.dynamodbv2.local.main.ServerRunner
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class LocalDBCreationExtension : BeforeAllCallback, AfterAllCallback {
    init {
        System.setProperty("sqlite4java.library.path", "native-libs")
    }

    lateinit var dynamoDBProxyServer: DynamoDBProxyServer

    override fun beforeAll(e: ExtensionContext) {
        dynamoDBProxyServer = ServerRunner.createServerFromCommandLineArgs(arrayOf("-inMemory", "-port", "8000"))
        dynamoDBProxyServer.start()
    }

    override fun afterAll(e: ExtensionContext) {
        dynamoDBProxyServer.stop();
    }
}