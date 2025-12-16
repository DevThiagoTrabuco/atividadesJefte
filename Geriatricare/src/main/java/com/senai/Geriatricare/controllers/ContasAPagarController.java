package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.ContasAPagarEntity;
import com.senai.Geriatricare.enums.StatusConta;
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
    public ResponseEntity<?> criarContaAPagar(@RequestBody ContasAPagarEntity contasAPagar, @PathVariable Integer clienteId) {
        try {
            ContasAPagarModel novaConta = contasAPagarService.criarContaAPagar(contasAPagar, clienteId);
            return ResponseEntity.ok(novaConta);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarContaAPagar(@PathVariable Integer id, @RequestBody ContasAPagarEntity contaAtualizada) {
        try {
            ContasAPagarModel conta = contasAPagarService.atualizarContaAPagar(id, contaAtualizada);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException | IllegalArgumentException e) {
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
    public ResponseEntity<?> listarContaAPagarPorCliente(@PathVariable Integer clienteId) {
        try{
            return ResponseEntity.ok(contasAPagarService.listarContaAPagarPorCliente(clienteId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/cnpj")
    public ResponseEntity<?> buscarPorClienteECnpj(@PathVariable Integer clienteId, @RequestParam String cnpj) {
        try {
            return ResponseEntity.ok(contasAPagarService.buscarPorClienteECnpj(clienteId, cnpj));
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
    @PutMapping("/{contaId}/associar-cliente")
    public ResponseEntity<?> associarContaAoCliente(@PathVariable Integer contaId, @PathVariable Integer clienteId) {
        try {
            ContasAPagarModel conta = contasAPagarService.associarContaAoCliente(contaId, clienteId);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{contaId}/associar-paciente/{pacienteId}")
    public ResponseEntity<?> associarContaAoPaciente(@PathVariable Integer contaId, @PathVariable Integer pacienteId) {
        try {
            ContasAPagarModel conta = contasAPagarService.associarContaAoPaciente(contaId, pacienteId);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{contaId}/pagar")
    public ResponseEntity<?> pagarConta(@PathVariable Integer contaId) {
        try {
            ContasAPagarModel conta = contasAPagarService.pagarConta(contaId);
            return ResponseEntity.ok(conta);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/paciente/{pacienteId}/status/{status}")
    public ResponseEntity<?> buscarPorClienteEPacienteIdEStatus(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @PathVariable StatusConta status) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteEPacienteIdEStatus(clienteId, pacienteId, status);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<?> buscarPorClienteEPacienteId(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteEPacienteId(clienteId, pacienteId);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/sem-paciente/status/{status}")
    public ResponseEntity<?> buscarPorClienteSemPacienteEStatus(@PathVariable Integer clienteId, @PathVariable StatusConta status) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteSemPacienteEStatus(clienteId, status);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/sem-paciente")
    public ResponseEntity<?> buscarPorClienteSemPaciente(@PathVariable Integer clienteId) {
        try {
            List<ContasAPagarModel> contas = contasAPagarService.buscarPorClienteSemPaciente(clienteId);
            return ResponseEntity.ok(contas);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
