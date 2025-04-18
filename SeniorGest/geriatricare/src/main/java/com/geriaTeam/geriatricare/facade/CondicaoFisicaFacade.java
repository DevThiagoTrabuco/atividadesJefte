package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.CondicaoFisicaApplication;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CondicaoFisicaFacade {
    @Autowired
    private CondicaoFisicaApplication condicaoFisicaApplication;

    public List<CondicaoFisicaModels> buscar() {
        return condicaoFisicaApplication.buscar();
    }

    public CondicaoFisicaModels buscarPorCodigo(int codigo) {
        return condicaoFisicaApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaApplication.adicionar(condicaoFisicaModels);
    }

    public void atualizar(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaApplication.atualizar(condicaoFisicaModels);
    }

    public void remover(int codigo) {
        condicaoFisicaApplication.remover(codigo);
    }
}
