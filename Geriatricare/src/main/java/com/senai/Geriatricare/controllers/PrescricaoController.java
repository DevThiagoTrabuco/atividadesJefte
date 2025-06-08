package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.PrescricaoEntity;
import com.senai.Geriatricare.models.PrescricaoModel;
import com.senai.Geriatricare.services.PrescricaoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{clienteId}/prescricoes")
public class PrescricaoController {

    private final PrescricaoService prescricaoService;

    @Autowired
    public PrescricaoController(PrescricaoService prescricaoService) {
        this.prescricaoService = prescricaoService;
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<?> criarPrescricao(@RequestBody PrescricaoModel prescricaoModel) {
        try {
            prescricaoService.criarPrescricao(prescricaoModel);
            return ResponseEntity.ok("Prescrição criada com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPrescricao(@PathVariable int id, @RequestBody PrescricaoModel prescricaoModel) {
        try {
            prescricaoModel.setId(id);
            prescricaoService.atualizarPrescricao(prescricaoModel);
            return ResponseEntity.ok("Prescrição atualizada com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPrescricao(@PathVariable int id) {
        try {
            prescricaoService.removerPrescricao(id);
            return ResponseEntity.ok("Prescrição removida com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping
    public ResponseEntity<List<PrescricaoEntity>> listarTodos() {
        return ResponseEntity.ok(prescricaoService.listarTodos());
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(prescricaoService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<PrescricaoEntity>> buscarPorPaciente(@PathVariable int clienteId, @PathVariable int pacienteId) {
        return ResponseEntity.ok(prescricaoService.buscarPorPaciente(clienteId, pacienteId));
    }
}