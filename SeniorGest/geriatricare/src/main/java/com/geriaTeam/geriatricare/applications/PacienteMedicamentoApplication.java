package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.Interfaces.PacienteMedicamentoRepository;
import com.geriaTeam.geriatricare.entities.PacienteMedicamento;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteMedicamentoApplication {
    private final PacienteMedicamentoRepository pacienteMedicamentoRepository;
    private final MedicamentoRepository medicamentoRepository;

    // Construtor com injeção de dependências


    public PacienteMedicamentoApplication(PacienteMedicamentoRepository pacienteMedicamentoRepository, MedicamentoRepository medicamentoRepository) {
        this.pacienteMedicamentoRepository = pacienteMedicamentoRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    // 1. Adicionar Medicamento ao Paciente
    public void adicionarMedicamento(int pacienteId, int medicamentoId) {
        PacienteMedicamentoModels pacienteMedicamento = new PacienteMedicamentoModels();
        pacienteMedicamento.setPacienteId(pacienteId);
        pacienteMedicamento.setMedicamentoId(medicamentoId);

        // Adicionando o relacionamento no banco de dados
        pacienteMedicamentoRepository.adicionar(pacienteMedicamento);
    }

    // 2. Remover Medicamento do Paciente
    public void removerMedicamento(int pacienteId, int medicamentoId) {
        // Buscando o relacionamento entre paciente e medicamento
        PacienteMedicamentoModels pacienteMedicamento = pacienteMedicamentoRepository
                .buscarPorCodigo(pacienteId);  // Pode ser necessário usar o ID específico ou outro critério

        if (pacienteMedicamento != null && pacienteMedicamento.getMedicamentoId() == medicamentoId) {
            // Removendo o relacionamento
            pacienteMedicamentoRepository.remover(pacienteMedicamento.getId());
        } else {
            throw new EntityNotFoundException("Relacionamento de paciente e medicamento não encontrado.");
        }
    }

    // 3. Buscar Medicamentos de um Paciente
    public List<MedicamentoModels> buscarMedicamentosPorPaciente(int pacienteId) {
        List<PacienteMedicamentoModels> pacienteMedicamentos = pacienteMedicamentoRepository.buscar();
        List<MedicamentoModels> medicamentos = new ArrayList<>();

        for (PacienteMedicamentoModels pm : pacienteMedicamentos) {
            if (pm.getPacienteId() == pacienteId) {  // Filtro pelo pacienteId
                MedicamentoModels medicamento = medicamentoRepository.buscarPorCodigo(pm.getMedicamentoId());
                if (medicamento != null) {
                    medicamentos.add(medicamento);
                }
            }
        }
        return medicamentos;
    }

    // 4. Atualizar Medicamento de um Paciente
    public void atualizarMedicamento(int pacienteId, int medicamentoIdAntigo, int medicamentoIdNovo) {
        // Buscando o relacionamento entre paciente e medicamento antigo
        PacienteMedicamentoModels pacienteMedicamento = pacienteMedicamentoRepository
                .buscarPorCodigo(pacienteId); // Pode ser necessário ajustar esse critério

        if (pacienteMedicamento != null && pacienteMedicamento.getMedicamentoId() == medicamentoIdAntigo) {
            // Atualizando o medicamento no relacionamento
            pacienteMedicamento.setMedicamentoId(medicamentoIdNovo);
            pacienteMedicamentoRepository.atualizar(pacienteMedicamento);
        } else {
            throw new EntityNotFoundException("Relacionamento de paciente e medicamento antigo não encontrado.");
        }
    }

    // 5. Verificar Medicamento de um Paciente
    public boolean verificarMedicamento(int pacienteId, int medicamentoId) {
        List<PacienteMedicamentoModels> pacienteMedicamentos = pacienteMedicamentoRepository.buscar();
        for (PacienteMedicamentoModels pm : pacienteMedicamentos) {
            if (pm.getPacienteId() == pacienteId && pm.getMedicamentoId() == medicamentoId) {
                return true;
            }
        }
        return false;
    }
}
