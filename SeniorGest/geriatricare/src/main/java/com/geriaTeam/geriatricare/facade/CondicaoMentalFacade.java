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
}
