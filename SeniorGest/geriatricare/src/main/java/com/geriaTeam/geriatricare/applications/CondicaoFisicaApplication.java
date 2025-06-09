package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CondicaoFisicaApplication {

    private final CondicaoFisicaRepository condicaoFisicaRepository;

    @Autowired
    public CondicaoFisicaApplication(CondicaoFisicaRepository condicaoFisicaRepository) {
        this.condicaoFisicaRepository = condicaoFisicaRepository;
    }

    public void adicionarCondicaoFisica(String nome, String descricao) {
        CondicaoFisicaModels condicaoFisicaModels = new CondicaoFisicaModels();
        condicaoFisicaModels.setNome(nome);
        condicaoFisicaModels.setDescricao(descricao);
        condicaoFisicaRepository.adicionar(condicaoFisicaModels);
    }

    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisicaRepository.buscar();
    }

    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        return condicaoFisica;
    }

    public void removerCondicaoFisica(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        condicaoFisicaRepository.remover(id);
    }

    public void atualizarCondicaoFisica(int id, String novoNome, String novaDescricao) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        condicaoFisica.setNome(novoNome);
        condicaoFisica.setDescricao(novaDescricao);

        condicaoFisicaRepository.atualizar(condicaoFisica);
    }
}
