package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.entities.PrescricaoEntity;
import com.senai.Geriatricare.models.PrescricaoModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.MedicamentoRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import com.senai.Geriatricare.repositories.PrescricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescricaoService {
    private final PrescricaoRepository prescricaoRepository;
    private final ClienteRepository clienteRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicamentoRepository medicamentoRepository;

    @Autowired
    public PrescricaoService(
            PrescricaoRepository prescricaoRepository,
            ClienteRepository clienteRepository,
            PacienteRepository pacienteRepository,
            MedicamentoRepository medicamentoRepository
    ) {
        this.prescricaoRepository = prescricaoRepository;
        this.clienteRepository = clienteRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    public void criarPrescricao(PrescricaoModel prescricaoModel) {
        ClienteEntity cliente = clienteRepository.findById(prescricaoModel.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + prescricaoModel.getClienteId()));
        PacienteEntity paciente = pacienteRepository.findById(prescricaoModel.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + prescricaoModel.getPacienteId()));
        MedicamentoEntity medicamento = medicamentoRepository.findById(prescricaoModel.getMedicamentoId())
                .orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado com o ID: " + prescricaoModel.getMedicamentoId()));

        PrescricaoEntity prescricao = prescricaoModel.toEntity(cliente, paciente, medicamento);
        prescricaoRepository.save(prescricao);
    }

    public void atualizarPrescricao(PrescricaoModel prescricaoAtualizada) {
        PrescricaoEntity prescricao = prescricaoRepository.findById(prescricaoAtualizada.getId())
                .orElseThrow(() -> new EntityNotFoundException("Prescrição não encontrada com o ID: " + prescricaoAtualizada.getId()));

        ClienteEntity cliente = clienteRepository.findById(prescricaoAtualizada.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + prescricaoAtualizada.getClienteId()));
        PacienteEntity paciente = pacienteRepository.findById(prescricaoAtualizada.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + prescricaoAtualizada.getPacienteId()));
        MedicamentoEntity medicamento = medicamentoRepository.findById(prescricaoAtualizada.getMedicamentoId())
                .orElseThrow(() -> new EntityNotFoundException("Medicamento não encontrado com o ID: " + prescricaoAtualizada.getMedicamentoId()));

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
        ClienteEntity cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteEntity paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));
        return prescricaoRepository.findByClienteAndPaciente(cliente, paciente);
    }
}