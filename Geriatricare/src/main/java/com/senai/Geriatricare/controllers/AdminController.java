package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.services.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<?> criarAdmin(@RequestBody AdminModel adminModel) {
        try {
            adminService.criarAdmin(adminModel);
            return ResponseEntity.ok("Administrador criado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarAdmin(@PathVariable int id, @RequestBody AdminModel adminModel) {
        try {
            adminModel.setId(id);
            adminService.atualizarAdmin(adminModel);
            return ResponseEntity.ok("Administrador atualizado com sucesso.");
        } catch (EntityNotFoundException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAdmin(@PathVariable int id) {
        try {
            adminService.removerAdmin(id);
            return ResponseEntity.ok("Administrador removido com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<AdminEntity>> listarTodos() {
        return ResponseEntity.ok(adminService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            return ResponseEntity.ok(adminService.buscarPorId(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(adminService.buscarPorEmail(email));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscarPorNome(@PathVariable String nome) {
        try {
            return ResponseEntity.ok(adminService.buscarPorNome(nome));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}