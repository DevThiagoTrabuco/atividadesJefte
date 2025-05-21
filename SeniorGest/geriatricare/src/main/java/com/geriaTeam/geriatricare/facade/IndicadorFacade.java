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

    public List<IndicadorModels> buscar() {
        return indicadorApplication.buscar();
    }

    public IndicadorModels buscarPorCodigo(int codigo) {
        return indicadorApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(IndicadorModels indicadorModels) {
        indicadorApplication.adicionar(indicadorModels);
    }

    public void atualizar(IndicadorModels indicadorModels) {
        indicadorApplication.atualizar(indicadorModels);
    }

    public void remover(int codigo) {
        indicadorApplication.remover(codigo);
    }
}
