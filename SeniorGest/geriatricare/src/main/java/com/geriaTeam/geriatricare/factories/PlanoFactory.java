package com.geriaTeam.geriatricare.factories;

import com.geriaTeam.geriatricare.entities.*;
import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;

public class PlanoFactory {
    public PlanoInterface criarPlano(TipoPlanoEnums tipoPlano) {
        BeneficioPlano beneficioPlano = new BeneficioPlano();
        TabelaPreco tabelaPreco = new TabelaPreco();
        switch (tipoPlano) {
            case PLANO_BASICO:
                PlanoBasico planoBasico = new PlanoBasico();
                return planoBasico;
            case PLANO_INTERMEDIARIO:
                PlanoIntermediario planoIntermediario = new PlanoIntermediario();
                return planoIntermediario;
            case PLANO_AVANCADO:
                PlanoAvancado planoAvancado = new PlanoAvancado();
                return planoAvancado;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        }
    }
}