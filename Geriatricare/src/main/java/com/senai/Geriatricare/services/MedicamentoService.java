package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.MedicamentoModel;
import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.MedicamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicamentoService {
    private final MedicamentoRepository medicamentoRepository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository, ClienteRepository clienteRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void criarMedicamento(MedicamentoEntity medicamentoEntity) {
        ClienteModel cliente = clienteRepository.findById(medicamentoEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + medicamentoEntity.getClienteId()));
        MedicamentoModel medicamento = medicamentoEntity.toEntity(cliente);
        medicamentoRepository.save(medicamento);
    }

    public void atualizarMedicamento(MedicamentoEntity medicamentoAtualizado) {
        MedicamentoModel medicamento = medicamentoRepository.findById(medicamentoAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado com o ID: " + medicamentoAtualizado.getId()));

        ClienteModel cliente = clienteRepository.findById(medicamentoAtualizado.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + medicamentoAtualizado.getClienteId()));

        medicamento.setCliente(cliente);
        medicamento.setNomeComercial(medicamentoAtualizado.getNomeComercial());
        medicamento.setNomeGenerico(medicamentoAtualizado.getNomeGenerico());
        medicamento.setDosagem(medicamentoAtualizado.getDosagem());
        medicamento.setLote(medicamentoAtualizado.getLote());
        medicamento.setDataValidade(medicamentoAtualizado.getDataValidade());
        medicamento.setStatusMedicamento(medicamentoAtualizado.getStatusMedicamento());
        medicamento.setQuantidade(medicamentoAtualizado.getQuantidade());

        medicamentoRepository.save(medicamento);
    }

    public void removerMedicamento(int id) {
        if (!medicamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Medicamento não encontrado com o ID: " + id);
        }
        medicamentoRepository.deleteById(id);
    }

    public List<MedicamentoModel> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public MedicamentoModel buscarPorId(int id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medicamento com ID " + id + " não encontrado."));
    }

    public List<MedicamentoModel> buscarPorNomeGenerico(int clienteId, String nomeGenerico) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return medicamentoRepository.findByClienteAndNomeGenerico(cliente, nomeGenerico);
    }

    public List<MedicamentoModel> buscarPorNomeComercial(int clienteId, String nomeComercial) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return medicamentoRepository.findByClienteAndNomeComercial(cliente, nomeComercial);
    }

    public List<MedicamentoModel> buscarPorDataValidade(int clienteId, LocalDate dataValidade) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return medicamentoRepository.findByClienteAndDataValidade(cliente, dataValidade);
    }

    public List<MedicamentoModel> buscarPorStatusMedicamento(int clienteId, String statusMedicamento) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        return medicamentoRepository.findByClienteAndStatusMedicamento(cliente, statusMedicamento);
    }
}