package com.senai.Geriatricare.services;

import com.senai.Geriatricare.enums.TipoPlano;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.models.PlanoModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.PacienteRepository;
import com.senai.Geriatricare.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    private ClienteModel buscarClientePorId(Integer clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
    }

    public PlanoModel criarPlano(Integer clienteId, PlanoModel plano) {
        ClienteModel cliente = buscarClientePorId(clienteId);
        plano.setCliente(cliente);
        return planoRepository.save(plano);
    }

    public List<PlanoModel> listarPlanosPorCliente(Integer clienteId) {
        ClienteModel cliente = buscarClientePorId(clienteId);
        return planoRepository.findByCliente(cliente);
    }

    public PlanoModel buscarPlanoPorIdECliente(Integer planoId, Integer clienteId) {
        ClienteModel cliente = buscarClientePorId(clienteId);
        return planoRepository.findByIdAndCliente(planoId, cliente)
                .orElseThrow(() -> new NoSuchElementException("Plano com o ID " + planoId + " não encontrado para o cliente " + clienteId));
    }

    public PlanoModel atualizarPlano(Integer planoId, Integer clienteId, PlanoModel planoAtualizado) {
        PlanoModel planoExistente = buscarPlanoPorIdECliente(planoId, clienteId);
        planoExistente.setTipo(planoAtualizado.getTipo());
        planoExistente.setNome(planoAtualizado.getNome());
        planoExistente.setPreco(planoAtualizado.getPreco());
        return planoRepository.save(planoExistente);
    }

    public void deletarPlano(Integer planoId, Integer clienteId) {
        PlanoModel plano = buscarPlanoPorIdECliente(planoId, clienteId);
        planoRepository.delete(plano);
    }

    public List<PlanoModel> findByClienteAndTipoPlano(Integer clienteId, TipoPlano tipoPlano) {
        ClienteModel cliente = buscarClientePorId(clienteId);
        return planoRepository.findByClienteAndTipo(cliente, tipoPlano);
    }

}
