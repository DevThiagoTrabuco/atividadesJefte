package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import com.geriaTeam.geriatricare.repositories.jpa.CondicaoMentalJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CondicaoMentalRepositoryMySQLImpl implements CondicaoMentalRepository {

    private final CondicaoMentalJPA condicaoMentalJPA;

    @Autowired
    public CondicaoMentalRepositoryMySQLImpl(CondicaoMentalJPA condicaoMentalJPA) {
        this.condicaoMentalJPA = condicaoMentalJPA;
    }

    @Override
    public CondicaoMentalModels buscarPorCodigo(int codigo) {
        return this.condicaoMentalJPA.findById(codigo).get();
    }

    @Override
    public List<CondicaoMentalModels> buscar() {
        return this.condicaoMentalJPA.findAll();
    }

    @Override
    public void adicionar(CondicaoMentalModels condicaoMentalModels) {
        this.condicaoMentalJPA.save(condicaoMentalModels);
    }

    @Override
    public void remover(int codigo) {
        this.condicaoMentalJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(CondicaoMentalModels condicaoMentalModels) {
        this.condicaoMentalJPA.save(condicaoMentalModels);
    }
}
