package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.Admin;
import com.geriaTeam.geriatricare.models.Familiar;
import com.geriaTeam.geriatricare.models.Funcao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/funcao/")
@RestController
public class FuncaoController {
    private final FuncaoFacade funcaoFacade;

    @Autowired
    public FuncaoController(FuncaoFacade funcaoFacade) {
        this.funcaoFacade = funcaoFacade;

    }

    @GetMapping("")
    public List<Admin> get(){
        return funcaoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Admin getLanche(@PathVariable UUID codigo){
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
