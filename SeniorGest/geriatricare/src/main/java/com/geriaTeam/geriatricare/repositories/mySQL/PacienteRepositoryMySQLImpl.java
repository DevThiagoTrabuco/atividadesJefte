package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.repositories.jpa.PacienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteRepositoryMySQLImpl implements PacienteRepository {
    private final PacienteJPA pacienteJPA;

    @Autowired
    public PacienteRepositoryMySQLImpl(PacienteJPA pacienteJPA) {
        this.pacienteJPA = pacienteJPA;
    }

    @Override
    public PacienteModels buscarPorCodigo(int codigo) {
        return this.pacienteJPA.findById(codigo).get();
    }

    @Override
    public List<PacienteModels> buscar() {
        return this.pacienteJPA.findAll();
    }

    @Override
    public void adicionar(PacienteModels pacienteModels) {
        this.pacienteJPA.save(pacienteModels);
    }

    @Override
    public void remover(int codigo) {
        this.pacienteJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(PacienteModels pacienteModels) {
        this.pacienteJPA.save(pacienteModels);
    }
}
