package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.services.FamiliarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familiares")
public class FamiliarController {

    private final FamiliarService familiarService;

    @Autowired
    public FamiliarController(FamiliarService familiarService) {
        this.familiarService = familiarService;
    }

    @PostMapping
    public ResponseEntity<?> criarFamiliar(@RequestBody FamiliarModel familiarModel) {
        try {
            familiarService.criarFamiliar(familiarModel);
            return ResponseEntity.ok("Familiar criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFamiliar(@PathVariable int id, @RequestBody FamiliarModel familiarModel) {
        try {
            familiarModel.setId(id);
            familiarService.atualizarFamiliar(familiarModel);
            return ResponseEntity.ok("Familiar atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerFamiliar(@PathVariable int id) {
        try {
            familiarService.removerFamiliar(id);
            return ResponseEntity.ok("Familiar removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<FamiliarEntity>> listarTodos() {
        return ResponseEntity.ok(familiarService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome/{clienteId}/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable int clienteId, @PathVariable String nome) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorNome(clienteId, nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/email/{clienteId}/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable int clienteId, @PathVariable String email) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorEmail(clienteId, email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cpf/{clienteId}/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable int clienteId, @PathVariable String cpf) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorCpf(clienteId, cpf));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/rg/{clienteId}/{rg}")
    public ResponseEntity<?> buscarPorRg(@PathVariable int clienteId, @PathVariable String rg) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorRg(clienteId, rg));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/paciente/{clienteId}/{pacienteId}")
    public ResponseEntity<List<FamiliarEntity>> buscarPorPaciente(@PathVariable int clienteId, @PathVariable int pacienteId) {
        return ResponseEntity.ok(familiarService.buscarPorPaciente(clienteId, pacienteId));
    }
}