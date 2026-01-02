package dev.andredeomondes.agenda.repository;

import dev.andredeomondes.agenda.model.Contato;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository {
    void salvar(Contato contato);

    List<Contato> listarTodos();

    Optional<Contato> buscarPorId(String id);

    void deletarPorId(String id);

}
