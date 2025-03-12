package com.geriaTeam.geriatricare.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geriaTeam.geriatricare.facade.FuncionariosFacade;
import com.geriaTeam.geriatricare.models.domain.Funcionarios;

@RequestMapping("/funcionarios/")
@RestController
public class FuncionariosController {
    private final FuncionariosFacade funcionarioFacade;

    @Autowired
    public FuncionariosController(FuncionariosFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;

    }

    @GetMapping("")
    public List<Funcionarios> get(){
        return funcionarioFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Funcionarios getLanche(@PathVariable UUID codigo){
        return funcionarioFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Funcionarios funcionario){
        funcionarioFacade.cadastrar(funcionario);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Funcionarios funcionario){
        funcionarioFacade.atualizar(codigo, funcionario);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Funcionarios funcionario){
        funcionarioFacade.remover(codigo, funcionario);
    }
}
