package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PacienteFamiliarApplication;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteFamiliarFacade {
    @Autowired
    private PacienteFamiliarApplication pacienteFamiliarApplication;

    public List<PacienteFamiliarModels> buscar() {
        return pacienteFamiliarApplication.buscar();
    }

    public PacienteFamiliarModels buscarPorCodigo(int codigo) {
        return pacienteFamiliarApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarApplication.adicionar(pacienteFamiliarModels);
    }

    public void atualizar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarApplication.atualizar(pacienteFamiliarModels);
    }

    public void remover(int codigo) {
        pacienteFamiliarApplication.remover(codigo);
    }
}
