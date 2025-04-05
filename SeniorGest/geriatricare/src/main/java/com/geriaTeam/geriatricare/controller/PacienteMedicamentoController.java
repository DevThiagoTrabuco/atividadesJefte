package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.domain.PacienteMedicamento;
import com.geriaTeam.geriatricare.repositories.jpa.PacienteMedicamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacienteMedicamento/")
public class PacienteMedicamentoController {
    private final PacienteMedicamentoJPA pacienteMedicamentoJPA;

    @Autowired
    public PacienteMedicamentoController(PacienteMedicamentoJPA pacienteMedicamentoJPA) {
        this.pacienteMedicamentoJPA = pacienteMedicamentoJPA;
    }

    @GetMapping("")
    public List<PacienteMedicamento> getAll() {
        return this.pacienteMedicamentoJPA.findAll();
    }

    @GetMapping("{id}")
    public PacienteMedicamento getById(@PathVariable int id) {
        return this.pacienteMedicamentoJPA.findById(id).get();
    }

    @PostMapping("")
    public PacienteMedicamento save(@RequestBody PacienteMedicamento pacienteMedicamento) {
        return this.pacienteMedicamentoJPA.save(pacienteMedicamento);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.pacienteMedicamentoJPA.deleteById(id);
    }

    @PutMapping
    public PacienteMedicamento getById(@RequestBody PacienteMedicamento pacienteMedicamento) {
        return this.pacienteMedicamentoJPA.save(pacienteMedicamento);
    }
    
}
