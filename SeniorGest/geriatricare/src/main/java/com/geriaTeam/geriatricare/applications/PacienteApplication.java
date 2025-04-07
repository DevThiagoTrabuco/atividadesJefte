package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.domain.Medicamento;
import com.geriaTeam.geriatricare.models.domain.Paciente;

import java.util.List;

import com.geriaTeam.geriatricare.repositories.jpa.MedicamentoJPA;
import com.geriaTeam.geriatricare.repositories.jpa.PacienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/api/paciente/")
public class PacienteApplication {
    private final PacienteJPA pacienteJPA;


    @Autowired
    public PacienteApplication(PacienteJPA pacienteJPA) {
        this.pacienteJPA = pacienteJPA;
    }

    @GetMapping("")
    public List<Paciente> getAll() {
        return this.pacienteJPA.findAll();
    }

    @GetMapping("{id}")
    public Paciente getById(@PathVariable int id) {
        return this.pacienteJPA.findById(id).get();
    }

    @PostMapping("")
    public Paciente save(@RequestBody Paciente paciente) {
        return this.pacienteJPA.save(paciente);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.pacienteJPA.deleteById(id);
    }

    @PutMapping
    public Paciente getById(@RequestBody Paciente paciente) {
        return this.pacienteJPA.save(paciente);
    }
}

