package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.entities.PrescricaoEntity;
import com.senai.Geriatricare.models.PrescricaoModel;
import com.senai.Geriatricare.repositories.PrescricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescricaoService {
    private final PrescricaoRepository prescricaoRepository;
    private final ClienteService clienteService;
    private final PacienteService pacienteService;
    private final MedicamentoService medicamentoService;

    @Autowired
    public PrescricaoService(
            PrescricaoRepository prescricaoRepository,
            ClienteService clienteService,
            PacienteService pacienteService,
            MedicamentoService medicamentoService
    ) {
        this.prescricaoRepository = prescricaoRepository;
        this.clienteService = clienteService;
        this.pacienteService = pacienteService;
        this.medicamentoService = medicamentoService;
    }

    public void criarPrescricao(PrescricaoModel prescricaoModel) {
        ClienteEntity cliente = clienteService.buscarPorId(prescricaoModel.getClienteId());
        PacienteEntity paciente = pacienteService.buscarPorId(prescricaoModel.getPacienteId());
        MedicamentoEntity medicamento = medicamentoService.buscarPorId(prescricaoModel.getMedicamentoId());

        PrescricaoEntity prescricao = prescricaoModel.toEntity(cliente, paciente, medicamento);
        prescricaoRepository.save(prescricao);
    }

    public void atualizarPrescricao(PrescricaoModel prescricaoAtualizada) {
        PrescricaoEntity prescricao = prescricaoRepository.findById(prescricaoAtualizada.getId())
                .orElseThrow(() -> new EntityNotFoundException("Prescrição não encontrada com o ID: " + prescricaoAtualizada.getId()));

        ClienteEntity cliente = clienteService.buscarPorId(prescricaoAtualizada.getClienteId());
        PacienteEntity paciente = pacienteService.buscarPorId(prescricaoAtualizada.getPacienteId());
        MedicamentoEntity medicamento = medicamentoService.buscarPorId(prescricaoAtualizada.getMedicamentoId());

        prescricao.setCliente(cliente);
        prescricao.setPaciente(paciente);
        prescricao.setMedicamento(medicamento);
        prescricao.setPosologia(prescricaoAtualizada.getPosologia());
        prescricao.setDataInicio(prescricaoAtualizada.getDataInicio());
        prescricao.setDataFim(prescricaoAtualizada.getDataFim());

        prescricaoRepository.save(prescricao);
    }

    public void removerPrescricao(int id) {
        if (!prescricaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Prescrição não encontrada com o ID: " + id);
        }
        prescricaoRepository.deleteById(id);
    }

    public List<PrescricaoEntity> listarTodos() {
        return prescricaoRepository.findAll();
    }

    public PrescricaoEntity buscarPorId(int id) {
        return prescricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prescrição com ID " + id + " não encontrada."));
    }

    public List<PrescricaoEntity> buscarPorPaciente(int clienteId, int pacienteId) {
        return prescricaoRepository.findByPaciente(clienteId, pacienteId);
    }
}