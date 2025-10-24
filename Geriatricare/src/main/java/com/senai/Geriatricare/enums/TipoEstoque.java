package com.senai.Geriatricare.enums;

public enum TipoEstoque {
    PACIENTE("paciente"),
    INTERNO("interno");

    private final String tipo;

    TipoEstoque(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
