package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.MedicamentoFacade;
import com.geriaTeam.geriatricare.models.domain.Medicamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/medicamentos/")
@RestController
public class MedicamentoController {
    private final MedicamentoFacade medicamentoFacade;

    @Autowired
    public MedicamentoController(MedicamentoFacade medicamentoFacade) {
        this.medicamentoFacade = medicamentoFacade;

    }

    @GetMapping("")
    public List<Medicamento> buscar(){
        return medicamentoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Medicamento buscarPorCodigo(@PathVariable int codigo){
        return medicamentoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Medicamento medicamento){
        medicamentoFacade.adicionar(medicamento);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Medicamento medicamento){
        medicamentoFacade.atualizar(medicamento);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        medicamentoFacade.remover(codigo);
    }


}
