package dev.andredeomondes.agenda;

import dev.andredeomondes.agenda.repository.ContatoJsonRepository;
import dev.andredeomondes.agenda.repository.ContatoRepository;
import dev.andredeomondes.agenda.service.AgendaService;
import dev.andredeomondes.agenda.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ContatoRepository repository = new ContatoJsonRepository();
        AgendaService service = new AgendaService(repository);
        ConsoleUI ui = new ConsoleUI();
        ui.exibirSplash();

        boolean rodando = true;

        while (rodando) {
            ui.exibirMenu();
            String opcao = ui.lerEntrada("");
            String id;

            switch (opcao) {
                case "1":
                    id = ui.lerEntrada("ID (ex: db06): ");
                    String nome = ui.lerEntrada("Nome: ");
                    String tel = ui.lerEntrada("Telefone: ");
                    String email = ui.lerEntrada("Email: ");

                    ui.carregar("Registrando contato...");

                    try {
                        service.cadastrarContato(id, nome, tel, email);
                        ui.mensagemSucesso(nome + " registrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        ui.mensagemErro(e.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("\n--- LISTA DE CONTATOS ---");
                    service.listarTodos().forEach(System.out::println);
                    break;

                case "3":
                    id = ui.lerEntrada("Digite o ID para remover: ");
                    service.removerContato(id);
                    System.out.println("🗑️ Contato removido (se existia).");
                    break;

                case "4":
                    rodando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}