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
    public FamiliarModels buscarPorCodigo(int codigo) {
        return this.familiarJPA.findById(codigo).get();
    }

    @Override
    public FamiliarModels buscarPorCpf(String cpf) {
        return this.familiarJPA.findByCpf(cpf);
    }

    @Override
    public List<FamiliarModels> buscarPorNome(String nome) {
        return this.familiarJPA.findByNomeContaining(nome);
    }

    @Override
    public List<FamiliarModels> buscar() {
        return this.familiarJPA.findAll();
    }

    @Override
    public void adicionar(FamiliarModels familiarModels) {
        this.familiarJPA.save(familiarModels);
    }

    @Override
    public void remover(int codigo) {
        this.familiarJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(FamiliarModels familiarModels) {
        this.familiarJPA.save(familiarModels);
    }
}
