package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Historico;
import com.geriaTeam.geriatricare.repositories.jpa.HistoricoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Service
@RestController
@RequestMapping("/api/historico/")
public class HistoricoApplication {
    private final HistoricoJPA historicoJPA;


    @Autowired
    public HistoricoApplication(HistoricoJPA historicoJPA) {
        this.historicoJPA = historicoJPA;
    }

    @GetMapping("")
    public List<Historico> getAll() {
        return this.historicoJPA.findAll();
    }

    @GetMapping("{id}")
    public Historico getById(@PathVariable int id) {
        return this.historicoJPA.findById(id).get();
    }

    @PostMapping("")
    public Historico save(@RequestBody Historico historico) {
        return this.historicoJPA.save(historico);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.historicoJPA.deleteById(id);
    }

    @PutMapping
    public Historico getById(@RequestBody Historico historico) {
        return this.historicoJPA.save(historico);
    }
}