package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.IndicadorApplication;
import com.geriaTeam.geriatricare.models.domain.Indicador;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class IndicadorFacade {
    @Autowired
    private IndicadorApplication indicadorApplication;

    public List<Indicador> buscar() {
        return indicadorApplication.buscar();
    }

    public Indicador buscarPorCodigo(int codigo) {
        return indicadorApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(Indicador indicador) {
        indicadorApplication.adicionar(indicador);
    }

    public void atualizar(Indicador indicador) {
        indicadorApplication.atualizar(indicador);
    }

    public void remover(int codigo) {
        indicadorApplication.remover(codigo);
    }
}
