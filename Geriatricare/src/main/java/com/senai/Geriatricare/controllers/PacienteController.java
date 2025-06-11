package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.services.PacienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{clienteId}/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @PostMapping
    public ResponseEntity<?> criarPaciente(@RequestBody PacienteModel pacienteModel) {
        try {
            pacienteService.criarPaciente(pacienteModel);
            return ResponseEntity.ok("Paciente criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPaciente(@PathVariable int id, @RequestBody PacienteModel pacienteModel) {
        try {
            pacienteModel.setId(id);
            pacienteService.atualizarPaciente(pacienteModel);
            return ResponseEntity.ok("Paciente atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPaciente(@PathVariable int id) {
        try {
            pacienteService.removerPaciente(id);
            return ResponseEntity.ok("Paciente removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping
    public ResponseEntity<List<PacienteEntity>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable int clienteId, @PathVariable String nome) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorNome(clienteId, nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable int clienteId, @PathVariable String cpf) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorCpf(clienteId, cpf));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/rg/{rg}")
    public ResponseEntity<?> buscarPorRg(@PathVariable int clienteId, @PathVariable String rg) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorRg(clienteId, rg));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/familiar/{familiarId}")
    public ResponseEntity<List<PacienteEntity>> buscarPorFamiliar(@PathVariable int clienteId, @PathVariable int familiarId) {
        return ResponseEntity.ok(pacienteService.buscarPorFamiliar(clienteId, familiarId));
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/status/{statusPaciente}")
    public ResponseEntity<List<PacienteEntity>> buscarPorStatusPaciente(@PathVariable int clienteId, @PathVariable StatusPaciente statusPaciente) {
        return ResponseEntity.ok(pacienteService.buscarPorStatusPaciente(clienteId, statusPaciente));
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<PacienteEntity>> buscarPorGenero(@PathVariable int clienteId, @PathVariable Genero genero) {
        return ResponseEntity.ok(pacienteService.buscarPorGenero(clienteId, genero));
    }

    @PreAuthorize("hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/plano/{plano}")
    public ResponseEntity<List<PacienteEntity>> buscarPorPlano(@PathVariable int clienteId, @PathVariable String plano) {
        return ResponseEntity.ok(pacienteService.buscarPorPlano(clienteId, plano));
    }
}