package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.Admin;
import com.geriaTeam.geriatricare.models.Funcao;
import com.geriaTeam.geriatricare.models.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/funcionarios/")
@RestController
public class FuncionariosController {
    private final FuncionariosFacade funcionarioFacade;

    @Autowired
    public FuncionariosController(FuncionariosFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;

    }

    @GetMapping("")
    public List<Admin> get(){
        return funcionarioFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Admin getLanche(@PathVariable UUID codigo){
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
