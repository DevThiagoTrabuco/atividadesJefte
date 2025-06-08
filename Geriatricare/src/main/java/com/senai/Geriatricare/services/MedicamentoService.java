package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.models.MedicamentoModel;
import com.senai.Geriatricare.repositories.MedicamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class MedicamentoService {
    private final MedicamentoRepository medicamentoRepository;
    private final ClienteService clienteService;

    @Autowired
    public MedicamentoService(MedicamentoRepository medicamentoRepository, ClienteService clienteService) {
        this.medicamentoRepository = medicamentoRepository;
        this.clienteService = clienteService;
    }

    public void criarMedicamento(MedicamentoModel medicamentoModel) {
        ClienteEntity cliente = clienteService.buscarPorId(medicamentoModel.getClienteId());
        MedicamentoEntity medicamento = medicamentoModel.toEntity(cliente);
        medicamentoRepository.save(medicamento);
    }

    public void atualizarMedicamento(MedicamentoModel medicamentoAtualizado) {
        MedicamentoEntity medicamento = medicamentoRepository.findById(medicamentoAtualizado.getId())
                .orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado com o ID: " + medicamentoAtualizado.getId()));

        ClienteEntity cliente = clienteService.buscarPorId(medicamentoAtualizado.getClienteId());

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

    public List<MedicamentoEntity> listarTodos() {
        return medicamentoRepository.findAll();
    }

    public MedicamentoEntity buscarPorId(int id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Medicamento com ID " + id + " não encontrado."));
    }

    public List<MedicamentoEntity> buscarPorNomeGenerico(int clienteId, String nomeGenerico) {
        return medicamentoRepository.findByNomeGenerico(clienteId, nomeGenerico);
    }

    public List<MedicamentoEntity> buscarPorNomeComercial(int clienteId, String nomeComercial) {
        return medicamentoRepository.findByNomeComercial(clienteId, nomeComercial);
    }

    public List<MedicamentoEntity> buscarPorDataValidade(int clienteId, String dataValidade) {
        return medicamentoRepository.findByDataValidade(clienteId, dataValidade);
    }

    public List<MedicamentoEntity> buscarPorStatusMedicamento(int clienteId, String statusMedicamento) {
        return medicamentoRepository.findByStatusMedicamento(clienteId, statusMedicamento);
    }
}