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
    public void adicionarFuncionario(@RequestBody FuncionarioModels funcionarioModels, @RequestParam String adminLogin, @RequestParam String adminSenha) {
        funcionarioFacade.adicionarFuncionario(funcionarioModels, adminLogin, adminSenha);
    }

    @PutMapping("/atualizarFuncionario/{id}")
    public void atualizarFuncionario(@PathVariable int id, @RequestBody FuncionarioModels funcionarioModels, @RequestParam String adminLogin, @RequestParam String adminSenha) {
        funcionarioModels.setId(id);
        funcionarioFacade.atualizarFuncionario(funcionarioModels, adminLogin, adminSenha);
    }

    @DeleteMapping("/removerFuncionario/{id}")
    public void removerFuncionario(@PathVariable int id, @RequestParam String adminLogin, @RequestParam String adminSenha) {
        funcionarioFacade.removerFuncionario(id, adminLogin, adminSenha);
    }
}

