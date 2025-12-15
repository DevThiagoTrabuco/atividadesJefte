package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.AgendamentoEntity;
import com.senai.Geriatricare.models.AgendamentoModel;
import com.senai.Geriatricare.services.AgendamentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/{clienteId}/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarAgendamento(@RequestBody AgendamentoEntity agendamentoEntity) {
        try {
            AgendamentoModel novoAgendamento = agendamentoService.criarAgendamento(agendamentoEntity);
            return ResponseEntity.ok(novoAgendamento);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<?> buscarPorCliente(@PathVariable Integer clienteId) {
        try {
            List<AgendamentoModel> agendamentos = agendamentoService.buscarPorCliente(clienteId);
            return ResponseEntity.ok(agendamentos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{agendamentoId}")
    public ResponseEntity<?> buscarPorClienteEId(@PathVariable Integer clienteId, @PathVariable Integer agendamentoId) {
        try {
            AgendamentoModel agendamento = agendamentoService.buscarPorClienteEId(clienteId, agendamentoId);
            return ResponseEntity.ok(agendamento);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<?> buscarPorClienteEPaciente(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        try {
            List<AgendamentoModel> agendamentos = agendamentoService.buscarPorClienteEPaciente(clienteId, pacienteId);
            return ResponseEntity.ok(agendamentos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/data")
    public ResponseEntity<?> buscarPorClienteEDataHora(@PathVariable Integer clienteId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime data) {
        try {
            List<AgendamentoModel> agendamentos = agendamentoService.buscarPorClienteEDataHora(clienteId, data);
            return ResponseEntity.ok(agendamentos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/procedimento/{procedimento}")
    public ResponseEntity<?> buscarPorClienteEProcedimento(@PathVariable Integer clienteId, @PathVariable String procedimento) {
        try {
            List<AgendamentoModel> agendamentos = agendamentoService.buscarPorClienteEProcedimento(clienteId, procedimento);
            return ResponseEntity.ok(agendamentos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{agendamentoId}")
    public ResponseEntity<?> atualizarAgendamento(@PathVariable Integer clienteId, @PathVariable Integer agendamentoId, @RequestBody AgendamentoEntity agendamentoEntity) {
        try {
            AgendamentoModel agendamentoAtualizado = agendamentoService.atualizarAgendamento(clienteId, agendamentoId, agendamentoEntity);
            return ResponseEntity.ok(agendamentoAtualizado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{agendamentoId}")
    public ResponseEntity<?> removerAgendamento(@PathVariable Integer clienteId, @PathVariable Integer agendamentoId) {
        try {
            agendamentoService.removerAgendamento(clienteId, agendamentoId);
            return ResponseEntity.ok("Agendamento removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
