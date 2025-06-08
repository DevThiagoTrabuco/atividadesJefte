package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.models.MedicamentoModel;
import com.senai.Geriatricare.services.MedicamentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @Autowired
    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<?> criarMedicamento(@RequestBody MedicamentoModel medicamentoModel) {
        try {
            medicamentoService.criarMedicamento(medicamentoModel);
            return ResponseEntity.ok("Medicamento criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerMedicamento(@PathVariable int id) {
        try {
            medicamentoService.removerMedicamento(id);
            return ResponseEntity.ok("Medicamento removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoEntity>> listarTodos() {
        return ResponseEntity.ok(medicamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(medicamentoService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome-generico/{clienteId}/{nomeGenerico}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorNomeGenerico(@PathVariable int clienteId, @PathVariable String nomeGenerico) {
        return ResponseEntity.ok(medicamentoService.buscarPorNomeGenerico(clienteId, nomeGenerico));
    }

    @GetMapping("/nome-comercial/{clienteId}/{nomeComercial}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorNomeComercial(@PathVariable int clienteId, @PathVariable String nomeComercial) {
        return ResponseEntity.ok(medicamentoService.buscarPorNomeComercial(clienteId, nomeComercial));
    }

    @GetMapping("/data-validade/{clienteId}/{dataValidade}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorDataValidade(@PathVariable int clienteId, @PathVariable LocalDate dataValidade) {
        return ResponseEntity.ok(medicamentoService.buscarPorDataValidade(clienteId, dataValidade));
    }

    @GetMapping("/status/{clienteId}/{statusMedicamento}")
    public ResponseEntity<List<MedicamentoEntity>> buscarPorStatusMedicamento(@PathVariable int clienteId, @PathVariable String statusMedicamento) {
        return ResponseEntity.ok(medicamentoService.buscarPorStatusMedicamento(clienteId, statusMedicamento));
    }
}