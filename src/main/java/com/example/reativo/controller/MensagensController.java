package com.example.reativo.controller;

import static com.example.reativo.controller.SSEController.MSG_T1;

public class MensagensController extends Thread {
    @Override
    public void run() {
        try {
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
        } catch (Exception ignored) {
        } finally {
            Thread.currentThread().interrupt();
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
