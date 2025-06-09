package com.geriaTeam.geriatricare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geriaTeam.geriatricare.facade.FuncionarioFacade;
import com.geriaTeam.geriatricare.models.domain.Funcionario;

@RequestMapping("/api/funcionario/")
@RestController
public class FuncionarioController {
    private final FuncionarioFacade funcionarioFacade;

    @Autowired
    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;

    }

    @GetMapping("")
    public List<Funcionario> buscar(){
        return funcionarioFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Funcionario buscarPorCodigo(@PathVariable int codigo){
        return funcionarioFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Funcionario funcionario){
        funcionarioFacade.adicionar(funcionario);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Funcionario funcionario){
        funcionarioFacade.atualizar(funcionario);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        funcionarioFacade.remover(codigo);
    }
}

