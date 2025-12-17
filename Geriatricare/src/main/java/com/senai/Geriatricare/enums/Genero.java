package com.senai.Geriatricare.enums;

public enum Genero {
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    OUTRO("OUTRO"); // Acredito que seja desnecessário

    private final String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
}
