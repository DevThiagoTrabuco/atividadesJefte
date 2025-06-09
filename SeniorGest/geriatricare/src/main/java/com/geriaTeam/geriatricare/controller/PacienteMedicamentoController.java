package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PacienteMedicamentoFacade;
import com.geriaTeam.geriatricare.models.domain.PacienteMedicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacienteMedicamento/")
public class PacienteMedicamentoController {
    private final PacienteMedicamentoFacade pacienteMedicamentoFacade;

    @Autowired
    public PacienteMedicamentoController(PacienteMedicamentoFacade pacienteMedicamentoFacade) {
        this.pacienteMedicamentoFacade = pacienteMedicamentoFacade;

    }

    @GetMapping("")
    public List<PacienteMedicamento> buscar(){
        return pacienteMedicamentoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public PacienteMedicamento buscarPorCodigo(@PathVariable int codigo){
        return pacienteMedicamentoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody PacienteMedicamento pacienteMedicamento){
        pacienteMedicamentoFacade.adicionar(pacienteMedicamento);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody PacienteMedicamento pacienteMedicamento){
        pacienteMedicamentoFacade.atualizar(pacienteMedicamento);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        pacienteMedicamentoFacade.remover(codigo);
    }
    
}
