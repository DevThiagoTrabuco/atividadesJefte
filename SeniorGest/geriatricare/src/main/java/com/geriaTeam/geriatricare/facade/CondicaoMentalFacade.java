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
    // Métodos da fachada que delegam chamadas para a aplicação
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

}
