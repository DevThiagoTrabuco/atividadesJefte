package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PacienteMedicamentoApplication;
import com.geriaTeam.geriatricare.models.domain.PacienteMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteMedicamentoFacade {
    @Autowired
    private PacienteMedicamentoApplication pacienteMedicamentoApplication;

    public List<PacienteMedicamento> buscar() {
        return pacienteMedicamentoApplication.buscar();
    }

    public PacienteMedicamento buscarPorCodigo(int codigo) {
        return pacienteMedicamentoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteMedicamento pacienteMedicamento) {
        pacienteMedicamentoApplication.adicionar(pacienteMedicamento);
    }

    public void atualizar(PacienteMedicamento pacienteMedicamento) {
        pacienteMedicamentoApplication.atualizar(pacienteMedicamento);
    }

    public void remover(int codigo) {
        pacienteMedicamentoApplication.remover(codigo);
    }
}
