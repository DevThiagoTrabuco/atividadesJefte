package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Funcao;
import com.geriaTeam.geriatricare.repositories.jpa.FuncaoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcao/")
public class FuncaoApplication {
    private final FuncaoJPA funcaoJPA;


    @Autowired
    public FuncaoApplication(FuncaoJPA funcaoJPA) {
        this.funcaoJPA = funcaoJPA;
    }

    @GetMapping("")
    public List<Funcao> getAll() {
        return this.funcaoJPA.findAll();
    }

    @GetMapping("{id}")
    public Funcao getById(@PathVariable int id) {
        return this.funcaoJPA.findById(id).get();
    }

    @PostMapping("")
    public Funcao save(@RequestBody Funcao funcao) {
        return this.funcaoJPA.save(funcao);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.funcaoJPA.deleteById(id);
    }

    @PutMapping
    public Funcao getById(@RequestBody Funcao funcao) {
        return this.funcaoJPA.save(funcao);
    }
}

