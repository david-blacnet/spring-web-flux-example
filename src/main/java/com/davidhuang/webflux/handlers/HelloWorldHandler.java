/*
 * Copyright (c) 2019.
 *
 * Developed by David L Budiman. david.budiman91@gmail.com. -@davidlblacnet-
 * Created on 10/18/18 10:34 PM
 */

package com.davidhuang.webflux.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class HelloWorldHandler {
    public Mono<ServerResponse> getDefault(ServerRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("data", "Hello World!");
        return ok().contentType(MediaType.APPLICATION_JSON).syncBody(body);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("data", String.format("Hello %s!", request.pathVariable("name")));
        return ok().contentType(MediaType.APPLICATION_JSON).syncBody(body);
    }
}
