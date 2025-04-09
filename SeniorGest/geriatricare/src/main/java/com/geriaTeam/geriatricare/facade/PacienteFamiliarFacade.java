package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PacienteFamiliarApplication;
import com.geriaTeam.geriatricare.models.domain.PacienteFamiliar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteFamiliarFacade {
    @Autowired
    private PacienteFamiliarApplication pacienteFamiliarApplication;

    public List<PacienteFamiliar> buscar() {
        return pacienteFamiliarApplication.buscar();
    }

    public PacienteFamiliar buscarPorCodigo(int codigo) {
        return pacienteFamiliarApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteFamiliar pacienteFamiliar) {
        pacienteFamiliarApplication.adicionar(pacienteFamiliar);
    }

    public void atualizar(PacienteFamiliar pacienteFamiliar) {
        pacienteFamiliarApplication.atualizar(pacienteFamiliar);
    }

    public void remover(int codigo) {
        pacienteFamiliarApplication.remover(codigo);
    }
}
