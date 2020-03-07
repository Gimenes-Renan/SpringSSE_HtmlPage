package com.example.reativo.controller;

import com.example.reativo.model.ConsoleModel;
import com.example.reativo.model.LoginModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;

@Controller
public class SSEController {
    public static String MSG_T1 = "NAO INICIADO";
    public static String MSG_T2 = "NAO INICIADO";
    public static String MSG_T3 = "{'chave':'valor'}";

    public static ConsoleModel consoleModel = new ConsoleModel();

    @GetMapping(path = "/console", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> console() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "THREAD 1  - " + MSG_T1);
    }

    @GetMapping(path = "/console2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> console2() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "CONSOLE 2 - " + MSG_T2);
    }

    @GetMapping(path = "/console3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> console3() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> MSG_T3);
    }

    @GetMapping("/json")
    public String jsonTeste() {
        return "json";
    }


    @PostMapping("/mensagem")
    public ResponseEntity mensagem(@RequestParam Map<String, String> allParams) {
        allParams.forEach((k, v) -> System.out.println("Chave: " + k + " | Valor: " + v));
        return new ResponseEntity(HttpStatus.OK);
    }
}
