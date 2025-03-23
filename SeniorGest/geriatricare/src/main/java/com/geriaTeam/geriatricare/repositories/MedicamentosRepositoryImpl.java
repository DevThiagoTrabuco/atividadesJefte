package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.MedicamentosRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;

import java.util.ArrayList;
import java.util.List;


public class MedicamentosRepositoryImpl implements MedicamentosRepository {
    private List<Medicamentos> medicamentoss = new ArrayList<>();

    @Override
    public void adicionar(Medicamentos medicamentos) {
        medicamentoss.add(medicamentos);
    }

    @Override
    public void atualizar(int codigo, Medicamentos medicamentos) {
        Medicamentos medicamentosEmMemoria = this.buscarPorCodigo(codigo);
        medicamentosEmMemoria.setNome(medicamentos.getNome());
        medicamentosEmMemoria.setMedicamentosId(medicamentos.getMedicamentosId());
    }

    @Override
    public List<Medicamentos> buscar() {
        return medicamentoss;
    }

    @Override
    public Medicamentos buscarPorCodigo(int codigo) {
        Medicamentos medicamentos = medicamentoss
                .stream()
                .filter(l -> l.getMedicamentosId() == codigo)
                .findFirst()
                .get();

        return medicamentos;
    }

    @Override
    public void remover(int codigo) {
        medicamentoss.removeIf(l -> l.getMedicamentosId() == codigo);
    }
}

    
