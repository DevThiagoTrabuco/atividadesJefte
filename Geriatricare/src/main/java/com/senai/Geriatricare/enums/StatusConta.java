package com.senai.Geriatricare.enums;

public enum StatusConta {
    ABERTO("ABERTO"),
    PAGO("PAGO"),
    PENDENTE("PENDENTE"),
    VENCIDO("VENCIDO");

    private final String status;

    StatusConta(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
