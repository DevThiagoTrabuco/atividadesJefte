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

import com.geriaTeam.geriatricare.facade.PacienteFacade;
import com.geriaTeam.geriatricare.models.PacienteModels;

@RequestMapping("/api/paciente/")
@RestController
public class PacienteController {
    private final PacienteFacade pacienteFacade;

    @Autowired
    public PacienteController(PacienteFacade pacienteFacade) {
        this.pacienteFacade = pacienteFacade;

    }

    @GetMapping("")
    public List<PacienteModels> buscar(){
        return pacienteFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public PacienteModels buscarPorCodigo(@PathVariable int codigo){
        return pacienteFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody PacienteModels pacienteModels){
        pacienteFacade.adicionar(pacienteModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody PacienteModels pacienteModels){
        pacienteFacade.atualizar(pacienteModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        pacienteFacade.remover(codigo);
    }
}
