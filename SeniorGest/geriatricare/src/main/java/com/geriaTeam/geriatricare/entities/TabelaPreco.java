package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;

public class TabelaPreco {

    private static final Double PRECO_BASICO = Double.valueOf("99.90");
    private static final Double PRECO_INTERMEDIARIO = Double.valueOf("199.90");
    private static final Double PRECO_AVANCADO = Double.valueOf("299.90");

    public static double obterPreco(TipoPlanoEnums tipoPlano) {
        switch (tipoPlano) {
            case PLANO_BASICO:
                return PRECO_BASICO;
            case PLANO_INTERMEDIARIO:
                return PRECO_INTERMEDIARIO;
            case PLANO_AVANCADO:
                return PRECO_AVANCADO;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        }
    }
}