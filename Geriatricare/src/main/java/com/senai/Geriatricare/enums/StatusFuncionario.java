package com.senai.Geriatricare.enums;

public enum StatusFuncionario {
    ATIVO("ATIVO"),
    INATIVO("INATIVO");

    private final String status;

    StatusFuncionario(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
