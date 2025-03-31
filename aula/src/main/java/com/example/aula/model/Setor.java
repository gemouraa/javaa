package com.example.aula.model;

public enum Setor {
        SAUDE("saude"),
        JURIDICO("juridico"),
        ENGENHARIA("engenharia");

        private final String descricao;

        Setor(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

