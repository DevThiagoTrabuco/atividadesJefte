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
                planoBasico.setBeneficio(beneficioPlano.obterBeneficiosPlanoBasico());
                planoBasico.setPreco(tabelaPreco.obterPreco(tipoPlano));
                return planoBasico;
            case PLANO_INTERMEDIARIO:
                PlanoIntermediario planoIntermediario = new PlanoIntermediario();
                planoIntermediario.setBeneficio(beneficioPlano.obterBeneficiosPlanoIntermediario());
                planoIntermediario.setPreco(tabelaPreco.obterPreco(tipoPlano));
                return planoIntermediario;
            case PLANO_AVANCADO:
                PlanoAvancado planoAvancado = new PlanoAvancado();
                planoAvancado.setBeneficio(beneficioPlano.obterBeneficiosPlanoAvancado());
                planoAvancado.setPreco(tabelaPreco.obterPreco(tipoPlano));
                return planoAvancado;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        }
    }
}