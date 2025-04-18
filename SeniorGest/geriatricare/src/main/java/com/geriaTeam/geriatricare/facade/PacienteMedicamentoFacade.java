package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PacienteMedicamentoApplication;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteMedicamentoFacade {
    @Autowired
    private PacienteMedicamentoApplication pacienteMedicamentoApplication;

    public List<PacienteMedicamentoModels> buscar() {
        return pacienteMedicamentoApplication.buscar();
    }

    public PacienteMedicamentoModels buscarPorCodigo(int codigo) {
        return pacienteMedicamentoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoApplication.adicionar(pacienteMedicamentoModels);
    }

    public void atualizar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoApplication.atualizar(pacienteMedicamentoModels);
    }

    public void remover(int codigo) {
        pacienteMedicamentoApplication.remover(codigo);
    }
}
