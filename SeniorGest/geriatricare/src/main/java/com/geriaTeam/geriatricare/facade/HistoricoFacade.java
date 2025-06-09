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

    public List<HistoricoModels> buscarHistorico() {
        return historicoApplication.buscarHistorico();
    }

    public HistoricoModels buscarHistoricoId(int codigo) {
        return historicoApplication.buscarHistoricoId(codigo);
    }

    public void adicionarHistorico(HistoricoModels historicoModels) {
        historicoApplication.adicionarHistorico(historicoModels);
    }

    public void atualizarHistorico(HistoricoModels historicoModels) {
        historicoApplication.atualizarHistorico(historicoModels);
    }

    public void removerHistorico(int codigo) {
        historicoApplication.removerHistorico(codigo);
    }
}
