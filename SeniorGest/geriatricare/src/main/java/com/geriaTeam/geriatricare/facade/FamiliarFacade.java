package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FamiliarApplication;
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

    public Familiar buscarPorCodigo(int codigo) {
        return familiarApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Familiar familiar) {
        familiarApplication.adicionar(familiar);
    }

    public void atualizar(Familiar familiar) {
        familiarApplication.atualizar(familiar);
    }

    public void remover(int codigo) {
        familiarApplication.remover(codigo);
    }
}
