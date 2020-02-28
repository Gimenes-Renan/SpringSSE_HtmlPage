package com.example.reativo.controller;

import com.example.reativo.model.ConsoleModel;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@Controller
public class SSEController {
    public static final ConsoleModel console1 = new ConsoleModel();

    @GetMapping(path = "/console", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> console() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "THREAD 1  - " + new GerarNumeros().Thread1().getMensagem());
    }

    @GetMapping(path = "/console2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> console2() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "CONSOLE 2 - "  + new GerarNumeros().Thread1().getMensagem());
    }
}
