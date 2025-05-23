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

    public void adicionarCondicaoFisica(CondicaoFisicaModels condicaoFisicaModels) {

        condicaoFisicaRepository.adicionarCondicaoFisica(condicaoFisicaModels);
    }

    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisicaRepository.buscarCondicaoFisica();
    }

    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarCondicaoFisicaId(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        return condicaoFisica;
    }

    public List<CondicaoFisicaModels> buscarCondicaoFisicaPorNome(String nome) {
        List<CondicaoFisicaModels> condicaoFisica = condicaoFisicaRepository.buscarCondicaoFisicaPorNome(nome);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o nome: " + nome);
        }
        return condicaoFisica;
    }

    public void removerCondicaoFisica(int id) {
        CondicaoFisicaModels condicaoFisica = condicaoFisicaRepository.buscarCondicaoFisicaId(id);
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        condicaoFisicaRepository.removerCondicaoFisica(id);
    }

    public void atualizarCondicaoFisica(int id, CondicaoFisicaModels condicaoAtualizada) {
        CondicaoFisicaModels condicaoExistente = condicaoFisicaRepository.buscarCondicaoFisicaId(id);

        if (condicaoExistente == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }

        if (condicaoAtualizada.getNome() != null) {
            condicaoExistente.setNome(condicaoAtualizada.getNome());
        }

        if (condicaoAtualizada.getDescricao() != null) {
            condicaoExistente.setDescricao(condicaoAtualizada.getDescricao());
        }

        condicaoFisicaRepository.atualizarCondicaoFisica(condicaoExistente);
    }

}
