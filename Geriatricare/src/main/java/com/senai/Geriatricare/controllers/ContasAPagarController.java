package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.ContasAPagarEntity;
import com.senai.Geriatricare.enums.StatusConta;
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
    public ResponseEntity<?> criarContaAPagar(@PathVariable Integer clienteId, @RequestBody ContasAPagarEntity contasAPagar) {
        try {
            contasAPagar.setClienteId(clienteId);
            ContasAPagarModel novaConta = contasAPagarService.criarContaAPagar(contasAPagar);
            return ResponseEntity.ok(novaConta);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarContaAPagar(@PathVariable Integer clienteId, @PathVariable Integer id, @RequestBody ContasAPagarEntity contaAtualizada) {
        try {
            ContasAPagarModel conta = contasAPagarService.atualizarContaAPagar(clienteId, id, contaAtualizada);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer clienteId, @PathVariable Integer id) {
        try {
            return ResponseEntity.ok(contasAPagarService.buscarPorId(clienteId, id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerContaAPagar(@PathVariable Integer clienteId, @PathVariable Integer id) {
        try {
            contasAPagarService.removerContaAPagar(clienteId, id);
            return ResponseEntity.ok("Conta a pagar removida com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<?> listarContasAPagarPorCliente(@PathVariable Integer clienteId) {
        try{
            return ResponseEntity.ok(contasAPagarService.listarContasAPagarPorCliente(clienteId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/tipo-conta/{tipoConta}")
    public ResponseEntity<?> buscarPorClienteETipoConta(@PathVariable Integer clienteId, @PathVariable String tipoConta) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteETipoConta(clienteId, tipoConta);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/status/{statusConta}")
    public ResponseEntity<?> buscarPorClienteEStatus(@PathVariable Integer clienteId, @PathVariable StatusConta statusConta) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteEStatus(clienteId, statusConta);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{contaId}/pagar")
    public ResponseEntity<?> pagarConta(@PathVariable Integer clienteId, @PathVariable Integer contaId) {
        try {
            ContasAPagarModel conta = contasAPagarService.pagarConta(clienteId, contaId);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/pacientes/{pacienteId}/status/{status}")
    public ResponseEntity<?> buscarPorClienteEPacienteIdEStatus(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @PathVariable StatusConta status) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteEPacienteIdEStatus(clienteId, pacienteId, status);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/pacientes/{pacienteId}")
    public ResponseEntity<?> buscarPorClienteEPacienteId(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteEPacienteId(clienteId, pacienteId);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
