package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.enums.Funcao;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.services.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{clienteId}/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarFuncionario(@PathVariable Integer clienteId, @RequestBody FuncionarioEntity funcionarioEntity) {
        try {
            funcionarioService.criarFuncionario(clienteId, funcionarioEntity);
            return ResponseEntity.ok("Funcionário criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @PutMapping("/{funcionarioId}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable Integer clienteId, @PathVariable Integer funcionarioId, @RequestBody FuncionarioEntity funcionarioEntity) {
        try {
            funcionarioService.atualizarFuncionario(clienteId, funcionarioId, funcionarioEntity);
            return ResponseEntity.ok("Funcionário atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @DeleteMapping("/{funcionarioId}")
    public ResponseEntity<?> removerFuncionario(@PathVariable Integer clienteId, @PathVariable Integer funcionarioId) {
        try {
            funcionarioService.removerFuncionario(clienteId, funcionarioId);
            return ResponseEntity.ok("Funcionário removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listarTodos(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(funcionarioService.findAllByCliente(clienteId));
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/{funcionarioId}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer clienteId, @PathVariable Integer funcionarioId) {
        try {
            return ResponseEntity.ok(funcionarioService.findByIdAndClienteId(funcionarioId, clienteId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable int clienteId, @PathVariable String email) {
        try {
            return ResponseEntity.ok(funcionarioService.buscarPorEmail(clienteId, email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable int clienteId, @PathVariable String cpf) {
        try {
            return ResponseEntity.ok(funcionarioService.buscarPorCpf(clienteId, cpf));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<FuncionarioModel>> buscarPorNome(@PathVariable int clienteId, @PathVariable String nome) {
        return ResponseEntity.ok(funcionarioService.buscarPorNome(clienteId, nome));
    }



    @PreAuthorize("hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/funcao/{funcao}")
    public ResponseEntity<List<FuncionarioModel>> buscarPorFuncao(@PathVariable int clienteId, @PathVariable Funcao funcao) {
        return ResponseEntity.ok(funcionarioService.buscarPorFuncao(clienteId, funcao));
    }
}
