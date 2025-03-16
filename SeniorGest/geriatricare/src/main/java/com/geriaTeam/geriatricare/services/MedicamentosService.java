package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.Interfaces.MedicamentosRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;

import java.util.List;

public class MedicamentosService {
    private final MedicamentosRepository medicamentosRepository;

    public MedicamentosService(MedicamentosRepository medicamentosRepository) {
        this.medicamentosRepository = medicamentosRepository;
    }

    public void registrarMedicamento(Medicamentos medicamento) {
        if (medicamentosRepository.listarPorCodigo(medicamento.getId()) != null) {
            throw new IllegalArgumentException("Medicamento já cadastrado!");
        }
        medicamentosRepository.registrar(medicamento);
    }

    public void atualizarMedicamento(int id, Medicamentos medicamento) {
        if (medicamentosRepository.listarPorCodigo(id) == null) {
            throw new IllegalArgumentException("Medicamento não encontrado!");
        }
        medicamentosRepository.atualizar(medicamento.getId(), medicamento);
    }

    public void excluirMedicamento(int id) {
        // Regra de negócio: verificar se o medicamento está vinculado a um paciente
        if (medicamentoVinculadoAPaciente(id)) {
            throw new IllegalArgumentException("Medicamento não pode ser excluído, pois está vinculado a um paciente!");
        }
        medicamentosRepository.remover(id);
    }

    public List<Medicamentos> listarTodos() {
        return medicamentosRepository.listar();
    }

    public Medicamentos listarPorCodigo(int id) {
        return medicamentosRepository.listarPorCodigo(id);
    }

    public void reduzirEstoque(int id, int quantidade) {
        Medicamentos medicamento = medicamentosRepository.listarPorCodigo(id);
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento não encontrado!");
        }
        if (medicamento.getQtdMedicamentos() < quantidade) {
            throw new IllegalArgumentException("Estoque insuficiente!");
        }
        medicamento.setQtdMedicamentos(medicamento.getQtdMedicamentos() - quantidade);
        medicamentosRepository.atualizar(medicamento.getId(), medicamento);
    }

    public void reabastecerEstoque(int id, int quantidade) {
        Medicamentos medicamento = medicamentosRepository.listarPorCodigo(id);
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento não encontrado!");
        }
        medicamento.setQtdMedicamentos(medicamento.getQtdMedicamentos() + quantidade);
        medicamentosRepository.atualizar(medicamento.getId(), medicamento);
    }

    private boolean medicamentoVinculadoAPaciente(int id) {
        // Lógica para verificar se há relação entre Medicamento e Paciente
        return false;
    }
}

