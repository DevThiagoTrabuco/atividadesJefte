package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.MedicamentoApplication;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MedicamentoFacade {
    @Autowired
    private MedicamentoApplication medicamentoApplication;

    public List<MedicamentoModels> buscarTodosMedicamento() {
        return medicamentoApplication.buscarTodosMedicamento();
    }

    public MedicamentoModels buscarMedicamentoId(int codigo) {
        return medicamentoApplication.buscarMedicamentoId(codigo);
    }

    public void adicionarMedicamento(MedicamentoModels medicamentoModels) {
        medicamentoApplication.adicionarMedicamento(medicamentoModels);
    }

    public void atualizarMedicamento(MedicamentoModels medicamentoModels) {
        medicamentoApplication.atualizarMedicamento(medicamentoModels);
    }

    public void removerMedicamento(int codigo) {
        medicamentoApplication.removerMedicamento(codigo);
    }
}
