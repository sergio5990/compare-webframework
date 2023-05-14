package com.example.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.ext.web.Router;

import java.time.Duration;
import java.time.LocalDateTime;

class MainVerticle extends AbstractVerticle {

  private final LocalDateTime now;

  public MainVerticle(LocalDateTime now) {
    this.now = now;
  }

  public void start(Promise<Void> startPromise) {
    var router = Router.router(vertx);

    router.route().path("/hello")
      .handler(ctx -> ctx.response()
        .end("Hello World"));

    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080, server -> {
        final Duration startUp = Duration.between(now, LocalDateTime.now());
        System.out.println("MainVerticle vertx started in " + startUp);
      });
  }
}
