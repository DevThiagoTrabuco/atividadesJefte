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

    // Funções já existentes
    public List<PacienteModels> buscar() {
        return pacienteApplication.buscar();
    }

    public PacienteModels buscarPorCodigo(int codigo) {
        return pacienteApplication.buscarPorCodigo(codigo);
    }

    public void adicionar(PacienteModels pacienteModels) {
        pacienteApplication.adicionar(pacienteModels);
    }

    public void atualizar(PacienteModels pacienteModels) {
        pacienteApplication.atualizar(pacienteModels);
    }

    public void remover(int codigo) {
        pacienteApplication.remover(codigo);
    }

    // Novas funções adicionadas
    public String verificarEstadoSaude(Paciente paciente) {
        return pacienteApplication.verificarEstadoSaude(paciente);
    }

    public void registrarEntrada(Paciente paciente, LocalDateTime dataEntrada) {
        pacienteApplication.registrarEntrada(paciente, dataEntrada);
    }

    public int calcularIdade(Paciente paciente) {
        return pacienteApplication.calcularIdade(paciente);
    }

    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos(Paciente paciente) {
        return pacienteApplication.verificarHistoricoMedicamentos(paciente);
    }

    public void adicionarFamiliar(Paciente paciente, PacienteFamiliarModels familiar) {
        pacienteApplication.adicionarFamiliar(paciente, familiar);
    }

    public PlanoModels verificarPlanoSaude(Paciente paciente) {
        return pacienteApplication.verificarPlanoSaude(paciente);
    }
}
