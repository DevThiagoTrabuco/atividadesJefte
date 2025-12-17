package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.ObservacaoEntity;
import com.senai.Geriatricare.models.ObservacaoModel;
import com.senai.Geriatricare.services.ObservacaoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{clienteId}/pacientes/{pacienteId}/observacoes")
public class ObservacaoController {

    private final ObservacaoService observacaoService;

    @Autowired
    public ObservacaoController(ObservacaoService observacaoService) {
        this.observacaoService = observacaoService;
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarObservacao(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @RequestBody ObservacaoEntity observacaoEntity) {
        try {
            observacaoService.criarObservacao(clienteId, pacienteId, observacaoEntity);
            return ResponseEntity.ok("Observação criada com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{observacaoId}")
    public ResponseEntity<?> atualizarObservacao(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @PathVariable Integer observacaoId, @RequestBody ObservacaoEntity observacaoEntity) {
        try {
            observacaoService.atualizarObservacao(clienteId, pacienteId, observacaoId, observacaoEntity);
            return ResponseEntity.ok("Observação atualizada com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{observacaoId}")
    public ResponseEntity<?> removerObservacao(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @PathVariable Integer observacaoId) {
        try {
            observacaoService.removerObservacao(clienteId, pacienteId, observacaoId);
            return ResponseEntity.ok("Observação removida com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<List<ObservacaoModel>> listarTodos(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        return ResponseEntity.ok(observacaoService.buscarPorPaciente(clienteId, pacienteId));
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{observacaoId}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @PathVariable Integer observacaoId) {
        try {
            return ResponseEntity.ok(observacaoService.buscarPorId(clienteId, pacienteId, observacaoId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
