package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.PacienteApplication;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PlanoModels;
import com.geriaTeam.geriatricare.entities.Paciente;
import java.time.LocalDateTime;

@Component
public class PacienteFacade {
    @Autowired
    private PacienteApplication pacienteApplication;


    public List<PacienteModels> buscarTodosPacientes() {
        return pacienteApplication.buscarTodosPacientes();
    }

    public PacienteModels buscarPacienteId(int id) {
        return pacienteApplication.buscarPacienteId(id);
    }

    public void adicionarPaciente(PacienteModels pacienteModels) {
        pacienteApplication.adicionarPaciente(pacienteModels);
    }

    public void atualizarPaciente(PacienteModels pacienteModels) {
        pacienteApplication.atualizarPaciente(pacienteModels);
    }

    public void removerPaciente(int id) {
        pacienteApplication.removerPaciente(id);
    }

    public String verificarEstadoSaudePaciente(int id) {
        return pacienteApplication.verificarEstadoSaudePaciente(id);
    }

    public void registrarEntradaPaciente(int id) {
        pacienteApplication.registrarEntradaPaciente(id);
    }

    public void registrarSaidaPaciente(int id) {
        pacienteApplication.registrarSaidaPaciente(id);
    }

    public int calcularIdadePaciente(int id) {
        return pacienteApplication.calcularIdadePaciente(id);
    }


    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentosPaciente(int id) {
        return pacienteApplication.verificarHistoricoMedicamentosPaciente(id);
    }

    public void adicionarFamiliarPaciente(int id, PacienteFamiliarModels familiar) {
        pacienteApplication.adicionarFamiliarPaciente(id, familiar);
    }

    public void removerFamiliarPaciente(int id, int idFamiliar) {
        pacienteApplication.removerFamiliarPaciente(id, idFamiliar);
    }

    public void atualizarPlanoSaudePaciente(int id, int idPlano) {
        pacienteApplication.atualizarPlanoSaudePaciente(id, idPlano);
    }

    public void adicionarMedicamentoPaciente(int id, PacienteMedicamentoModels medicamento) {
        pacienteApplication.adicionarMedicamentoPaciente(id, medicamento);
    }

    public void removerMedicamentoPaciente(int id, int idMedicamento) {
        pacienteApplication.removerMedicamentoPaciente(id, idMedicamento);
    }

    public PlanoModels verificarPlanoSaudePaciente(int id) {
        return pacienteApplication.verificarPlanoSaudePaciente(id);
    }
}
