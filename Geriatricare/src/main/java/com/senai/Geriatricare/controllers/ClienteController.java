package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.services.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteModel clienteModel) {
        try {
            clienteService.criarCliente(clienteModel);
            return ResponseEntity.ok("Cliente criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable int id, @RequestBody ClienteModel clienteModel) {
        try {
            clienteModel.setId(id);
            clienteService.atualizarCliente(clienteModel);
            return ResponseEntity.ok("Cliente atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerCliente(@PathVariable int id) {
        try {
            clienteService.removerCliente(id);
            return ResponseEntity.ok("Cliente removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorEmail(email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<?> buscarPorCnpj(@PathVariable String cnpj) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorCnpj(cnpj));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorNome(nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<?> buscarPorAdmin(@PathVariable int adminId) {
        try {
            return ResponseEntity.ok(clienteService.buscarPorAdmin(adminId));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}