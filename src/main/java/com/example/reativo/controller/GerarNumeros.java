package com.example.reativo.controller;

import com.example.reativo.model.ConsoleModel;

import java.time.LocalDateTime;

public class GerarNumeros {
    public ConsoleModel Thread1(){
        ConsoleModel c = new ConsoleModel();
        c.setMensagem(LocalDateTime.now().toString());
        return c;
    }
}