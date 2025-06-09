package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PacienteFamiliarFacade;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente-familiar/")
public class PacienteFamiliarController {

    private final PacienteFamiliarFacade pacienteFamiliarFacade;

    @Autowired
    public PacienteFamiliarController(PacienteFamiliarFacade pacienteFamiliarFacade) {
        this.pacienteFamiliarFacade = pacienteFamiliarFacade;
    }
    
    @GetMapping("/buscar-todos")
    public List<PacienteFamiliarModels> buscarTodosFamiliar() {
        return pacienteFamiliarFacade.buscarTodosPacienteFamiliar();
    }

    @PostMapping("/adicionar-paciente-familiar")
    public void adicionarPacienteFamiliar(@RequestBody PacienteFamiliarModels pacienteFamiliarModels) {
        pacienteFamiliarFacade.adicionarPacienteFamiliar(pacienteFamiliarModels);
    }

    @PostMapping("/adicionar-familiar/{pacienteId}/{familiarId}")
    public void adicionarFamiliar(@PathVariable int pacienteId, @PathVariable int familiarId) {
        pacienteFamiliarFacade.adicionarFamiliar(pacienteId, familiarId);
    }

    @DeleteMapping("/remover-familiar/{pacienteId}/{familiarId}")
    public void removerFamiliar(@PathVariable int pacienteId, @PathVariable int familiarId) {
        pacienteFamiliarFacade.removerFamiliar(pacienteId, familiarId);
    }

    @DeleteMapping("/remover-paciente-familiar/{id}")
    public void removerPacienteFamiliar(@PathVariable int id){
        pacienteFamiliarFacade.removerPacienteFamiliar(id);
    }

    @GetMapping("/buscar-relacionamento/{pacienteId}/{familiarId}")
    public PacienteFamiliarModels buscarRelacionamento(
            @PathVariable("pacienteId") int pacienteId,
            @PathVariable("familiarId") int familiarId) {
        return pacienteFamiliarFacade.buscarRelacionamento(pacienteId, familiarId);
    }

    @PutMapping("/atualizar-familiar/{pacienteId}/{familiarId}/{novoFamiliarId}")
    public void atualizarFamiliar(
            @PathVariable int pacienteId,
            @PathVariable int familiarId,
            @PathVariable int novoFamiliarId
    ) {
        pacienteFamiliarFacade.atualizarFamiliar(pacienteId, familiarId, novoFamiliarId);
    }

    @GetMapping("/verificar-familiar/{pacienteId}/{familiarId}")
    public boolean verificarFamiliar(@PathVariable int pacienteId, @PathVariable int familiarId) {
        return pacienteFamiliarFacade.verificarFamiliar(pacienteId, familiarId);
    }
}
