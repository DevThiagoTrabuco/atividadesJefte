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
import com.geriaTeam.geriatricare.models.domain.Paciente;

@RequestMapping("/api/paciente/")
@RestController
public class PacienteController {
    private final PacienteFacade pacienteFacade;

    @Autowired
    public PacienteController(PacienteFacade pacienteFacade) {
        this.pacienteFacade = pacienteFacade;

    }

    @GetMapping("")
    public List<Paciente> buscar(){
        return pacienteFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Paciente buscarPorCodigo(@PathVariable int codigo){
        return pacienteFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Paciente paciente){
        pacienteFacade.adicionar(paciente);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Paciente paciente){
        pacienteFacade.atualizar(paciente);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        pacienteFacade.remover(codigo);
    }
}
