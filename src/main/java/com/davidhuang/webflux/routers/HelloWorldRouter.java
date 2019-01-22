/*
 * Copyright (c) 2019.
 *
 * Developed by David L Budiman. david.budiman91@gmail.com. -@davidlblacnet-
 * Created on 10/18/18 10:34 PM
 */

package com.davidhuang.webflux.routers;

import com.davidhuang.webflux.handlers.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HelloWorldRouter {

    @Bean
    public RouterFunction<ServerResponse> helloWorldRoute(HelloWorldHandler handler) {
        RouterFunction<ServerResponse> route = route(GET("/hello-world"), handler::getDefault)
                .andRoute(GET("/hello-world/{name}"), handler::get);
        return route;
    }

}
