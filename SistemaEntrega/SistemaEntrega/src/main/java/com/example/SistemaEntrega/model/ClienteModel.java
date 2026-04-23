package com.example.SistemaEntrega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerar um id automaticamente
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String formaPagamento;
    private String endereco;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nome, String email, String telefone, String formaPagamento, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.formaPagamento = formaPagamento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}