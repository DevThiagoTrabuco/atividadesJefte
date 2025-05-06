package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.IndicadorApplication;
import com.geriaTeam.geriatricare.models.IndicadorModels;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IndicadorFacade {
    @Autowired
    private IndicadorApplication indicadorApplication;

    public List<IndicadorModels> buscarTodosIndicador() {
        return indicadorApplication.buscarTodosIndicador();
    }

    public IndicadorModels buscarIndicadorId(int codigo) {
        return indicadorApplication.buscarIndicadorId(codigo);
    }

    public void adicionarIndicador(IndicadorModels indicadorModels) {
        indicadorApplication.adicionarIndicador(indicadorModels);
    }

    public void atualizarIndicador(IndicadorModels indicadorModels) {
        indicadorApplication.atualizarIndicador(indicadorModels);
    }

    public void removerIndicador(int codigo) {
        indicadorApplication.removerIndicador(codigo);
    }
}
