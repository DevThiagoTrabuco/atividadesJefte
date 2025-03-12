package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.models.domain.Familiar;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FamiliarFacade {
    @Autowired
    private FamiliarApplication familiarApplication;

    public List<Familiar> buscar() {
        return familiarApplication.buscar();
    }

    public Familiar buscarPorCodigo(UUID codigo) {
        return familiarApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Familiar familiar) {
        familiarApplication.cadastrar(familiar);
    }

    public void atualizar(UUID codigo, Familiar familiar) {
        familiarApplication.atualizar(codigo, familiar);
    }

    public void remover(UUID codigo, Familiar familiar) {
        familiarApplication.remover(codigo, familiar);
    }
}