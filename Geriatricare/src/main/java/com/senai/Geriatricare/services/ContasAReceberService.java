package com.senai.Geriatricare.services;

import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAReceberModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ContasAReceberRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContasAReceberService {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public ContasAReceberModel criarContaAReceber(ContasAReceberModel contaAReceber, Integer pacienteId, Integer clienteId) {
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));

        contaAReceber.setPaciente(paciente);
        contaAReceber.setStatusConta(StatusConta.ABERTO);
        contaAReceber.setCliente(cliente);

        return contasAReceberRepository.save(contaAReceber);
    }

    public ContasAReceberModel atualizarContaAReceber(Integer id, ContasAReceberModel contaAtualizada) {
        ContasAReceberModel contaExistente = contasAReceberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conta a receber não encontrada com o ID: " + id));

        contaExistente.setDescricao(contaAtualizada.getDescricao());
        contaExistente.setValor(contaAtualizada.getValor());
        contaExistente.setDataVencimento(contaAtualizada.getDataVencimento());
        contaExistente.setDataRecebimento(contaAtualizada.getDataRecebimento());
        contaExistente.setStatusConta(contaAtualizada.getStatusConta());

        return contasAReceberRepository.save(contaExistente);
    }

    public ContasAReceberModel buscarPorId(Integer id) {
        return contasAReceberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conta a receber não encontrada com o ID: " + id));
    }

    public void removerContaAReceber(Integer id) {
        if (!contasAReceberRepository.existsById(id)) {
            throw new NoSuchElementException("Conta a receber não encontrada com o ID: " + id);
        }
        contasAReceberRepository.deleteById(id);
    }

    public List<ContasAReceberModel> listarContasAReceberPorCliente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAReceberRepository.findByCliente(cliente);
    }

    public List<ContasAReceberModel> buscarPorClienteEPaciente(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));

        return contasAReceberRepository.findByClienteAndPaciente(cliente, paciente);
    }

    public ContasAReceberModel pagarConta(Integer id) {
        ContasAReceberModel conta = contasAReceberRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conta a receber não encontrada com o ID: " + id));
        conta.setStatusConta(StatusConta.PAGO);
        return contasAReceberRepository.save(conta);
    }
}
