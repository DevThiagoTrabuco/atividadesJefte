package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.MedicamentoFacade;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/medicamento/")
@RestController
public class MedicamentoController {
    private final MedicamentoFacade medicamentoFacade;

    @Autowired
    public MedicamentoController(MedicamentoFacade medicamentoFacade) {
        this.medicamentoFacade = medicamentoFacade;

    }

    @GetMapping("")
    public List<MedicamentoModels> buscar(){
        return medicamentoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public MedicamentoModels buscarPorCodigo(@PathVariable int codigo){
        return medicamentoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody MedicamentoModels medicamentoModels){
        medicamentoFacade.adicionar(medicamentoModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody MedicamentoModels medicamentoModels){
        medicamentoFacade.atualizar(medicamentoModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        medicamentoFacade.remover(codigo);
    }


}
