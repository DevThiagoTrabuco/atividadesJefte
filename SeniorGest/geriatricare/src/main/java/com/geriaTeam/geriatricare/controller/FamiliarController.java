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

import com.geriaTeam.geriatricare.facade.FamiliarFacade;
import com.geriaTeam.geriatricare.models.FamiliarModels;

@RequestMapping("/api/familiar/")
@RestController
public class FamiliarController {
    private final FamiliarFacade familiarFacade;

    @Autowired
    public FamiliarController(FamiliarFacade familiarFacade) {
        this.familiarFacade = familiarFacade;

    }

    @GetMapping("")
    public List<FamiliarModels> buscar(){
        return familiarFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public FamiliarModels buscarPorCodigo(@PathVariable int codigo){
        return familiarFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody FamiliarModels familiarModels){
        familiarFacade.adicionar(familiarModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody FamiliarModels familiarModels){
        familiarFacade.atualizar(familiarModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        familiarFacade.remover(codigo);
    }
}
