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

import com.geriaTeam.geriatricare.facade.FamiliarFacade;
import com.geriaTeam.geriatricare.models.domain.Familiar;

@RequestMapping("/familiar/")
@RestController
public class FamiliarController {
    private final FamiliarFacade familiarFacade;

    @Autowired
    public FamiliarController(FamiliarFacade familiarFacade) {
        this.familiarFacade = familiarFacade;

    }

    @GetMapping("")
    public List<Familiar> get(){
        return familiarFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Familiar getLanche(@PathVariable UUID codigo){
        return familiarFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Familiar familiar){
        familiarFacade.cadastrar(familiar);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Familiar familiar){
        familiarFacade.atualizar(codigo, familiar);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Familiar familiar){
        familiarFacade.remover(codigo, familiar);
    }
}
