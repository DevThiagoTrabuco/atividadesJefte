package com.senai.Geriatricare.enums;

public enum Papel {
    ADMIN("ADMIN"),
    CLIENTE("CLIENTE"),
    FUNCIONARIO("FUNCIONARIO"),
    ATIVADO("ATIVADO"),
    DESATIVADO("DESATIVADO");

    private final String papel;

    Papel(String papel) {
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }
}
