package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.Interfaces.PacienteMedicamentoRepository;
import com.geriaTeam.geriatricare.entities.PacienteMedicamento;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteMedicamentoApplication {

    private final PacienteMedicamento pacienteMedicamento;
    private final PacienteMedicamentoRepository pacienteMedicamentoRepository;

    // Construtor com injeção de dependências
    public PacienteMedicamentoApplication(PacienteMedicamentoRepository pacienteMedicamentoRepository, MedicamentoRepository medicamentoRepository) {
        this.pacienteMedicamentoRepository = pacienteMedicamentoRepository;
        this.pacienteMedicamento = new PacienteMedicamento(pacienteMedicamentoRepository, medicamentoRepository);
    }

    // 1. Adicionar Medicamento ao Paciente
    public void adicionarMedicamento(int pacienteId, int medicamentoId) {
        pacienteMedicamento.adicionarMedicamento(pacienteId, medicamentoId);
    }

    // 2. Remover Medicamento do Paciente
    public void removerMedicamento(int pacienteId, int medicamentoId) {
        pacienteMedicamento.removerMedicamento(pacienteId, medicamentoId);
    }

    // 3. Buscar Medicamentos de um Paciente
    public List<MedicamentoModels> buscarMedicamentosPorPaciente(int pacienteId) {
        return pacienteMedicamento.buscarMedicamentosPorPaciente(pacienteId);
    }

    // 4. Atualizar Medicamento de um Paciente
    public void atualizarMedicamento(int pacienteId, int medicamentoIdAntigo, int medicamentoIdNovo) {
        pacienteMedicamento.atualizarMedicamento(pacienteId, medicamentoIdAntigo, medicamentoIdNovo);
    }

    // 5. Verificar Medicamento de um Paciente
    public boolean verificarMedicamento(int pacienteId, int medicamentoId) {
        return pacienteMedicamento.verificarMedicamento(pacienteId, medicamentoId);
    }

    // 6. Adicionar novo relacionamento paciente-medicamento
    public void adicionar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoRepository.adicionar(pacienteMedicamentoModels);
    }

    // 7. Atualizar relacionamento paciente-medicamento
    public void atualizar(PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoRepository.atualizar(pacienteMedicamentoModels);
    }

    // 8. Remover relacionamento paciente-medicamento
    public void remover(int codigo) {
        pacienteMedicamentoRepository.remover(codigo);
    }

    // 9. Buscar todos os relacionamentos
    public List<PacienteMedicamentoModels> buscar() {
        return pacienteMedicamentoRepository.buscar();
    }

    // 10. Buscar relacionamento específico por código
    public PacienteMedicamentoModels buscarPorCodigo(int codigo) {
        return pacienteMedicamentoRepository.buscarPorCodigo(codigo);
    }
}
