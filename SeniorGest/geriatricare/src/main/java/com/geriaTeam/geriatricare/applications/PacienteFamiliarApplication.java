package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.entities.PacienteFamiliar;
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

    public void adicionarFamiliar(int pacienteId, int familiarId) {
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(familiarId);
        if (familiar == null) {
            throw new RuntimeException("Familiar não encontrado");
        }

        PacienteModels paciente = pacienteRepository.buscarPorCodigo(pacienteId);
        if (paciente == null) {
            throw new RuntimeException("Paciente não encontrado");
        }

        // Cria um novo relacionamento PacienteFamiliarModels
        PacienteFamiliarModels relacionamento = new PacienteFamiliarModels();
        relacionamento.setPacienteId(pacienteId);
        relacionamento.setFamiliarId(familiarId);
        relacionamento.setPacienteId(pacienteId);
        relacionamento.setFamiliarId(familiarId);

        // Adiciona o relacionamento à lista de familiares do paciente
        paciente.getPacienteFamiliarModels().add(relacionamento);

        // Atualiza o paciente no repositório
        pacienteRepository.atualizar(paciente);
    }

    public void removerFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorPacienteIdEFamiliarId(pacienteId, familiarId);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        pacienteFamiliarRepository.remover(relacionamento.getId());
    }

    public PacienteFamiliarModels buscarRelacionamento(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorCodigo(pacienteId);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        return relacionamento;
    }

    public void atualizarFamiliar(int pacienteId, int familiarId, int novoFamiliarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorCodigo(pacienteId);
        if (relacionamento == null) {
            throw new RuntimeException("Relacionamento não encontrado");
        }

        FamiliarModels novoFamiliar = familiarRepository.buscarPorCodigo(novoFamiliarId);
        if (novoFamiliar == null) {
            throw new RuntimeException("Novo familiar não encontrado");
        }

        relacionamento.setFamiliarId(novoFamiliarId);
        pacienteFamiliarRepository.atualizar(relacionamento);
    }

    public boolean verificarFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorCodigo(pacienteId);
        return relacionamento != null;
    }

    // 6. Adicionar novo relacionamento paciente-familiar
    public void adicionar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarRepository.adicionar(pacienteFamiliarModels);
    }

    // 7. Atualizar relacionamento paciente-familiar
    public void atualizar(PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarRepository.atualizar(pacienteFamiliarModels);
    }

    // 8. Remover relacionamento paciente-familiar
    public void remover(int codigo) {
        pacienteFamiliarRepository.remover(codigo);
    }

    // 9. Buscar todos os relacionamentos
    public List<PacienteFamiliarModels> buscar() {
        return pacienteFamiliarRepository.buscar();
    }

    // 10. Buscar relacionamento específico por código
    public PacienteFamiliarModels buscarPorCodigo(int codigo) {
        return pacienteFamiliarRepository.buscarPorCodigo(codigo);
    }
}
