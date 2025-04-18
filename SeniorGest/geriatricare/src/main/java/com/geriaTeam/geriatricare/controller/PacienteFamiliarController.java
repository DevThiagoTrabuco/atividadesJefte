package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PacienteFamiliarFacade;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacienteFamiliar/")
public class PacienteFamiliarController {
    private final PacienteFamiliarFacade pacienteFamiliarFacade;

    @Autowired
    public PacienteFamiliarController(PacienteFamiliarFacade pacienteFamiliarFacade) {
        this.pacienteFamiliarFacade = pacienteFamiliarFacade;
    }

    @GetMapping("")
    public List<PacienteFamiliarModels> buscar(){
        return pacienteFamiliarFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public PacienteFamiliarModels buscarPorCodigo(@PathVariable int codigo){
        return pacienteFamiliarFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody PacienteFamiliarModels pacienteFamiliarModels){
        pacienteFamiliarFacade.adicionar(pacienteFamiliarModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody PacienteFamiliarModels pacienteFamiliarModels){
        pacienteFamiliarFacade.atualizar(pacienteFamiliarModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        pacienteFamiliarFacade.remover(codigo);
    }

}
