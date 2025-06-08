package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.EnderecoEntity;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import com.senai.Geriatricare.models.EnderecoModel;
import com.senai.Geriatricare.services.EnderecoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> criarEndereco(@RequestBody EnderecoModel enderecoModel) {
        try {
            enderecoService.criarEndereco(enderecoModel);
            return ResponseEntity.ok("Endereço criado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable int id, @RequestBody EnderecoModel enderecoModel) {
        try {
            enderecoModel.setId(id);
            enderecoService.atualizarEndereco(enderecoModel);
            return ResponseEntity.ok("Endereço atualizado com sucesso.");
        } catch (EntityNotFoundException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerEndereco(@PathVariable int id) {
        try {
            enderecoService.removerEndereco(id);
            return ResponseEntity.ok("Endereço removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<EnderecoEntity>> listarTodos() {
        return ResponseEntity.ok(enderecoService.listarTodos());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(enderecoService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{clienteId}")
    public ResponseEntity<?> buscarPorCliente(@PathVariable int clienteId) {
        try {
            return ResponseEntity.ok(enderecoService.buscarPorCliente(clienteId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE') or hasRole('ROLE_FUNCIONARIO')")
    @GetMapping("/{clienteId}/familiar/{familiarId}")
    public ResponseEntity<?> buscarPorFamiliar(@PathVariable int clienteId, @PathVariable int familiarId) {
        try {
            return ResponseEntity.ok(enderecoService.buscarPorFamiliar(clienteId, familiarId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENTE')")
    @GetMapping("/{clienteId}/funcionario/{funcionarioId}")
    public ResponseEntity<?> buscarPorFuncionario(@PathVariable int clienteId, @PathVariable int funcionarioId) {
        try {
            return ResponseEntity.ok(enderecoService.buscarPorFuncionario(clienteId, funcionarioId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/uf/{uf}")
    public List<EnderecoEntity> buscarPorUnidadeFederativa(@PathVariable UnidadeFederativa uf) {
        return enderecoService.buscarPorUnidadeFederativa(uf);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<EnderecoEntity>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(enderecoService.buscarPorCidade(cidade));
    }
}