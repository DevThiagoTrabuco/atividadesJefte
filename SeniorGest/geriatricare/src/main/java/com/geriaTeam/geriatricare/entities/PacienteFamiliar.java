package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.FamiliarModels;
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

    // 1. Adicionar Familiar ao Paciente
    public void adicionarFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliar pacienteFamiliar = new PacienteFamiliar();
        pacienteFamiliar.setPacienteId(pacienteId);
        pacienteFamiliar.setFamiliarId(familiarId);

        // Verificando se o familiar existe
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(familiarId);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado");
        }

        // Verificando se o paciente existe
        PacienteModels paciente = pacienteRepository.buscarPorCodigo(pacienteId); // Usando o repositório correto para paciente
        if (paciente == null) {
            throw new EntityNotFoundException("Paciente não encontrado");
        }

        // Adicionando o relacionamento no banco de dados
        pacienteFamiliarRepository.adicionar(pacienteFamiliar);
    }

    // 2. Remover Familiar do Paciente
    public void removerFamiliar(int pacienteId, int familiarId) {
        // Buscando o relacionamento entre paciente e familiar
        PacienteFamiliar pacienteFamiliar = pacienteFamiliarRepository.buscarPorCodigo(pacienteId, familiarId);

        if (pacienteFamiliar != null) {
            // Removendo o relacionamento
            pacienteFamiliarRepository.remover(pacienteFamiliar.getId());
        } else {
            throw new EntityNotFoundException("Relacionamento de paciente e familiar não encontrado.");
        }
    }

    // 3. Buscar Familiar de um Paciente
    public PacienteFamiliar buscarPorCodigo(int pacienteId, int familiarId) {
        PacienteFamiliar pacienteFamiliar = pacienteFamiliarRepository.buscarPorCodigo(pacienteId, familiarId);

        if (pacienteFamiliar == null) {
            throw new EntityNotFoundException("Relacionamento de paciente e familiar não encontrado.");
        }
        return pacienteFamiliar;
    }

    // 4. Atualizar o Familiar de um Paciente
    public void atualizarFamiliar(int pacienteId, int familiarId, int novoFamiliarId) {
        PacienteFamiliar pacienteFamiliar = pacienteFamiliarRepository.buscarPorCodigo(pacienteId, familiarId);

        if (pacienteFamiliar != null) {
            pacienteFamiliar.setFamiliarId(novoFamiliarId);

            // Verificando se o novo familiar existe
            FamiliarModels novoFamiliar = familiarRepository.buscarPorCodigo(novoFamiliarId);
            if (novoFamiliar == null) {
                throw new EntityNotFoundException("Novo familiar não encontrado");
            }

            // Atualizando no banco de dados
            pacienteFamiliarRepository.atualizar(pacienteFamiliar);
        } else {
            throw new EntityNotFoundException("Relacionamento de paciente e familiar não encontrado.");
        }
    }

    // 5. Verificar se um paciente tem um determinado familiar
    public boolean verificarFamiliar(int pacienteId, int familiarId) {
        PacienteFamiliar pacienteFamiliar = pacienteFamiliarRepository.buscarPorCodigo(pacienteId, familiarId);
        return pacienteFamiliar != null;
    }
}
