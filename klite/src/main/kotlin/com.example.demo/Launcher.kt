package com.example.demo

import klite.*
import java.net.InetSocketAddress
import java.net.http.HttpClient
import java.nio.file.Path
import java.time.Duration.ofSeconds

fun main() {
    Thread.sleep(10_000)
    sampleServer().start()
}

fun sampleServer(port: Int = 8080) = Server(listen = InetSocketAddress(port)).apply {
    context("/hello") {
        get { "Hello World" }
    }
}