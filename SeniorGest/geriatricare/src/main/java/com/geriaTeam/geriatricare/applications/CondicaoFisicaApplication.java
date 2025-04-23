package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import com.geriaTeam.geriatricare.entities.Paciente;
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

    public void adicionarCondicaoFisica(String nome, String descricao) {
        CondicaoFisicaModels condicaoFisicaModels = new condicaoFisicaModels();
        condicaoFisicaModels.setNome(nome);
        condicaoFisicaModels.setDescricao(descricao);
        condicaoFisicaRepository.adicionar(condicaoFisicaModels);
    }

    public List<CondicaoFisicaModels> buscarCondicoesFisicas() {
        return condicaoFisicaRepository.buscar();
    }

    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(int id) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
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
        if (!validarDescricao(novaDescricao)) {
            throw new IllegalArgumentException("Descrição inválida: " + novaDescricao);
        }
        if (!validarNome(novoNome)) {
            throw new IllegalArgumentException("Nome inválido: " + novoNome);
        }
        if (condicaoFisica == null) {
            throw new EntityNotFoundException("Condição Física não encontrada para o ID: " + id);
        }
        condicaoFisica.setNome(novoNome);
        condicaoFisica.setDescricao(novaDescricao);

        condicaoFisicaRepository.atualizar(condicaoFisica);
    }

    public static boolean validarId(int id) {
        CondicaoFisica condicaoFisica = new CondicaoFisica();
        return condicaoFisica.validarId(id);
    }

    public static boolean validarNome(String nome) {
        CondicaoFisica condicaoFisica = new CondicaoFisica();
        return condicaoFisica.validarNome(nome);
    }

    public static boolean validarDescricao(String descricao) {
        CondicaoFisica condicaoFisica = new CondicaoFisica();
        return condicaoFisica.validarDescricao(descricao);
    }
}
