package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.entities.Medicamento;
import com.geriaTeam.geriatricare.models.MedicamentoModels;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoApplication {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public void adicionarMedicamento(MedicamentoModels model) {
        Medicamento medicamento = new Medicamento();
        medicamento.setId(model.getId());
        medicamento.setNome(model.getNome());
        medicamento.setLote(model.getLote());
        medicamento.setQuantidade(model.getQuantidade());
        medicamento.setVencimento(model.getVencimento());

        medicamentoRepository.adicionarMedicamento(medicamento.toModel());
    }

    public void atualizarMedicamento(MedicamentoModels model) {
        MedicamentoModels existente = medicamentoRepository.buscarMedicamentoId(model.getId());
        if (existente == null) {
            throw new EntityNotFoundException("Medicamento não encontrado.");
        }
        medicamentoRepository.atualizarMedicamento(model);
    }

    public void removerMedicamento(int codigo) {
        MedicamentoModels existente = medicamentoRepository.buscarMedicamentoId(codigo);
        if (existente == null) {
            throw new EntityNotFoundException("Medicamento não encontrado.");
        }
        medicamentoRepository.removerMedicamento(codigo);
    }

    public List<MedicamentoModels> buscarTodosMedicamento() {
        return medicamentoRepository.buscarMedicamento();
    }

    public MedicamentoModels buscarMedicamentoId(int codigo) {
        MedicamentoModels medicamento = medicamentoRepository.buscarMedicamentoId(codigo);
        if (medicamento == null) {
            throw new EntityNotFoundException("Medicamento não encontrado.");
        }
        return medicamento;
    }
}
