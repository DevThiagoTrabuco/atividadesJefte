package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.MedicamentosRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;

import java.util.List;

public class MedicamentosRepositoryImpl implements MedicamentosRepository {
    @Override
    public Medicamentos buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<Medicamentos> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(Medicamentos medicamentos) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, Medicamentos medicamentos) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
