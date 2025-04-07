package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.domain.Historico;
import com.geriaTeam.geriatricare.models.domain.Indicador;

import java.util.List;

import com.geriaTeam.geriatricare.repositories.jpa.HistoricoJPA;
import com.geriaTeam.geriatricare.repositories.jpa.IndicadorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/api/indicador/")
public class IndicadorApplication {
    private final IndicadorJPA indicadorJPA;


    @Autowired
    public IndicadorApplication(IndicadorJPA indicadorJPA) {
        this.indicadorJPA = indicadorJPA;
    }

    @GetMapping("")
    public List<Indicador> getAll() {
        return this.indicadorJPA.findAll();
    }

    @GetMapping("{id}")
    public Indicador getById(@PathVariable int id) {
        return this.indicadorJPA.findById(id).get();
    }

    @PostMapping("")
    public Indicador save(@RequestBody Indicador indicador) {
        return this.indicadorJPA.save(indicador);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.indicadorJPA.deleteById(id);
    }

    @PutMapping
    public Indicador getById(@RequestBody Indicador indicador) {
        return this.indicadorJPA.save(indicador);
    }
}
