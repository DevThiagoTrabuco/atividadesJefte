package com.senai.Geriatricare.enums;

public enum Posologia {
    UMA_VEZ_AO_DIA("1x ao dia"),
    DUAS_VEZES_AO_DIA("2x ao dia"),
    TRES_VEZES_AO_DIA("3x ao dia"),
    DE_6_EM_6_HORAS("A cada 6h"),
    DE_8_EM_8_HORAS("A cada 8h"),
    DE_12_EM_12_HORAS("A cada 12h"),
    DE_24_EM_24_HORAS("A cada 24h"),
    EMERGENCIAL("Uso emergencial"),
    USO_CONTINUO("Uso contínuo"),
    USO_UNICO("Dose única"),
    SEM_INSTRUCAO("Sem instrução específica");

    private final String descricao;

    Posologia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
