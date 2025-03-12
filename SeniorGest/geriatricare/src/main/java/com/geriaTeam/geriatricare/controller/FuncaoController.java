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

import com.geriaTeam.geriatricare.facade.FuncaoFacade;
import com.geriaTeam.geriatricare.models.domain.Funcao;

@RequestMapping("/funcao/")
@RestController
public class FuncaoController {
    private final FuncaoFacade funcaoFacade;

    @Autowired
    public FuncaoController(FuncaoFacade funcaoFacade) {
        this.funcaoFacade = funcaoFacade;

    }

    @GetMapping("")
    public List<Funcao> get(){
        return funcaoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Funcao getLanche(@PathVariable UUID codigo){
        return funcaoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Funcao funcao){
        funcaoFacade.cadastrar(funcao);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Funcao funcao){
        funcaoFacade.atualizar(codigo, funcao);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Funcao funcao){
        funcaoFacade.remover(codigo, funcao);
    }
}
