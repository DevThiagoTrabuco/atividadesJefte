package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamento;

import java.util.ArrayList;
import java.util.List;


public class MedicamentoRepositoryImpl implements MedicamentoRepository {
    private List<Medicamento> medicamentos = new ArrayList<>();

    @Override
    public void adicionar(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    @Override
    public void atualizar(int codigo, Medicamento medicamento) {
        Medicamento medicamentoEmMemoria = this.buscarPorCodigo(codigo);
        medicamentoEmMemoria.setNome(medicamento.getNome());
        medicamentoEmMemoria.setId(medicamento.getId());
    }

    @Override
    public List<Medicamento> buscar() {
        return medicamentos;
    }

    @Override
    public Medicamento buscarPorCodigo(int codigo) {
        Medicamento medicamento = medicamentos
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return medicamento;
    }

    @Override
    public void remover(int codigo) {
        medicamentos.removeIf(l -> l.getId() == codigo);
    }
}

    
