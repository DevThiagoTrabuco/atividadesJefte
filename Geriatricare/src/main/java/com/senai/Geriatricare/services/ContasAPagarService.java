package com.senai.Geriatricare.services;

import com.senai.Geriatricare.enums.TipoConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.ContasAPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContasAPagarService {

    @Autowired
    private ContasAPagarRepository contasAPagarRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ContasAPagarModel criarContaAPagar(ContasAPagarModel contasAPagar, Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        contasAPagar.setCliente(cliente);
        return contasAPagarRepository.save(contasAPagar);
    }

    public List<ContasAPagarModel> buscarPorCnpj(String cnpj) {
        return contasAPagarRepository.findByCliente_Cnpj(cnpj);
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
}
