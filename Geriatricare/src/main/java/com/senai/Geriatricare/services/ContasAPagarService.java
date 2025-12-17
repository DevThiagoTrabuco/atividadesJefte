package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ContasAPagarEntity;
import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ContasAPagarRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ContasAPagarModel criarContaAPagar(ContasAPagarEntity contasAPagarEntity) {
        ClienteModel cliente = clienteRepository.findById(contasAPagarEntity.getClienteId())
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + contasAPagarEntity.getClienteId()));

        PacienteModel paciente = null;
        if (contasAPagarEntity.getPacienteId() != null) {
            paciente = pacienteRepository.findById(contasAPagarEntity.getPacienteId())
                    .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + contasAPagarEntity.getPacienteId()));
        }

        ContasAPagarModel contasAPagar = contasAPagarEntity.toModel(paciente, cliente);
        contasAPagar.setStatusConta(StatusConta.ABERTO);
        return contasAPagarRepository.save(contasAPagar);
    }

    public ContasAPagarModel atualizarContaAPagar(Integer clienteId, Integer id, ContasAPagarEntity contaAtualizadaEntity) {
        ContasAPagarModel contaExistente = buscarPorId(clienteId, id);

        PacienteModel paciente = null;
        if (contaAtualizadaEntity.getPacienteId() != null) {
            paciente = pacienteRepository.findById(contaAtualizadaEntity.getPacienteId())
                    .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + contaAtualizadaEntity.getPacienteId()));
        }

        contaExistente.setDescricao(contaAtualizadaEntity.getDescricao());
        contaExistente.setTipoConta(contaAtualizadaEntity.getTipoConta());
        contaExistente.setValor(contaAtualizadaEntity.getValor());
        contaExistente.setDataVencimento(contaAtualizadaEntity.getDataVencimento());
        contaExistente.setDataEmissao(contaAtualizadaEntity.getDataEmissao());
        contaExistente.setStatusConta(contaAtualizadaEntity.getStatusConta());
        contaExistente.setPaciente(paciente);

        return contasAPagarRepository.save(contaExistente);
    }

    public ContasAPagarModel buscarPorId(Integer clienteId, Integer id) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndId(cliente, id)
                .orElseThrow(() -> new NoSuchElementException("Conta a pagar não encontrada com o ID: " + id));
    }

    public List<ContasAPagarModel> buscarPorClienteETipoConta(Integer clienteId, String tipoConta) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndTipoConta(cliente, tipoConta);
    }

    public List<ContasAPagarModel> buscarPorClienteEStatus(Integer clienteId, StatusConta statusConta) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndStatusConta(cliente, statusConta);
    }

    public void removerContaAPagar(Integer clienteId, Integer id) {
        if (!contasAPagarRepository.existsByClienteIdAndId(clienteId, id)) {
            throw new NoSuchElementException("Conta a pagar não encontrada com o ID: " + id);
        }
        contasAPagarRepository.deleteById(id);
    }

    public List<ContasAPagarModel> listarContasAPagarPorCliente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByCliente(cliente);
    }

    public ContasAPagarModel pagarConta(Integer clienteId, Integer id) {
        ContasAPagarModel conta = buscarPorId(clienteId, id);
        conta.setStatusConta(StatusConta.PAGO);
        return contasAPagarRepository.save(conta);
    }

    public List<ContasAPagarModel> buscarPorClienteEPacienteIdEStatus(Integer clienteId, Integer pacienteId, StatusConta status) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));
        return contasAPagarRepository.findByClienteAndPacienteAndStatusConta(cliente, paciente, status);
    }

    public List<ContasAPagarModel> buscarPorClienteEPacienteId(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));
        return contasAPagarRepository.findByClienteAndPaciente(cliente, paciente);
    }
}
