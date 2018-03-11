package com.agateownz.testapplication.model;

import java.io.Serializable;

/**
 * Created by luisg on 04/03/2018.
 */

public class Pessoa implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String observacao;
    private Long dataNascimento;

    public Pessoa() {
        nome = "";
        email = "";
        telefone = "";
        endereco = "";
        observacao = "";
    }

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.id = -1L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Long dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void validar() throws PessoaException {
        if ("".equals(nome)) {
            throw new PessoaException("O nome é obrigatório.");
        }

        if ("".equals(email)) {
            throw new PessoaException("O email é obrigatório.");
        }

        if (email != null && !email.contains("@")) {
            throw new PessoaException("O email informado é inválido.");
        }

        if ("".equals(telefone)) {
            throw new PessoaException("O telefone é obrigatório.");
        }

        if ("".equals(endereco)) {
            throw new PessoaException("O endereço é obrigatório.");
        }

        if (dataNascimento == null) {
            throw new PessoaException("A data de nascimento é obrigatória.");
        }
    }
}
