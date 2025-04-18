package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FamiliarApplication;
import com.geriaTeam.geriatricare.models.FamiliarModels;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FamiliarFacade {
    @Autowired
    private FamiliarApplication familiarApplication;

    public List<FamiliarModels> buscar() {
        return familiarApplication.buscar();
    }

    public FamiliarModels buscarPorCodigo(int codigo) {
        return familiarApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(FamiliarModels familiarModels) {
        familiarApplication.adicionar(familiarModels);
    }

    public void atualizar(FamiliarModels familiarModels) {
        familiarApplication.atualizar(familiarModels);
    }

    public void remover(int codigo) {
        familiarApplication.remover(codigo);
    }
}
