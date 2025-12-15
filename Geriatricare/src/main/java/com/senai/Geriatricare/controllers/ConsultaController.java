package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.ConsultaEntity;
import com.senai.Geriatricare.models.ConsultaModel;
import com.senai.Geriatricare.services.ConsultaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{clienteId}/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarConsulta(@RequestBody ConsultaEntity consultaEntity) {
        try {
            ConsultaModel novaConsulta = consultaService.criarConsulta(consultaEntity);
            return ResponseEntity.ok(novaConsulta);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{consultaId}")
    public ResponseEntity<?> buscarPorClienteEId(@PathVariable Integer clienteId, @PathVariable Integer consultaId) {
        try {
            ConsultaModel consulta = consultaService.buscarPorClienteEId(clienteId, consultaId);
            return ResponseEntity.ok(consulta);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<?> buscarPorCliente(@PathVariable Integer clienteId) {
        try {
            List<ConsultaModel> consultas = consultaService.buscarPorCliente(clienteId);
            return ResponseEntity.ok(consultas);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<?> buscarPorClienteEPaciente(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        try {
            List<ConsultaModel> consultas = consultaService.buscarPorClienteEPaciente(clienteId, pacienteId);
            return ResponseEntity.ok(consultas);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/funcionario/{funcionarioId}")
    public ResponseEntity<?> buscarPorClienteEFuncionario(@PathVariable Integer clienteId, @PathVariable Integer funcionarioId) {
        try {
            List<ConsultaModel> consultas = consultaService.buscarPorClienteEFuncionario(clienteId, funcionarioId);
            return ResponseEntity.ok(consultas);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{consultaId}")
    public ResponseEntity<?> atualizarConsulta(@PathVariable Integer clienteId, @PathVariable Integer consultaId, @RequestBody ConsultaEntity consultaEntity) {
        try {
            ConsultaModel consultaAtualizada = consultaService.atualizarConsulta(consultaId, clienteId, consultaEntity);
            return ResponseEntity.ok(consultaAtualizada);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{consultaId}")
    public ResponseEntity<?> removerConsulta(@PathVariable Integer clienteId, @PathVariable Integer consultaId) {
        try {
            consultaService.removerConsulta(consultaId, clienteId);
            return ResponseEntity.ok("Consulta removida com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
