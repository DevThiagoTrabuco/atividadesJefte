package com.geriaTeam.geriatricare.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.models.domain.Plano;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PlanoFacade {
    @Autowired
    private PlanoApplication planoApplication;

    public List<Plano> buscar() {
        return planoApplication.buscar();
    }

    public Plano buscarPorCodigo(UUID codigo) {
        return planoApplication.buscarPorCodigo(codigo);
    }

    public void cadastrar(Plano plano) {
        planoApplication.cadastrar(plano);
    }

    public void atualizar(UUID codigo, Plano plano) {
        planoApplication.atualizar(codigo, plano);
    }

    public void remover(UUID codigo, Plano plano) {
        planoApplication.remover(codigo, plano);
    }
}
