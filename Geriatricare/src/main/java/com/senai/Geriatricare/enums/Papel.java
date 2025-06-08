package com.senai.Geriatricare.enums;

public enum Papel {
    ADMIN("ROLE_ADMIN"),
    CLIENTE("ROLE_CLIENTE"),
    FUNCIONARIO("ROLE_FUNCIONARIO"),
    FAMILIAR("ROLE_FAMILIAR");

    private final String papel;

    Papel(String papel) {
        this.papel = papel;
    }

    public String getPapel() {
        return papel;
    }
}
