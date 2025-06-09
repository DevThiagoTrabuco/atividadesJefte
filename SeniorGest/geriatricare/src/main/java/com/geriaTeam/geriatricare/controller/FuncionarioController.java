package com.geriaTeam.geriatricare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geriaTeam.geriatricare.facade.FuncionarioFacade;
import com.geriaTeam.geriatricare.models.FuncionarioModels;

@RequestMapping("/funcionario")
@RestController
public class FuncionarioController {
    @Autowired
    private FuncionarioFacade funcionarioFacade;

    @GetMapping
    public List<FuncionarioModels> buscarTodosFuncionario() {
        return funcionarioFacade.buscarTodosFuncionario();
    }

    @GetMapping("/buscarFuncionarioId/{id}")
    public FuncionarioModels buscarFuncionarioId(@PathVariable int id) {
        return funcionarioFacade.buscarFuncionarioId(id);
    }

    @PostMapping("/adicionarFuncionario")
    public void adicionarFuncionario(@RequestBody FuncionarioModels funcionarioModels) {
        funcionarioFacade.adicionarFuncionario(funcionarioModels);
    }

    @PutMapping("/atualizarFuncionario/{id}")
    public void atualizarFuncionario(@PathVariable int id, @RequestBody FuncionarioModels funcionarioModels) {
        funcionarioModels.setId(id);
        funcionarioFacade.atualizarFuncionario(funcionarioModels);
    }

    @DeleteMapping("/removerFuncionario/{id}")
    public void removerFuncionario(@PathVariable int id) {
        funcionarioFacade.removerFuncionario(id);
    }
}

