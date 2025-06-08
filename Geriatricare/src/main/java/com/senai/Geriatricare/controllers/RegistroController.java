package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.RegistroEntity;
import com.senai.Geriatricare.models.RegistroModel;
import com.senai.Geriatricare.services.RegistroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    private final RegistroService registroService;

    @Autowired
    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @PostMapping
    public ResponseEntity<?> criarRegistro(@RequestBody RegistroModel registroModel) {
        try {
            registroService.criarRegistro(registroModel);
            return ResponseEntity.ok("Registro criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarRegistro(@PathVariable int id, @RequestBody RegistroModel registroModel) {
        try {
            registroModel.setId(id);
            registroService.atualizarRegistro(registroModel);
            return ResponseEntity.ok("Registro atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerRegistro(@PathVariable int id) {
        try {
            registroService.removerRegistro(id);
            return ResponseEntity.ok("Registro removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<RegistroEntity>> listarTodos() {
        return ResponseEntity.ok(registroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(registroService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/entidade/{clienteId}/{entidade}/{entidadeId}")
    public ResponseEntity<List<RegistroEntity>> buscarPorEntidadeEId(
            @PathVariable int clienteId,
            @PathVariable String entidade,
            @PathVariable int entidadeId) {
        return ResponseEntity.ok(registroService.buscarPorEntidadeEId(clienteId, entidade, entidadeId));
    }

    @GetMapping("/entidade/{clienteId}/{entidade}")
    public ResponseEntity<List<RegistroEntity>> buscarPorEntidade(
            @PathVariable int clienteId,
            @PathVariable String entidade) {
        return ResponseEntity.ok(registroService.buscarPorEntidade(clienteId, entidade));
    }

    @GetMapping("/funcionario/{clienteId}/{funcionarioId}")
    public ResponseEntity<List<RegistroEntity>> buscarPorFuncionario(
            @PathVariable int clienteId,
            @PathVariable int funcionarioId) {
        return ResponseEntity.ok(registroService.buscarPorFuncionario(clienteId, funcionarioId));
    }

    @GetMapping("/data/{clienteId}/{dataHora}")
    public ResponseEntity<List<RegistroEntity>> buscarPorData(
            @PathVariable int clienteId,
            @PathVariable String dataHora) {
        LocalDateTime data = LocalDateTime.parse(dataHora);
        return ResponseEntity.ok(registroService.buscarPorData(clienteId, data));
    }
}