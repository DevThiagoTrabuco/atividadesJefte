package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.enums.TipoConta;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.services.ContasAPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/{clienteId}/contas-a-pagar")
public class ContasAPagarController {

    @Autowired
    private ContasAPagarService contasAPagarService;

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarContaAPagar(@RequestBody ContasAPagarModel contasAPagar, @PathVariable Integer clienteId) {
        try {
            ContasAPagarModel novaConta = contasAPagarService.criarContaAPagar(contasAPagar, clienteId);
            return ResponseEntity.ok(novaConta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarContaAPagar(@PathVariable Integer id, @RequestBody ContasAPagarModel contaAtualizada) {
        try {
            ContasAPagarModel conta = contasAPagarService.atualizarContaAPagar(id, contaAtualizada);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(contasAPagarService.buscarPorId(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerContaAPagar(@PathVariable Integer id) {
        try {
            contasAPagarService.removerContaAPagar(id);
            return ResponseEntity.ok("Conta a pagar removida com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<?> listarContaAPagarByPorCliente(@PathVariable Integer clienteId) {
        try{
            return ResponseEntity.ok(contasAPagarService.listarContaAPagarPorCliente(clienteId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<?> buscarPorCnpj(@PathVariable String cnpj) {
        try {
            return ResponseEntity.ok(contasAPagarService.buscarPorCnpj(cnpj));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/tipo-conta/{tipoConta}")
    public ResponseEntity<?> buscarPorClienteETipoConta(@PathVariable Integer clienteId, @PathVariable TipoConta tipoConta) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteETipoConta(clienteId, tipoConta);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/chave-nfe/{chaveNFE}")
    public ResponseEntity<?> buscarPorClienteEChaveNFE(@PathVariable Integer clienteId, @PathVariable String chaveNFE) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteEChaveNFE(clienteId, chaveNFE);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
