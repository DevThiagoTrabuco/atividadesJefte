package com.senai.Geriatricare.services;

import com.senai.Geriatricare.entities.ContasAPagarEntity;
import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.enums.TipoConta;
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

    public ContasAPagarModel criarContaAPagar(ContasAPagarEntity contasAPagarEntity, Integer clienteId) {
        ContasAPagarModel contasAPagar = contasAPagarEntity.toModel();
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        contasAPagar.setCliente(cliente);
        contasAPagar.setStatusConta(StatusConta.ABERTO);
        return contasAPagarRepository.save(contasAPagar);
    }

    public ContasAPagarModel atualizarContaAPagar(Integer id, ContasAPagarEntity contaAtualizadaEntity) {
        ContasAPagarModel contaAtualizada = contaAtualizadaEntity.toModel();
        ContasAPagarModel contaExistente = contasAPagarRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conta a pagar não encontrada com o ID: " + id));

        contaExistente.setDescricao(contaAtualizada.getDescricao());
        contaExistente.setTipoConta(contaAtualizada.getTipoConta());
        contaExistente.setChaveNFE(contaAtualizada.getChaveNFE());
        contaExistente.setSerieNFE(contaAtualizada.getSerieNFE());
        contaExistente.setCNPJ(contaAtualizada.getCNPJ());
        contaExistente.setValor(contaAtualizada.getValor());
        contaExistente.setDataVencimento(contaAtualizada.getDataVencimento());
        contaExistente.setDataEmissao(contaAtualizada.getDataEmissao());
        contaExistente.setStatusConta(contaAtualizada.getStatusConta());

        return contasAPagarRepository.save(contaExistente);
    }

    public ContasAPagarModel buscarPorId(Integer id) {
        return contasAPagarRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conta a pagar não encontrada com o ID: " + id));
    }

    public List<ContasAPagarModel> buscarPorClienteECnpj(Integer clienteId, String cnpj) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndCNPJ(cliente, cnpj);
    }

    public List<ContasAPagarModel> buscarPorClienteETipoConta(Integer clienteId, TipoConta tipoConta) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndTipoConta(cliente, tipoConta);
    }

    public List<ContasAPagarModel> buscarPorClienteEChaveNFE(Integer clienteId, String chaveNFE) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndChaveNFE(cliente, chaveNFE);
    }

    public List<ContasAPagarModel> buscarPorClienteEStatus(Integer clienteId, StatusConta statusConta) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndStatusConta(cliente, statusConta);
    }

    public void removerContaAPagar(Integer id) {
        if (!contasAPagarRepository.existsById(id)) {
            throw new NoSuchElementException("Conta a pagar não encontrada com o ID: " + id);
        }
        contasAPagarRepository.deleteById(id);
    }

    public List<ContasAPagarModel> listarContaAPagarPorCliente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByCliente(cliente);
    }

    public ContasAPagarModel pagarConta(Integer id) {
        ContasAPagarModel conta = contasAPagarRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conta a pagar não encontrada com o ID: " + id));
        conta.setStatusConta(StatusConta.PAGO);
        return contasAPagarRepository.save(conta);
    }

    public ContasAPagarModel associarContaAoCliente(Integer contaId, Integer clienteId) {
        ContasAPagarModel conta = contasAPagarRepository.findById(contaId)
                .orElseThrow(() -> new NoSuchElementException("Conta a pagar não encontrada com o ID: " + contaId));
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        conta.setCliente(cliente);
        return contasAPagarRepository.save(conta);
    }

    public ContasAPagarModel associarContaAoPaciente(Integer contaId, Integer pacienteId) {
        ContasAPagarModel conta = contasAPagarRepository.findById(contaId)
                .orElseThrow(() -> new NoSuchElementException("Conta a pagar não encontrada com o ID: " + contaId));
        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new NoSuchElementException("Paciente não encontrado com o ID: " + pacienteId));
        conta.setPaciente(paciente);
        return contasAPagarRepository.save(conta);
    }

    public List<ContasAPagarModel> buscarPorClienteEPacienteIdEStatus(Integer clienteId, Integer pacienteId, StatusConta status) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndPacienteIdAndStatusConta(cliente, pacienteId, status);
    }

    public List<ContasAPagarModel> buscarPorClienteEPacienteId(Integer clienteId, Integer pacienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndPacienteId(cliente, pacienteId);
    }

    public List<ContasAPagarModel> buscarPorClienteSemPacienteEStatus(Integer clienteId, StatusConta status) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndPacienteIsNullAndStatusConta(cliente, status);
    }

    public List<ContasAPagarModel> buscarPorClienteSemPaciente(Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        return contasAPagarRepository.findByClienteAndPacienteIsNull(cliente);
    }
}
