package com.geriaTeam.geriatricare.applications;


import com.geriaTeam.geriatricare.Interfaces.MedicamentoRepository;
import com.geriaTeam.geriatricare.models.domain.Indicador;
import com.geriaTeam.geriatricare.models.domain.Medicamento;
import com.geriaTeam.geriatricare.repositories.jpa.IndicadorJPA;
import com.geriaTeam.geriatricare.repositories.jpa.MedicamentoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/medicamento/")
public class MedicamentoApplication {
    private final MedicamentoJPA medicamentoJPA;


    @Autowired
    public MedicamentoApplication(MedicamentoJPA medicamentoJPA) {
        this.medicamentoJPA = medicamentoJPA;
    }

    @GetMapping("")
    public List<Medicamento> getAll() {
        return this.medicamentoJPA.findAll();
    }

    @GetMapping("{id}")
    public Medicamento getById(@PathVariable int id) {
        return this.medicamentoJPA.findById(id).get();
    }

    @PostMapping("")
    public Medicamento save(@RequestBody Medicamento medicamento) {
        return this.medicamentoJPA.save(medicamento);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.medicamentoJPA.deleteById(id);
    }

    @PutMapping
    public Medicamento getById(@RequestBody Medicamento medicamento) {
        return this.medicamentoJPA.save(medicamento);
    }
}
