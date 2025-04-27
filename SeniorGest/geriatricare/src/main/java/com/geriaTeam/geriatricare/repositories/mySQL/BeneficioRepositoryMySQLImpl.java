package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PlanoBeneficioRepository;
import com.geriaTeam.geriatricare.models.PlanoBeneficioModels;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeneficioRepositoryMySQLImpl implements PlanoBeneficioRepository {

    @Override
    public PlanoBeneficioModels buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<PlanoBeneficioModels> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(PlanoBeneficioModels planoBeneficioModels) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(PlanoBeneficioModels planoBeneficioModels) {

    }
}
