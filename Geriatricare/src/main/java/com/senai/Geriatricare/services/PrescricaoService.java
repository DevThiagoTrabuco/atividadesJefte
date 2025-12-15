package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ConsultaModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.models.PrescricaoModel;
import com.senai.Geriatricare.entities.PrescricaoEntity;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ConsultaRepository;
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
    private final ConsultaRepository consultaRepository; // Adicionado

    @Autowired
    public PrescricaoService(
            PrescricaoRepository prescricaoRepository,
            ClienteRepository clienteRepository,
            PacienteRepository pacienteRepository,
            ConsultaRepository consultaRepository // Adicionado
    ) {
        this.prescricaoRepository = prescricaoRepository;
        this.clienteRepository = clienteRepository;
        this.pacienteRepository = pacienteRepository;
        this.consultaRepository = consultaRepository; // Adicionado
    }

    public void criarPrescricao(PrescricaoEntity prescricaoEntity) {
        ClienteModel cliente = clienteRepository.findById(prescricaoEntity.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + prescricaoEntity.getClienteId()));
        PacienteModel paciente = pacienteRepository.findById(prescricaoEntity.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + prescricaoEntity.getPacienteId()));
        ConsultaModel consulta = consultaRepository.findById(prescricaoEntity.getConsultaId())
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com o ID: " + prescricaoEntity.getConsultaId()));

        PrescricaoModel prescricao = prescricaoEntity.toEntity(cliente, paciente, consulta);
        prescricaoRepository.save(prescricao);
    }

    public void atualizarPrescricao(PrescricaoEntity prescricaoAtualizada) {
        PrescricaoModel prescricao = prescricaoRepository.findById(prescricaoAtualizada.getId())
                .orElseThrow(() -> new EntityNotFoundException("Prescrição não encontrada com o ID: " + prescricaoAtualizada.getId()));

        ClienteModel cliente = clienteRepository.findById(prescricaoAtualizada.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + prescricaoAtualizada.getClienteId()));
        PacienteModel paciente = pacienteRepository.findById(prescricaoAtualizada.getPacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + prescricaoAtualizada.getPacienteId()));
        ConsultaModel consulta = consultaRepository.findById(prescricaoAtualizada.getConsultaId())
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada com o ID: " + prescricaoAtualizada.getConsultaId()));

        prescricao.setCliente(cliente);
        prescricao.setPaciente(paciente);
        prescricao.setConsulta(consulta);
        prescricao.setMedicamento(prescricaoAtualizada.getMedicamento());
        prescricao.setPosologia(prescricaoAtualizada.getPosologia());
        prescricao.setDataInicio(prescricaoAtualizada.getDataInicio());
        prescricao.setQuantidade(prescricaoAtualizada.getQuantidade());

        prescricaoRepository.save(prescricao);
    }

    public void removerPrescricao(int id) {
        if (!prescricaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Prescrição não encontrada com o ID: " + id);
        }
        prescricaoRepository.deleteById(id);
    }

    public List<PrescricaoModel> listarTodos() {
        return prescricaoRepository.findAll();
    }

    public PrescricaoModel buscarPorId(int id) {
        return prescricaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prescrição com ID " + id + " não encontrada."));
    }

    public List<PrescricaoModel> buscarPorPaciente(int clienteId, int pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado com o ID: " + pacienteId));
        return prescricaoRepository.findByClienteAndPaciente(cliente, paciente);
    }
}
