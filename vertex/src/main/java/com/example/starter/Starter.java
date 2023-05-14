package com.example.starter;

import io.vertx.core.Vertx;

import java.time.Duration;
import java.time.LocalDateTime;

public class Starter {

  public static void main(String[] args) throws InterruptedException {
    final LocalDateTime start = LocalDateTime.now();
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle(LocalDateTime.now()));
    final Duration startUp = Duration.between(start, LocalDateTime.now());
    System.out.println("server vertx started in " + startUp);
  }

}
