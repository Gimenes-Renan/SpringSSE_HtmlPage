package com.example.reativo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import static com.example.reativo.controller.SSEController.MSG_T1;
import static com.example.reativo.controller.SSEController.MSG_T2;

@Service
public class FlowController {

    @EventListener(ApplicationReadyEvent.class)
    public void startUp() {
        executar();
    }

    private void executar() {
        System.out.println("Iniciou FlowController - Executar");
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

    private void espera(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }
}
