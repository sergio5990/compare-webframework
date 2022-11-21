package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10_000);
        SpringApplication.run(DemoApplication.class, args);
    }

}

@RestController
class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
