package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.repositories.jpa.FamiliarJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FamiliarRepositoryMySQLImpl implements FamiliarRepository {
    private final FamiliarJPA familiarJPA;

    @Autowired
    public FamiliarRepositoryMySQLImpl(FamiliarJPA familiarJPA) {
        this.familiarJPA = familiarJPA;
    }

    @Override
    public FamiliarModels buscarFamiliarId(int codigo) {
        return this.familiarJPA.findById(codigo).get();
    }

    @Override
    public FamiliarModels buscarFamiliarCpf(String cpf) {
        return this.familiarJPA.findByCpf(cpf);
    }

    @Override
    public List<FamiliarModels> buscarFamiliarNome(String nomeCompleto) {
        return this.familiarJPA.findByNomeContaining(nomeCompleto);
    }

    @Override
    public List<FamiliarModels> buscarFamiliar() {
        return this.familiarJPA.findAll();
    }

    @Override
    public void adicionarFamiliar(FamiliarModels familiarModels) {
        this.familiarJPA.save(familiarModels);
    }

    @Override
    public void removerFamiliar(int codigo) {
        this.familiarJPA.deleteById(codigo);
    }

    @Override
    public void atualizarFamiliar(FamiliarModels familiarModels) {
        this.familiarJPA.save(familiarModels);
    }
}
