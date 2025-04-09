package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.models.domain.PacienteFamiliar;
import com.geriaTeam.geriatricare.repositories.jpa.PacienteFamiliarJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteFamiliarRepositoryMySQLImpl implements PacienteFamiliarRepository {
    private final PacienteFamiliarJPA pacienteFamiliarJPA;

    @Autowired
    public PacienteFamiliarRepositoryMySQLImpl(PacienteFamiliarJPA pacienteFamiliarJPA) {
        this.pacienteFamiliarJPA = pacienteFamiliarJPA;
    }

    @Override
    public PacienteFamiliar buscarPorCodigo(int codigo) {
        return this.pacienteFamiliarJPA.findById(codigo).get();
    }

    @Override
    public List<PacienteFamiliar> buscar() {
        return this.pacienteFamiliarJPA.findAll();
    }

    @Override
    public void adicionar(PacienteFamiliar pacienteFamiliar) {
        this.pacienteFamiliarJPA.save(pacienteFamiliar);
    }

    @Override
    public void remover(int codigo) {
        this.pacienteFamiliarJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(PacienteFamiliar pacienteFamiliar) {
        this.pacienteFamiliarJPA.save(pacienteFamiliar);
    }


}
