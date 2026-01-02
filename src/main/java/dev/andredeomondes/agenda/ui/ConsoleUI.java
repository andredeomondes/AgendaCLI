package dev.andredeomondes.agenda.ui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String VERMELHO = "\u001B[31m";
    private static final String AMARELO = "\u001B[33m";
    private static final String CIANO = "\u001B[36m";
    private static final String NEGRITO = "\u001B[1m";
    private static final String ITALICO = "\u001B[3m";
    public void exibirSplash() {
        String logo = CIANO + """
           ___                            _             ___  _     ___ 
          / _ \\  __ _   ___  _ __    __| |  __ _     / __|| |   |_ _|
         | (_) |/ _` | / _ \\| '_ \\  / _` | / _` |   | (__ | |__  | | 
          \\___/ \\__, | \\___/|_| |_| \\__,_| \\__,_|    \\___||____||___|
                |___/                                                 
        """ + RESET + AMARELO + ITALICO + """
                  Powered by Effective Java & Jackson JSON
        """ + RESET;

        System.out.println(logo);
        carregar("Carregando módulos do sistema");
    }
    public void exibirMenu() {
        System.out.println("\n" + CIANO + NEGRITO + "=== 📒 AGENDA JAVA EFETIVA ===" + RESET);
        System.out.println(CIANO + "1." + RESET + " Adicionar Contato");
        System.out.println(CIANO + "2." + RESET + " Listar Contatos");
        System.out.println(CIANO + "3." + RESET + " Remover Contato");
        System.out.println(CIANO + "4." + RESET + " Sair");
        System.out.print(NEGRITO + "\n➤ Escolha uma opção: " + RESET);
    }

    public String lerEntrada(String label) {
        System.out.print(AMARELO + "❓ " + label + RESET + ITALICO);
        String entrada = scanner.nextLine();
        System.out.print(RESET); // Reseta o itálico após a leitura
        return entrada;
    }

    public void mensagemSucesso(String msg) {
        System.out.println(VERDE + "✔ " + NEGRITO + msg + RESET);
    }

    public void mensagemErro(String msg) {
        System.out.println(VERMELHO + "✘ " + NEGRITO + "ERRO: " + RESET + VERMELHO + msg + RESET);
    }

    public void mensagemAviso(String msg) {
        System.out.println(AMARELO + "⚠ " + ITALICO + msg + RESET);
    }

    public void carregar(String acao) {
        System.out.print(CIANO + "⏳ " + acao);
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(400); // Delay de 400ms
                System.out.print(".");
            }
            System.out.println(RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}