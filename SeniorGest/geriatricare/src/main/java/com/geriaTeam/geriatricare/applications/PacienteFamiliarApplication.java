package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteFamiliarApplication {
    private final PacienteFamiliarRepository pacienteFamiliarRepository;
    private final FamiliarRepository familiarRepository;
    private final PacienteRepository pacienteRepository;

    public PacienteFamiliarApplication(PacienteFamiliarRepository pacienteFamiliarRepository, FamiliarRepository familiarRepository, PacienteRepository pacienteRepository) {
        this.pacienteFamiliarRepository = pacienteFamiliarRepository;
        this.familiarRepository = familiarRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public void adicionarPacienteFamiliar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarRepository.adicionarPacienteFamiliar(pacienteFamiliarModels);
    }

    public void adicionarFamiliar(int pacienteId, int familiarId) {
        FamiliarModels familiar = familiarRepository.buscarFamiliarId(familiarId);
        if (familiar == null) {
            throw new RuntimeException("Familiar não encontrado");
        }

        PacienteModels paciente = pacienteRepository.buscarPacienteId(pacienteId);
        if (paciente == null) {
            throw new RuntimeException("Paciente não encontrado");
        }

        // Cria um novo relacionamento PacienteFamiliarModels
        PacienteFamiliarModels relacionamento = new PacienteFamiliarModels();
        relacionamento.setPacienteId(pacienteId);
        relacionamento.setFamiliarId(familiarId);

        // Atualiza o paciente no repositório
        pacienteFamiliarRepository.adicionarPacienteFamiliar(relacionamento);
    }

    public void removerPacienteFamiliar(int id){
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPacienteFamiliarId(id);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        pacienteFamiliarRepository.removerPacienteFamiliar(id);
    }

    public void removerFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorPacienteIdEFamiliarId(pacienteId, familiarId);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        pacienteFamiliarRepository.removerPacienteFamiliar(relacionamento.getId());
    }

    public PacienteFamiliarModels buscarRelacionamento(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorPacienteIdEFamiliarId(pacienteId, familiarId);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        return relacionamento;
    }

    public void atualizarFamiliar(int pacienteId, int familiarId, int novoFamiliarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorPacienteIdEFamiliarId(pacienteId, familiarId);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        FamiliarModels novoFamiliar = familiarRepository.buscarFamiliarId(novoFamiliarId);
        if (novoFamiliar == null) {
            throw new RuntimeException("Novo familiar não encontrado");
        }

        relacionamento.setFamiliarId(novoFamiliarId);
        pacienteFamiliarRepository.atualizarPacienteFamiliar(relacionamento);
    }

    public boolean verificarFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorPacienteIdEFamiliarId(pacienteId, familiarId);
        return relacionamento != null;
    }

    public List<PacienteFamiliarModels> buscarTodosPacienteFamiliar() {
        List<PacienteFamiliarModels> lista = pacienteFamiliarRepository.buscarPacienteFamiliar();
        if (lista.isEmpty()) {
            throw new RuntimeException("Nenhum relacionamento encontrado");
        }
        return lista;
    }
}
