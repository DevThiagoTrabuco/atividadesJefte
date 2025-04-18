package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.entities.Paciente; // Importando a classe Paciente

import java.time.LocalDateTime;
import java.util.List;

import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteApplication {
    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteApplication(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // Funções já existentes na PacienteApplication
    public void adicionar(PacienteModels pacienteModels) {
        this.pacienteRepository.adicionar(pacienteModels);
    }

    public void atualizar(PacienteModels pacienteModels) {
        this.pacienteRepository.atualizar(pacienteModels);
    }

    public void remover(int codigo) {
        this.pacienteRepository.remover(codigo);
    }

    public List<PacienteModels> buscar() {
        return this.pacienteRepository.buscar();
    }

    public PacienteModels buscarPorCodigo(int codigo) {
        return this.pacienteRepository.buscarPorCodigo(codigo);
    }

    // Chamando as funções de Paciente
    public String verificarEstadoSaude(Paciente paciente) {
        return paciente.verificarEstadoSaude();
    }

    public void registrarEntrada(Paciente paciente, LocalDateTime dataEntrada) {
        paciente.registrarEntrada(dataEntrada);
    }

    public int calcularIdade(Paciente paciente) {
        return paciente.calcularIdade();
    }

    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos(Paciente paciente) {
        return paciente.verificarHistoricoMedicamentos();
    }

    public void adicionarFamiliar(Paciente paciente, PacienteFamiliarModels familiar) {
        paciente.adicionarFamiliar(familiar);
    }

    public PlanoModels verificarPlanoSaude(Paciente paciente) {
        return paciente.verificarPlanoSaude();
    }
}
