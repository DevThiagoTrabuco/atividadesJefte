package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.HistoricoApplication;
import com.geriaTeam.geriatricare.models.HistoricoModels;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HistoricoFacade {
    @Autowired
    private HistoricoApplication historicoApplication;

    public List<HistoricoModels> buscar() {
        return historicoApplication.buscar();
    }

    public HistoricoModels buscarPorCodigo(int codigo) {
        return historicoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(HistoricoModels historicoModels) {
        historicoApplication.adicionar(historicoModels);
    }

    public void atualizar(HistoricoModels historicoModels) {
        historicoApplication.atualizar(historicoModels);
    }

    public void remover(int codigo) {
        historicoApplication.remover(codigo);
    }
}
