package dev.andredeomondes.agenda.model;

import java.util.Objects;

public class Contato {
    private final String id;
    private final String nome;
    private final String telefone;
    private final String email;

    private Contato(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.telefone = builder.telefone;
        this.email = builder.email;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private String id;
        private String nome;
        private String telefone;
        private String email;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Contato build() {
            return new Contato(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
