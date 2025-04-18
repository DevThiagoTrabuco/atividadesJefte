package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.CondicaoMentalApplication;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CondicaoMentalFacade {

    private final CondicaoMentalApplication condicaoMentalApplication;

    @Autowired
    public CondicaoMentalFacade(CondicaoMentalApplication condicaoMentalApplication) {
        this.condicaoMentalApplication = condicaoMentalApplication;
    }

    public List<CondicaoMentalModels> buscar() {
        return condicaoMentalApplication.buscar();
    }

    public CondicaoMentalModels buscarPorCodigo(int codigo) {
        return condicaoMentalApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(CondicaoMentalModels condicaoMentalModels) {
        condicaoMentalApplication.adicionar(condicaoMentalModels);
    }

    public void atualizar(CondicaoMentalModels condicaoMentalModels) {
        condicaoMentalApplication.atualizar(condicaoMentalModels);
    }

    public void remover(int codigo) {
        condicaoMentalApplication.remover(codigo);
    }

    // Complemento com os métodos restantes da Application
    public void adicionarCondicaoMental(String nome, String descricao) {
        condicaoMentalApplication.adicionarCondicaoMental(nome, descricao);
    }

    public void removerCondicaoMental(int codigo) {
        condicaoMentalApplication.removerCondicaoMental(codigo);
    }

    public List<CondicaoMentalModels> buscarTodasCondicoes() {
        return condicaoMentalApplication.buscarTodasCondicoes();
    }

    public void atualizarCondicaoMental(int codigo, String nome, String descricao) {
        condicaoMentalApplication.atualizarCondicaoMental(codigo, nome, descricao);
    }

    public boolean verificarCondicaoMental(int codigo) {
        return condicaoMentalApplication.verificarCondicaoMental(codigo);
    }
}
