package com.geriaTeam.geriatricare.factories;

import com.geriaTeam.geriatricare.entities.Plano;
import com.geriaTeam.geriatricare.entities.PlanoInterface;
import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;

public class PlanoFactory {
    public PlanoInterface criarPlano(TipoPlanoEnums tipoPlano) {
        if (tipoPlano == null) {
            throw new IllegalArgumentException("Tipo de plano não pode ser nulo.");
        }
        return new Plano(tipoPlano);
    }
}