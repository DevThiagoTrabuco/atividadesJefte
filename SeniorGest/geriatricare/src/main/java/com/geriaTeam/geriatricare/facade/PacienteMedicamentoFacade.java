package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PacienteMedicamentoApplication;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteMedicamentoFacade {
    @Autowired
    private PacienteMedicamentoApplication pacienteMedicamentoApplication;

    // Funções já existentes
    public List<PacienteMedicamentoModels> buscar() {
        return pacienteMedicamentoApplication.buscar();
    }

    public PacienteMedicamentoModels buscarPorCodigo(int codigo) {
        return pacienteMedicamentoApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoApplication.adicionar(pacienteMedicamentoModels);
    }

    public void atualizar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoApplication.atualizar(pacienteMedicamentoModels);
    }

    public void remover(int codigo) {
        pacienteMedicamentoApplication.remover(codigo);
    }

    // Novas funções a serem adicionadas
    public void adicionarMedicamento(int pacienteId, int medicamentoId) {
        pacienteMedicamentoApplication.adicionarMedicamento(pacienteId, medicamentoId);
    }

    public void removerMedicamento(int pacienteId, int medicamentoId) {
        pacienteMedicamentoApplication.removerMedicamento(pacienteId, medicamentoId);
    }

    public List<MedicamentoModels> buscarMedicamentosPorPaciente(int pacienteId) {
        return pacienteMedicamentoApplication.buscarMedicamentosPorPaciente(pacienteId);
    }

    public void atualizarMedicamento(int pacienteId, int medicamentoIdAntigo, int medicamentoIdNovo) {
        pacienteMedicamentoApplication.atualizarMedicamento(pacienteId, medicamentoIdAntigo, medicamentoIdNovo);
    }

    public boolean verificarMedicamento(int pacienteId, int medicamentoId) {
        return pacienteMedicamentoApplication.verificarMedicamento(pacienteId, medicamentoId);
    }
}
