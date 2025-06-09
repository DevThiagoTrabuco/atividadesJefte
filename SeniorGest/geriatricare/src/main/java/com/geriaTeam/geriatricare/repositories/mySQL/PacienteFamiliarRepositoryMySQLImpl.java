package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
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
    public PacienteFamiliarModels buscarPacienteFamiliarId(int codigo) {
        return this.pacienteFamiliarJPA.findById(codigo).get();
    }

    @Override
    public List<PacienteFamiliarModels> buscarPacienteFamiliar() {
        return this.pacienteFamiliarJPA.findAll();
    }

    @Override
    public void adicionarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels) {
        this.pacienteFamiliarJPA.save(pacienteFamiliarModels);
    }

    @Override
    public void removerPacienteFamiliar(int codigo) {
        this.pacienteFamiliarJPA.deleteById(codigo);
    }

    @Override
    public void atualizarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels) {
        this.pacienteFamiliarJPA.save(pacienteFamiliarModels);
    }

    @Override
    public PacienteFamiliarModels buscarPorPacienteIdEFamiliarId(int pacienteId, int familiarId) {
        return this.pacienteFamiliarJPA.buscarPorPacienteIdEFamiliarId(pacienteId, familiarId);
    }

}
