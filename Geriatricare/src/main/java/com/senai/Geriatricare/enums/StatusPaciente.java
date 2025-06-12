package com.senai.Geriatricare.enums;

public enum StatusPaciente {
    ATIVO("ATIVO"),
    INATIVO("INATIVO"),
    EM_TRATAMENTO("EM TRATAMENTO"),
    RECUPERADO("RECUPERADO"),
    FALECIDO("FALECIDO");

    private final String status;

    StatusPaciente(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
