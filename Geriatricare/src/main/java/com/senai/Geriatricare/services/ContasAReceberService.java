package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAReceberModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ContasAReceberRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContasAReceberService {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ContasAReceberModel criarContaAReceber(ContasAReceberModel contaAReceber, Integer pacienteId, Integer clienteId) {
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));

        contaAReceber.setPaciente(paciente);
        contaAReceber.setCliente(cliente);

        return contasAReceberRepository.save(contaAReceber);
    }

    public List<ContasAReceberModel> buscarPorClienteEPaciente(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));

        return contasAReceberRepository.findByClienteAndPaciente(cliente, paciente);
    }
}
