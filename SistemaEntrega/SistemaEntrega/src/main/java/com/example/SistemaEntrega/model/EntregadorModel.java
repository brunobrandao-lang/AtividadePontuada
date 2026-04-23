package com.example.SistemaEntrega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntregadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerar um id automaticamente
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String placa;
    private String tipoVeiculo;
    private String endereco;

    public EntregadorModel() {
    }

    public EntregadorModel(Long id, String nome, String email, String telefone, String placa, String tipoVeiculo, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        this.endereco = endereco;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
