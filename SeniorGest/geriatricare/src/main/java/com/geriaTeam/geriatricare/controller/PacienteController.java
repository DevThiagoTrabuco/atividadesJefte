package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/paciente/")
@RestController
public class PacienteController {

    private final PacienteFacade pacienteFacade;

    @Autowired
    public PacienteController(PacienteFacade pacienteFacade) {
        this.pacienteFacade = pacienteFacade;
    }

    @GetMapping("")
    public List<Paciente> get(){
        return pacienteFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Paciente getPaciente(@PathVariable UUID codigo){
        return pacienteFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Paciente paciente){
        pacienteFacade.cadastrar(paciente);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Paciente paciente){
        pacienteFacade.atualizar(codigo, paciente);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Paciente paciente){
        pacienteFacade.remover(codigo, paciente);
    }
}