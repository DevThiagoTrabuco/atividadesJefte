package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.entities.FamiliarEntity;
import com.senai.Geriatricare.services.FamiliarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{clienteId}/familiares")
public class FamiliarController {

    private final FamiliarService familiarService;

    @Autowired
    public FamiliarController(FamiliarService familiarService) {
        this.familiarService = familiarService;
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarFamiliar(@RequestBody FamiliarEntity familiarEntity) {
        try {
            familiarService.criarFamiliar(familiarEntity);
            return ResponseEntity.ok("Familiar criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFamiliar(@PathVariable int id, @RequestBody FamiliarEntity familiarEntity) {
        try {
            familiarEntity.setId(id);
            familiarService.atualizarFamiliar(familiarEntity);
            return ResponseEntity.ok("Familiar atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerFamiliar(@PathVariable int id) {
        try {
            familiarService.removerFamiliar(id);
            return ResponseEntity.ok("Familiar removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<List<FamiliarModel>> listarTodos() {
        return ResponseEntity.ok(familiarService.listarTodos());
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable int clienteId, @PathVariable String nome) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorNome(clienteId, nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable int clienteId, @PathVariable String email) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorEmail(clienteId, email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable int clienteId, @PathVariable String cpf) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorCpf(clienteId, cpf));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/rg/{rg}")
    public ResponseEntity<?> buscarPorRg(@PathVariable int clienteId, @PathVariable String rg) {
        try {
            return ResponseEntity.ok(familiarService.buscarPorRg(clienteId, rg));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<FamiliarModel>> buscarPorPaciente(@PathVariable int clienteId, @PathVariable int pacienteId) {
        return ResponseEntity.ok(familiarService.buscarPorPaciente(clienteId, pacienteId));
    }
}