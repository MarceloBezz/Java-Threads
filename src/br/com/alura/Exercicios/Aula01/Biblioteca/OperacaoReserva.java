package br.com.alura.Exercicios.Aula01.Biblioteca;

public class OperacaoReserva implements Runnable {

    private Livro livro;

    public OperacaoReserva(Livro livro) {
        this.livro = livro;
    }

    private synchronized void reservarLivro() {
        System.out.println("Iniciando reserva");
        if (livro.getReservado()) {
            System.out.println("O livro já foi reservado, " + Thread.currentThread().getName() + "!");
        } else {
            livro.reservar();
            System.out.println(
                    "Reserva efetuada com sucesso! Aproveite o livro, " + Thread.currentThread().getName() + "!");
        }
    }

    @Override
    public void run() {
        reservarLivro();
    }

}
