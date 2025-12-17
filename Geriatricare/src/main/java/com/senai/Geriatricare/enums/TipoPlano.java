package com.senai.Geriatricare.enums;

public enum TipoPlano {
    MENSAL("MENSAL"),
    TRIMESTRAL("TRIMESTRAL"),
    SEMESTRAL("SEMESTRAL"),
    ANUAL("ANUAL");

    private final String descricao;

    TipoPlano(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
