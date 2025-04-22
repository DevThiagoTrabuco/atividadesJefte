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
    // ✅ Métodos da camada de apresentação
    public void adicionarCondicaoFisica(String nome, String descricao) {
        condicaoFisicaApplication.adicionarCondicaoFisica(nome, descricao);
    }

    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisicaApplication.buscarCondicoesFisicas();
    }

    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        return condicaoFisicaApplication.buscarCondicaoFisicaPorCodigo(id);
    }

    public void removerCondicaoFisica(int id) {
        condicaoFisicaApplication.removerCondicaoFisica(id);
    }

    public void atualizarCondicaoFisica(int id, String novoNome, String novaDescricao) {
        condicaoFisicaApplication.atualizarCondicaoFisica(id, novoNome, novaDescricao);
    }
}
