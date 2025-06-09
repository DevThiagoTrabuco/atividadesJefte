package com.senai.Geriatricare.enums;

public enum Parentesco {
    PAI("Pai"),
    MAE("Mãe"),
    IRMAO("Irmão"),
    IRMA("Irmã"),
    FILHO("Filho"),
    FILHA("Filha"),
    PRIMO("Primo"),
    PRIMA("Prima"),
    OUTRO("Outro");

    private final String parentesco;

    Parentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getParentesco() {
        return parentesco;
    }
}
