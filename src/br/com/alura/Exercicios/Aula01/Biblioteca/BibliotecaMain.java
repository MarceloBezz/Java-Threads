package br.com.alura.Exercicios.Aula01.Biblioteca;

import java.time.LocalDate;

public class BibliotecaMain {
    public static void main(String[] args) {
        //Simulando duas requisições simultâneas na reserva de um livro
        Livro livro = new Livro("Codando em Java", "Marcelo", LocalDate.now());
        OperacaoReserva op = new OperacaoReserva(livro);

        Thread reservaJoao = new Thread(op, "João");
        Thread reservaMaria = new Thread(op, "Maria");

        reservaJoao.start();
        reservaMaria.start();

        try {
            reservaMaria.join();
            reservaJoao.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //RESULTADO: O livro é reservado para uma só pessoa
        System.out.println("Reservas finalizadas!");
    }
}
