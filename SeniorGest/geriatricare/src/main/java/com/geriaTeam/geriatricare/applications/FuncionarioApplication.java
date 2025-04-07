package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Funcionario;
import com.geriaTeam.geriatricare.repositories.jpa.FuncionarioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/funcionario/")
public class FuncionarioApplication {
    private final FuncionarioJPA funcionarioJPA;


    @Autowired
    public FuncionarioApplication(FuncionarioJPA funcionarioJPA) {
        this.funcionarioJPA = funcionarioJPA;
    }

    @GetMapping("")
    public List<Funcionario> getAll() {
        return this.funcionarioJPA.findAll();
    }

    @GetMapping("{id}")
    public Funcionario getById(@PathVariable int id) {
        return this.funcionarioJPA.findById(id).get();
    }

    @PostMapping("")
    public Funcionario save(@RequestBody Funcionario funcionario) {
        return this.funcionarioJPA.save(funcionario);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.funcionarioJPA.deleteById(id);
    }

    @PutMapping
    public Funcionario getById(@RequestBody Funcionario funcionario) {
        return this.funcionarioJPA.save(funcionario);
    }
}
