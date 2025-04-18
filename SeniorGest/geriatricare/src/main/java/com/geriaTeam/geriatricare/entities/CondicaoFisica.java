package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CondicaoFisica {

    private int id;
    private String nome;
    private String descricao;

    public CondicaoFisica(CondicaoFisicaRepository condicaoFisicaRepository) {
        this.condicaoFisicaRepository = condicaoFisicaRepository;
    }

    // O repositório precisa ser passado para cada função
    private CondicaoFisicaRepository condicaoFisicaRepository;

    // 1. Função para adicionar uma Condição Física
    public void adicionarCondicaoFisica(String nome, String descricao) {
        CondicaoFisicaModels condicaoFisicaModels = new CondicaoFisicaModels();
        condicaoFisicaModels.setNome(nome);
        condicaoFisicaModels.setDescricao(descricao);

        // Adicionando no repositório
        condicaoFisicaRepository.adicionar(condicaoFisicaModels);
    }

    // 2. Função para buscar todas as Condições Físicas
    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisicaRepository.buscar();
    }

    // 3. Função para buscar uma Condição Física por código (ID)
    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        return condicaoFisica;
    }

    // 4. Função para remover uma Condição Física pelo ID
    public void removerCondicaoFisica(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarPorCodigo(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        condicaoFisicaRepository.remover(id);
    }

    // 5. Função para atualizar uma Condição Física
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
