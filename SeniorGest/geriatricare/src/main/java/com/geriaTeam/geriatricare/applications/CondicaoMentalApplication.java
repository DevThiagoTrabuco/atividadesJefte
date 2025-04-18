package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicaoMentalApplication {

    private final CondicaoMentalRepository condicaoMentalRepository;

    @Autowired
    public CondicaoMentalApplication(CondicaoMentalRepository condicaoMentalRepository) {
        this.condicaoMentalRepository = condicaoMentalRepository;
    }

    public void adicionar(CondicaoMentalModels condicaoMentalModels) {
        this.condicaoMentalRepository.adicionar(condicaoMentalModels);
    }

    public void atualizar(CondicaoMentalModels condicaoMentalModels) {
        this.condicaoMentalRepository.atualizar(condicaoMentalModels);
    }

    public void remover(int codigo) {
        this.condicaoMentalRepository.remover(codigo);
    }

    public List<CondicaoMentalModels> buscar() {
        return this.condicaoMentalRepository.buscar();
    }

    public CondicaoMentalModels buscarPorCodigo(int codigo) {
        return this.condicaoMentalRepository.buscarPorCodigo(codigo);
    }
}
