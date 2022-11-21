package com.example;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10_000);
        get("/hello", (req, res) -> "Hello World");
    }
}