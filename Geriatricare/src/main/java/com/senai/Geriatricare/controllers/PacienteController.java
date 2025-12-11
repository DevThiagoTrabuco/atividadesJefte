package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.entities.PacienteEntity;
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

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarPaciente(@PathVariable Integer clienteId, @RequestBody PacienteEntity pacienteEntity) {
        try {
            pacienteService.criarPaciente(clienteId, pacienteEntity);
            return ResponseEntity.ok("Paciente criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @PutMapping("/{pacienteId}")
    public ResponseEntity<?> atualizarPaciente(@PathVariable Integer clienteId, @PathVariable Integer pacienteId, @RequestBody PacienteEntity pacienteEntity) {
        try {
            pacienteService.atualizarPaciente(clienteId, pacienteId, pacienteEntity);
            return ResponseEntity.ok("Paciente atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @DeleteMapping("/{pacienteId}")
    public ResponseEntity<?> removerPaciente(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        try {
            pacienteService.removerPaciente(clienteId, pacienteId);
            return ResponseEntity.ok("Paciente removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<List<PacienteModel>> listarTodos(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(pacienteService.findAllByCliente(clienteId));
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/{pacienteId}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer clienteId, @PathVariable Integer pacienteId) {
        try {
            return ResponseEntity.ok(pacienteService.findByIdAndClienteId(pacienteId, clienteId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable int clienteId, @PathVariable String nome) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorNome(clienteId, nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> buscarPorCpf(@PathVariable int clienteId, @PathVariable String cpf) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorCpf(clienteId, cpf));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/rg/{rg}")
    public ResponseEntity<?> buscarPorRg(@PathVariable int clienteId, @PathVariable String rg) {
        try {
            return ResponseEntity.ok(pacienteService.buscarPorRg(clienteId, rg));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/familiar/{familiarId}")
    public ResponseEntity<List<PacienteModel>> buscarPorFamiliar(@PathVariable int clienteId, @PathVariable int familiarId) {
        return ResponseEntity.ok(pacienteService.buscarPorFamiliar(clienteId, familiarId));
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/status/{statusPaciente}")
    public ResponseEntity<List<PacienteModel>> buscarPorStatusPaciente(@PathVariable int clienteId, @PathVariable StatusPaciente statusPaciente) {
        return ResponseEntity.ok(pacienteService.buscarPorStatusPaciente(clienteId, statusPaciente));
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<PacienteModel>> buscarPorGenero(@PathVariable int clienteId, @PathVariable Genero genero) {
        return ResponseEntity.ok(pacienteService.buscarPorGenero(clienteId, genero));
    }

    @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
    @GetMapping("/plano/{plano}")
    public ResponseEntity<List<PacienteModel>> buscarPorPlano(@PathVariable int clienteId, @PathVariable String plano) {
        return ResponseEntity.ok(pacienteService.buscarPorPlano(clienteId, plano));
    }
}