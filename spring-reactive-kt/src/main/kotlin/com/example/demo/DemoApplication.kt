package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	Thread.sleep(10_000)
	runApplication<DemoApplication>(*args)
}


@RestController
class Controller {

	@GetMapping("/hello")
	fun hello() = "Hello  World"
}


