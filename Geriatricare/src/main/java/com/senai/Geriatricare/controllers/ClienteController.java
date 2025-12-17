package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteEntity clienteEntity) {
        try {
            clienteService.criarCliente(clienteEntity);
            return ResponseEntity.ok("Cliente criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable int id, @RequestBody ClienteEntity clienteEntity) {
        try {
            clienteEntity.setId(id);
            clienteService.atualizarCliente(clienteEntity);
            return ResponseEntity.ok("Cliente atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerCliente(@PathVariable int id) {
        try {
            clienteService.removerCliente(id);
            return ResponseEntity.ok("Cliente removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorEmail(email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/cnpj")
    public ResponseEntity<?> buscarPorCnpj(@RequestParam("valor") String cnpj) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorCnpj(cnpj));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClienteModel>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteService.buscarPorNome(nome));
    }
}
