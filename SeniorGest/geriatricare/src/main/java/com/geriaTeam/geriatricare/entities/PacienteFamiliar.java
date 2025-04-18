package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.Interfaces.PacienteRepository; // Adicionando o repositório de Paciente
import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
public class PacienteFamiliar {

    private int id;
    private PacienteModels pacienteModels;
    private int pacienteId;
    private FamiliarModels familiarModels;
    private int familiarId;

    private PacienteFamiliarRepository pacienteFamiliarRepository;
    private FamiliarRepository familiarRepository;
    private PacienteRepository pacienteRepository;

    public void adicionarFamiliar(int pacienteId, int familiarId) {
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(familiarId);
        if (familiar == null) {
            throw new RuntimeException("Familiar não encontrado");
        }

        PacienteModels paciente = pacienteRepository.buscarPorCodigo(pacienteId);
        if (paciente == null) {
            throw new RuntimeException("Paciente não encontrado");
        }

        PacienteFamiliarModels relacionamento = new PacienteFamiliarModels();
        relacionamento.setPacienteId(pacienteId);
        relacionamento.setFamiliarId(familiarId);

        pacienteFamiliarRepository.adicionar(relacionamento);
    }

    public void removerFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliarModels relacionamento = pacienteFamiliarRepository.buscarPorCodigo(pacienteId);
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
}

