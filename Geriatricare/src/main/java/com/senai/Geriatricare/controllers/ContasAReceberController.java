package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.models.ContasAReceberModel;
import com.senai.Geriatricare.services.ContasAReceberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/{clienteId}/contas-a-receber")
public class ContasAReceberController {

    @Autowired
    private ContasAReceberService contasAReceberService;

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping("/paciente/{pacienteId}")
    public ResponseEntity<?> criarContaAReceber(@RequestBody ContasAReceberModel contaAReceber, @PathVariable Integer pacienteId, @PathVariable Integer clienteId) {
        try {
            ContasAReceberModel novaConta = contasAReceberService.criarContaAReceber(contaAReceber, pacienteId, clienteId);
            return ResponseEntity.ok(novaConta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarContaAReceber(@PathVariable Integer id, @RequestBody ContasAReceberModel contaAtualizada) {
        try {
            ContasAReceberModel conta = contasAReceberService.atualizarContaAReceber(id, contaAtualizada);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(contasAReceberService.buscarPorId(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerContaAReceber(@PathVariable Integer id) {
        try {
            contasAReceberService.removerContaAReceber(id);
            return ResponseEntity.ok("Conta a receber removida com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<?> listarContasAReceberPorCliente(@PathVariable Integer clienteId) {
        try{
            return ResponseEntity.ok(contasAReceberService.listarContasAReceberPorCliente(clienteId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
