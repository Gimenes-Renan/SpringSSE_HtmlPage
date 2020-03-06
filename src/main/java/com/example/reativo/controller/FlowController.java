package com.example.reativo.controller;

import org.json.simple.JSONObject;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.net.URI;

import static com.example.reativo.controller.SSEController.MSG_T1;
import static com.example.reativo.controller.SSEController.MSG_T3;

@Service
@EnableScheduling
public class FlowController {
    JSONObject jsonObject = new JSONObject();

    @EventListener(ApplicationReadyEvent.class)
    public void startUp() {
        executar();
    }

    @Scheduled(fixedDelay = 1)
    public void eventoJson() {
        jsonObject.put("nome", "Renan");
        jsonObject.put("sobrenome", "Musardo");
        MSG_T3 = jsonObject.toJSONString();
        espera(1000);
        jsonObject.put("nome", "Juliana");
        jsonObject.put("sobrenome", "Gimenes");
        MSG_T3 = jsonObject.toJSONString();
        espera(1000);
    }

    private void executar() {
        System.out.println("Iniciou FlowController - Executar");
        abrirNavegador();
        while (true) {
            MSG_T1 = "Execucao Iniciada";
            espera(2000);
            MSG_T1 = "Execucao Em andamento";
            espera(5000);
            MSG_T1 = "Execucao Finalizada";
            espera(2000);
            MSG_T1 = "Buscando novos casos";
            espera(2000);
        }
    }

    private void abrirNavegador() {
        System.out.println("ABRINDO NAVEGADOR");
        String browserPath = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        String url = "http://localhost:8080/";
        try {
            String[] b = {browserPath, url};
            Runtime.getRuntime().exec(b);
        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("IMPOSSIVEL ABRIR O NAVEGADOR");
        }
    }

    private void espera(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
