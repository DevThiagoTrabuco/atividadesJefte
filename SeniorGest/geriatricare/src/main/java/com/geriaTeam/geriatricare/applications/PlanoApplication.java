package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Plano;
import com.geriaTeam.geriatricare.repositories.jpa.PlanoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/plano/")
public class PlanoApplication {
    private final PlanoJPA planoJPA;


    @Autowired
    public PlanoApplication(PlanoJPA pacienteJPA) {
        this.planoJPA = pacienteJPA;
    }

    @GetMapping("")
    public List<Plano> getAll() {
        return this.planoJPA.findAll();
    }

    @GetMapping("{id}")
    public Plano getById(@PathVariable int id) {
        return this.planoJPA.findById(id).get();
    }

    @PostMapping("")
    public Plano save(@RequestBody Plano plano) {
        return this.planoJPA.save(plano);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.planoJPA.deleteById(id);
    }

    @PutMapping
    public Plano getById(@RequestBody Plano plano) {
        return this.planoJPA.save(plano);
    }
}

