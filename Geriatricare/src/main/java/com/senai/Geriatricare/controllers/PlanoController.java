package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.enums.TipoPlano;
import com.senai.Geriatricare.models.PlanoModel;
import com.senai.Geriatricare.services.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/{clienteId}/planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @PostMapping
    public ResponseEntity<?> criarPlano(@PathVariable Integer clienteId, @RequestBody PlanoModel plano) {
        try {
            return ResponseEntity.ok(planoService.criarPlano(clienteId, plano));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @GetMapping
    public ResponseEntity<?> listarPlanosPorCliente(@PathVariable Integer clienteId) {
        try {
            return ResponseEntity.ok(planoService.listarPlanosPorCliente(clienteId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @GetMapping("/{planoId}")
    public ResponseEntity<?> buscarPlanoPorIdECliente(@PathVariable Integer clienteId, @PathVariable Integer planoId) {
        try {
            return ResponseEntity.ok(planoService.buscarPlanoPorIdECliente(planoId, clienteId));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @PutMapping("/{planoId}")
    public ResponseEntity<?> atualizarPlano(@PathVariable Integer clienteId, @PathVariable Integer planoId, @RequestBody PlanoModel plano) {
        try {
            return ResponseEntity.ok(planoService.atualizarPlano(planoId, clienteId, plano));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @DeleteMapping("/{planoId}")
    public ResponseEntity<?> deletarPlano(@PathVariable Integer clienteId, @PathVariable Integer planoId) {
        try {
            planoService.deletarPlano(planoId, clienteId);
            return ResponseEntity.ok("Plano deletado com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @GetMapping("/tipo/{tipoPlano}")
    public ResponseEntity<?> findByClienteAndTipoPlano(@PathVariable Integer clienteId, @PathVariable TipoPlano tipoPlano) {
        try {
            return ResponseEntity.ok(planoService.findByClienteAndTipoPlano(clienteId, tipoPlano));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
