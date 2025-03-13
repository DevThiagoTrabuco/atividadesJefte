package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.MedicamentosRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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
        medicamentosEmMemoria.setId(medicamentos.getId());
    }

    @Override
    public List<Medicamentos> buscar() {
        return medicamentoss;
    }

    @Override
    public Medicamentos buscarPorCodigo(int codigo) {
        Medicamentos medicamentos = medicamentoss
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return medicamentos;
    }

    @Override
    public void remover(int codigo) {
        medicamentoss.removeIf(l -> l.getId() == codigo);
    }
}

    
