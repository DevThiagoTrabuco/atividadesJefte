package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.domain.Familiar;
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
    public Familiar buscarPorCodigo(int codigo) {
        return this.familiarJPA.findById(codigo).get();
    }

    @Override
    public List<Familiar> buscar() {
        return this.familiarJPA.findAll();
    }

    @Override
    public void adicionar(Familiar familiar) {
        this.familiarJPA.save(familiar);
    }

    @Override
    public void remover(int codigo) {
        this.familiarJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(Familiar familiar) {
        this.familiarJPA.save(familiar);
    }
}
