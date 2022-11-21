package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    Thread.sleep(10_000)
    embeddedServer(Netty, port = 8000) {
        routing {
            get ("/hello") {
                call.respondText("Hello, world!")
            }
        }
    }.start(wait = true)
}
