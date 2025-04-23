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


    public List<PacienteModels> listarTodos() {
        return pacienteApplication.listarTodos();
    }

    public PacienteModels listarPorId(int id) {
        return pacienteApplication.listarPorId(id);
    }

    public void adicionar(PacienteModels pacienteModels) {
        pacienteApplication.adicionar(pacienteModels);
    }

    public void atualizar(PacienteModels pacienteModels) {
        pacienteApplication.atualizar(pacienteModels);
    }

    public void remover(int id) {
        pacienteApplication.remover(id);
    }

    public String verificarEstadoSaude(int id) {
        return pacienteApplication.verificarEstadoSaude(id);
    }

    public void registrarEntrada(int id) {
        pacienteApplication.registrarEntrada(id);
    }

    public void registrarSaida(int id) {
        pacienteApplication.registrarSaida(id);
    }

    public int calcularIdade(int id) {
        return pacienteApplication.calcularIdade(id);
    }

    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos(int id) {
        return pacienteApplication.verificarHistoricoMedicamentos(id);
    }

    public void adicionarFamiliar(int id, PacienteFamiliarModels familiar) {
        pacienteApplication.adicionarFamiliar(id, familiar);
    }

    public void removerFamiliar(int id, int idFamiliar) {
        pacienteApplication.removerFamiliar(id, idFamiliar);
    }

    public void atualizarPlanoSaude(int id, int idPlano) {
        pacienteApplication.atualizarPlanoSaude(id, idPlano);
    }

    public void adicionarMedicamento(int id, PacienteMedicamentoModels medicamento) {
        pacienteApplication.adicionarMedicamento(id, medicamento);
    }

    public void removerMedicamento(int id, int idMedicamento) {
        pacienteApplication.removerMedicamento(id, idMedicamento);
    }

    public PlanoModels verificarPlanoSaude(int id) {
        return pacienteApplication.verificarPlanoSaude(id);
    }
}
