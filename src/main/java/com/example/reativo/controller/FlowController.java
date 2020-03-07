package com.example.reativo.controller;

import org.json.simple.JSONObject;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static com.example.reativo.controller.SSEController.*;

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

    @Scheduled(fixedDelay = 1)
    public void eventoObj() {
        consoleModel.setMensagem("Renan");
        espera(200);
        consoleModel.setMensagem("Musardo");
        espera(200);
    }

    private void executar() {
        abrirNavegador();
        System.out.println("Abrindo serviço de Mensagens");
        MensagensController msg1 = new MensagensController();
        msg1.start();
        System.out.println("Serviço de Mensagens inicializado");
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
