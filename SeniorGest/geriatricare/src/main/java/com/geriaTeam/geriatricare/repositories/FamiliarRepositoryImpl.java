package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.domain.Familiar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class FamiliarRepositoryImpl implements FamiliarRepository {
    private List<Familiar> familiares = new ArrayList<>();

    @Override
    public Familiar buscarPorCodigo(int codigo) {
        Familiar familiar = familiares
        .stream()
        .filter(l -> l.getId() == codigo)
        .findFirst()
        .get();

        return familiar;
    }

    @Override
    public List<Familiar> buscar() {
        return familiares;
    }

    @Override
    public void adicionar(Familiar familiar) {
        familiares.add(familiar);
    }

    @Override
    public void remover(int codigo) {
        familiares.removeIf(l -> l.getId() == codigo);
    }

    @Override
    public void atualizar(int codigo, Familiar familiar) {
        Familiar familiarEmMemoria = this.buscarPorCodigo(codigo);
        familiarEmMemoria.setNome(familiar.getNome());
        familiarEmMemoria.setId(familiar.getId());
        familiarEmMemoria.setEmail(familiar.getEmail());
        familiarEmMemoria.setTelefone(familiar.getTelefone());
    }
}
