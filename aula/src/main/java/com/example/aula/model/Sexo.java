package com.example.aula.model;

public enum Sexo {
    masculino("masculino"),
    feminino("feminino");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}