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

import com.geriaTeam.geriatricare.facade.FuncaoFacade;
import com.geriaTeam.geriatricare.models.domain.Funcao;

@RequestMapping("/api/funcao/")
@RestController
public class FuncaoController {
    private final FuncaoFacade funcaoFacade;

    @Autowired
    public FuncaoController(FuncaoFacade funcaoFacade) {
        this.funcaoFacade = funcaoFacade;

    }

    @GetMapping("")
    public List<Funcao> buscar(){
        return funcaoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Funcao buscarPorCodigo(@PathVariable int codigo){
        return funcaoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Funcao funcao){
        funcaoFacade.adicionar(funcao);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Funcao funcao){
        funcaoFacade.atualizar(funcao);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        funcaoFacade.remover(codigo);
    }
}
