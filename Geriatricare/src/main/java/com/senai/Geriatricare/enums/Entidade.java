package com.senai.Geriatricare.enums;

public enum Entidade {
    PACIENTE("Paciente"),
    FUNCIONARIO("Funcionário"),
    MEDICAMENTO("Medicamento"),
    PRESCRICAO("Prescrição");

    private final String entidade;

    Entidade(String entidade) {
        this.entidade = entidade;
    }

    public String getEntidade() {
        return entidade;
    }
}
