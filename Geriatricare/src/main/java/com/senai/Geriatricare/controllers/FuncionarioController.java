package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.services.FuncionarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<?> criarFuncionario(@RequestBody FuncionarioModel funcionarioModel) {
        try {
            funcionarioService.criarFuncionario(funcionarioModel);
            return ResponseEntity.ok("Funcionário criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable int id, @RequestBody FuncionarioModel funcionarioModel) {
        try {
            funcionarioModel.setId(id);
            funcionarioService.atualizarFuncionario(funcionarioModel);
            return ResponseEntity.ok("Funcionário atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerFuncionario(@PathVariable int id) {
        try {
            funcionarioService.removerFuncionario(id);
            return ResponseEntity.ok("Funcionário removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioEntity>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(funcionarioService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/email/{clienteId}/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable int clienteId, @PathVariable String email) {
        try {
            return ResponseEntity.ok(funcionarioService.buscarPorEmail(clienteId, email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cpf/{clienteId}/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable int clienteId, @PathVariable String cpf) {
        try {
            return ResponseEntity.ok(funcionarioService.buscarPorCpf(clienteId, cpf));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome/{clienteId}/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable int clienteId, @PathVariable String nome) {
        try {
            return ResponseEntity.ok(funcionarioService.buscarPorNome(clienteId, nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/funcao/{clienteId}/{funcao}")
    public ResponseEntity<List<FuncionarioEntity>> buscarPorFuncao(@PathVariable int clienteId, @PathVariable String funcao) {
        return ResponseEntity.ok(funcionarioService.buscarPorFuncao(clienteId, funcao));
    }
}