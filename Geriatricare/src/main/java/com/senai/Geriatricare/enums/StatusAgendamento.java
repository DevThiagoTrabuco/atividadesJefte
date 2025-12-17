package com.senai.Geriatricare.enums;

public enum StatusAgendamento {
    ABERTO("ABERTO"),
    FECHADO("FECHADO");

    private final String status;

    StatusAgendamento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
