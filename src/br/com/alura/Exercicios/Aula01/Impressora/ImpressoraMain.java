package br.com.alura.Exercicios.Aula01.Impressora;

public class ImpressoraMain {
    public static void main(String[] args) {
        //Determinando prioridade entre Threads
        Impressora impressora1 = new Impressora(1);
        Impressora impressora2 = new Impressora(2);

        Thread operacao1 = new Thread(impressora1);
        Thread operacao2 = new Thread(impressora2);

        operacao1.setPriority(1);
        operacao2.setPriority(10);

        operacao1.start();
        operacao2.start();
    }
}
