package com.abledenthusiast.gengar.server;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/api")
public class GengarController {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello World, and goodbye world.";
    }
}
