/*
 * Copyright (c) 2020-2021 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.netty.examples.http.helloworld;

import io.netty.handler.ssl.util.SelfSignedCertificate;
import reactor.core.publisher.Mono;
import reactor.netty.http.Http11SslContextSpec;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;
import java.time.LocalDateTime;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaderValues.TEXT_PLAIN;

/**
 * An HTTP server that expects GET request and sends back "Hello World!".
 *
 * @author Violeta Georgieva
 */
public final class HelloWorldServer {

	public static void main(String[] args) throws Exception {
		final LocalDateTime start = LocalDateTime.now();
		HttpServer server =
				HttpServer.create()
						.doOnBound( it -> {
							final Duration startUp = Duration.between(start, LocalDateTime.now());
							System.out.println("server started in " + startUp);
						})
				          .port(8080)
				          .route(r -> r.get("/hello",
				                  (req, res) -> res.header(CONTENT_TYPE, TEXT_PLAIN)
				                                   .sendString(Mono.just("Hello World!"))));

		server.bindNow()
		      .onDispose()
		      .block();
	}
}
