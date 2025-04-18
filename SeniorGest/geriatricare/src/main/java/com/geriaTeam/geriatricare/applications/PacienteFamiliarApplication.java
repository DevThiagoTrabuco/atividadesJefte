package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteFamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.entities.PacienteFamiliar;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteFamiliarApplication {

    private final PacienteFamiliar pacienteFamiliar;
    private final PacienteFamiliarRepository pacienteFamiliarRepository;
    private final FamiliarRepository familiarRepository;

    public PacienteFamiliarApplication(
            PacienteFamiliarRepository pacienteFamiliarRepository,
            FamiliarRepository familiarRepository,
            PacienteRepository pacienteRepository
    ) {
        this.pacienteFamiliarRepository = pacienteFamiliarRepository;
        this.familiarRepository = familiarRepository;
        this.pacienteFamiliar = new PacienteFamiliar(pacienteFamiliarRepository, familiarRepository, pacienteRepository);
    }

    // 1. Adicionar Familiar ao Paciente
    public void adicionarFamiliar(int pacienteId, int familiarId) {
        pacienteFamiliar.adicionarFamiliar(pacienteId, familiarId);
    }

    // 2. Remover Familiar do Paciente
    public void removerFamiliar(int pacienteId, int familiarId) {
        pacienteFamiliar.removerFamiliar(pacienteId, familiarId);
    }

    // 3. Buscar Relacionamento entre Paciente e Familiar
    public PacienteFamiliarModels buscarRelacionamento(int pacienteId, int familiarId) {
        return pacienteFamiliar.buscarRelacionamento(pacienteId, familiarId);
    }

    // 4. Atualizar Familiar do Paciente
    public void atualizarFamiliar(int pacienteId, int familiarId, int novoFamiliarId) {
        pacienteFamiliar.atualizarFamiliar(pacienteId, familiarId, novoFamiliarId);
    }

    // 5. Verificar se o Paciente tem um Familiar
    public boolean verificarFamiliar(int pacienteId, int familiarId) {
        return pacienteFamiliar.verificarFamiliar(pacienteId, familiarId);
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
