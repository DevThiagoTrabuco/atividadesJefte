package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.HistoricoApplication;
import com.geriaTeam.geriatricare.models.domain.Historico;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HistoricoFacade {
    @Autowired
    private HistoricoApplication historicoApplication;

    public List<Historico> buscar() {
        return historicoApplication.buscar();
    }

    public Historico buscarPorCodigo(int codigo) {
        return historicoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Historico historico) {
        historicoApplication.adicionar(historico);
    }

    public void atualizar(int codigo, Historico historico) {
        historicoApplication.atualizar(codigo, historico);
    }

    public void remover(int codigo) {
        historicoApplication.remover(codigo);
    }
}
