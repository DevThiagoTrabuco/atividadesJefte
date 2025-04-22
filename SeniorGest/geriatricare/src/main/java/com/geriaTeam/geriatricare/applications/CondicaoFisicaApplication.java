package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import com.geriaTeam.geriatricare.entities.CondicaoFisica;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicaoFisicaApplication {

    private final CondicaoFisicaRepository condicaoFisicaRepository;

    public CondicaoFisicaApplication(CondicaoFisicaRepository condicaoFisicaRepository) {
        this.condicaoFisicaRepository = condicaoFisicaRepository;
    }

    // Adicionar Condição Física
    public void adicionarCondicaoFisica(String nome, String descricao) {
        CondicaoFisicaModels condicaoFisicaModels = new CondicaoFisicaModels();
        condicaoFisicaModels.setNome(nome);
        condicaoFisicaModels.setDescricao(descricao);

        condicaoFisicaRepository.adicionar(condicaoFisicaModels);
    }

    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisicaRepository.buscar();
    }
    // Buscar Condição Física por código
    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        return condicaoFisica;
    }

    // Remover Condição Física
    public void removerCondicaoFisica(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        condicaoFisicaRepository.remover(id);
    }

    // Atualizar Condição Física
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
