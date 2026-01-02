package dev.andredeomondes.agenda.service;

import dev.andredeomondes.agenda.model.Contato;
import dev.andredeomondes.agenda.repository.ContatoRepository;

import java.util.List;
import java.util.Objects;

public class AgendaService {

    private final ContatoRepository repository;
    public AgendaService(ContatoRepository repository) {
        this.repository = Objects.requireNonNull(repository, "O repositório não pode ser nulo");
    }

    public void cadastrarContato(String id,String nome, String telefone, String email) {
        validarDados(id, nome, telefone, email);

        Contato novoContato = new Contato.Builder()
                .id(id)
                .nome(nome)
                .telefone(telefone)
                .email(email)
                .build();

        repository.salvar(novoContato);
    }

    public List<Contato> listarTodos() {
        return repository.listarTodos();
    }

    public void removerContato(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID inválido para remoção.");
        }
        repository.deletarPorId(id);
    }

    private void validarDados(String id,String nome, String telefone, String email) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do contato é obrigatório.");
        }
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("O telefone do contato é obrigatório.");
        }
        if (email != null && !email.isBlank() && !email.contains("@") && !email.contains(".")) {
            throw new IllegalArgumentException("O email fornecido é inválido.");
        }
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O ID do contato é obrigatório.");
        }
    }
}