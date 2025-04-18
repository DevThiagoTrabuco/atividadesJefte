package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import com.geriaTeam.geriatricare.entities.CondicaoFisica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicaoFisicaApplication {

    private final CondicaoFisica condicaoFisica;
    private final CondicaoFisicaRepository condicaoFisicaRepository;

    @Autowired
    public CondicaoFisicaApplication(CondicaoFisicaRepository condicaoFisicaRepository) {
        this.condicaoFisicaRepository = condicaoFisicaRepository;
        this.condicaoFisica = new CondicaoFisica(condicaoFisicaRepository);
    }

    // Adicionar Condição Física
    public void adicionarCondicaoFisica(String nome, String descricao) {
        condicaoFisica.adicionarCondicaoFisica(nome, descricao);
    }

    // Buscar todas as Condições Físicas
    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisica.buscarCondicoesFisicas();
    }

    // Buscar Condição Física por código
    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        return condicaoFisica.buscarCondicaoFisicaPorCodigo(id);
    }

    // Remover Condição Física
    public void removerCondicaoFisica(int id) {
        condicaoFisica.removerCondicaoFisica(id);
    }

    // Atualizar Condição Física
    public void atualizarCondicaoFisica(int id, String novoNome, String novaDescricao) {
        condicaoFisica.atualizarCondicaoFisica(id, novoNome, novaDescricao);
    }

    // Métodos de repositório (caso queira chamar diretamente)
    public void adicionar(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaRepository.adicionar(condicaoFisicaModels);
    }

    public void atualizar(CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaRepository.atualizar(condicaoFisicaModels);
    }

    public void remover(int codigo) {
        condicaoFisicaRepository.remover(codigo);
    }

    public List<CondicaoFisicaModels> buscar() {
        return condicaoFisicaRepository.buscar();
    }

    public CondicaoFisicaModels buscarPorCodigo(int codigo) {
        return condicaoFisicaRepository.buscarPorCodigo(codigo);
    }
}
