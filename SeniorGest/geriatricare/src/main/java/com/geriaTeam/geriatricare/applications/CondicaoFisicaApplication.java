package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoFisicaRepository;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
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
