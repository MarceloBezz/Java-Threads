package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("Marcelo");
        var conta = new Conta(cliente, new BigDecimal("150"));

        var operacao = new OperacaoSaque(conta, new BigDecimal("150"));
        Thread saqueMarcelo = new Thread(operacao);
        Thread saqueSimultaneo = new Thread(operacao);

        saqueMarcelo.start();
        saqueSimultaneo.start();

        try {
            saqueMarcelo.join();
            saqueSimultaneo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()); // main
        System.out.println("Saldo final: " + conta.getSaldo());

        //Funcionamento sem Thread, uma ação por vez:
        // operacao.executa();
        // operacao.executa();
    }
}
