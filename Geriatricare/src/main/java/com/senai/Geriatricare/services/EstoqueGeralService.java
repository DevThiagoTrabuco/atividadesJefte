package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.EstoqueGeralModel;
import com.senai.Geriatricare.models.ProdutoModel;
import com.senai.Geriatricare.repositories.ClienteRepository;
import com.senai.Geriatricare.repositories.EstoqueGeralRepository;
import com.senai.Geriatricare.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EstoqueGeralService {

    @Autowired
    private EstoqueGeralRepository estoqueGeralRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public EstoqueGeralModel createEstoqueGeral(EstoqueGeralModel estoqueGeral, Integer clienteId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        estoqueGeral.setCliente(cliente);
        return estoqueGeralRepository.save(estoqueGeral);
    }

    public List<EstoqueGeralModel> findEstoqueGeralByProduto(Integer produtoId) {
        ProdutoModel produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado com o ID: " + produtoId));
        return estoqueGeralRepository.findByProduto(produto);
    }

    public List<EstoqueGeralModel> findEstoqueGeralByClienteAndProduto(Integer clienteId, Integer produtoId) {
        ClienteModel cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado com o ID: " + clienteId));
        ProdutoModel produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado com o ID: " + produtoId));
        return estoqueGeralRepository.findByClienteAndProduto(cliente, produto);
    }
}
