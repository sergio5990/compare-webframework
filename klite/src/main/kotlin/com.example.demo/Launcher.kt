package com.example.demo

import klite.*
import java.net.InetSocketAddress
import java.time.Duration
import java.time.Instant

fun main() {
    val startTime = Instant.now()
    sampleServer().start()
    val startupTime = Duration.between(startTime, Instant.now())
    println("klite server started at $startupTime")
}

fun sampleServer(port: Int = 8080) = Server(listen = InetSocketAddress(port)).apply {
    context("/hello") {
        get { "Hello Word" }
    }
}