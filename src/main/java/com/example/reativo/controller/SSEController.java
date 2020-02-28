package com.example.reativo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@Controller
public class SSEController {

    @GetMapping(path = "/console", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> console() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "CONSOLE - " + LocalTime.now().toString());
    }
}
