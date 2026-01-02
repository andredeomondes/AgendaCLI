package dev.andredeomondes.agenda.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.andredeomondes.agenda.model.Contato;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ContatoJsonRepository implements ContatoRepository {

    private final File arquivo = new File("src/main/resources/database.json");
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void salvar(Contato contato) {
        List<Contato> contatos = new ArrayList<>(listarTodos());
        contatos.add(contato);
        escreverNoArquivo(contatos);
    }

    @Override
    public List<Contato> listarTodos() {
        if (!arquivo.exists()) {
            return Collections.emptyList();
        }

        try {
            return mapper.readValue(arquivo, new TypeReference<List<Contato>>() {
            });
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Contato> buscarPorId(String id) {
        return listarTodos().stream()
                .filter(contato -> contato.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deletarPorId(String id) {
        List<Contato> listaOriginal = listarTodos();

        List<Contato> listaAtualizada = listaOriginal.stream()
                .filter(contato -> !contato.getId().equals(id))
                .collect(Collectors.toList());

        if (listaAtualizada.size() < listaOriginal.size()) {
            escreverNoArquivo(listaAtualizada);
        }
    }

    private void escreverNoArquivo(List<Contato> contatos) {
        try {
            mapper.writeValue(arquivo, contatos);
        } catch (IOException e) {
            throw new RuntimeException("Falha técnica ao acessar o arquivo de contatos.", e);
        }
    }
}