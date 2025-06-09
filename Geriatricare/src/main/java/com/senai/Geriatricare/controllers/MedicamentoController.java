package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.models.MedicamentoModel;
import com.senai.Geriatricare.services.MedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/{clienteId}/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<?> criarMedicamento(@RequestBody MedicamentoModel medicamentoModel) {
        try {
            medicamentoService.criarMedicamento(medicamentoModel);
            return ResponseEntity.ok("Medicamento criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarMedicamento(@PathVariable int id, @RequestBody MedicamentoModel medicamentoModel) {
        try {
            medicamentoModel.setId(id);
            medicamentoService.atualizarMedicamento(medicamentoModel);
            return ResponseEntity.ok("Medicamento atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerMedicamento(@PathVariable int id) {
        try {
            medicamentoService.removerMedicamento(id);
            return ResponseEntity.ok("Medicamento removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping
    public ResponseEntity<List<MedicamentoEntity>> listarTodos() {
        return ResponseEntity.ok(medicamentoService.listarTodos());
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(medicamentoService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/nome-generico/{nomeGenerico}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorNomeGenerico(@PathVariable int clienteId, @PathVariable String nomeGenerico) {
        return ResponseEntity.ok(medicamentoService.buscarPorNomeGenerico(clienteId, nomeGenerico));
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/nome-comercial/{nomeComercial}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorNomeComercial(@PathVariable int clienteId, @PathVariable String nomeComercial) {
        return ResponseEntity.ok(medicamentoService.buscarPorNomeComercial(clienteId, nomeComercial));
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/data-validade/{dataValidade}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorDataValidade(@PathVariable int clienteId, @PathVariable LocalDate dataValidade) {
        return ResponseEntity.ok(medicamentoService.buscarPorDataValidade(clienteId, dataValidade));
    }

    @PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/status/{statusMedicamento}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorStatusMedicamento(@PathVariable int clienteId, @PathVariable String statusMedicamento) {
        return ResponseEntity.ok(medicamentoService.buscarPorStatusMedicamento(clienteId, statusMedicamento));
    }
}