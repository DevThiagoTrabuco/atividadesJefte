package com.senai.Geriatricare.enums;

public enum TipoConta {
    LUZ("Luz"),
    AGUA("Água"),
    TELEFONE("Telefone"),
    INTERNET("Internet");

    private final String tipo;

    TipoConta(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
