package com.senai.Geriatricare.enums;

public enum StatusMedicamento {
    DISPONIVEL("DISPONIVEL"),
    INDISPONIVEL("INDISPONIVEL"),
    EM_FALTA("EM FALTA");

    private final String status;

    StatusMedicamento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
