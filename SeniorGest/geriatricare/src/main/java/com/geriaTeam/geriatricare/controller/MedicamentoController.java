package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.MedicamentoFacade;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicamento")
@RestController
public class MedicamentoController {
    @Autowired
    private MedicamentoFacade medicamentoFacade;

    @GetMapping
    public List<MedicamentoModels> buscarTodosMedicamento(){
        return medicamentoFacade.buscarTodosMedicamento();
    }

    @GetMapping("/buscarMedicamentoId/{id}")
    public MedicamentoModels buscarMedicamentoId(@PathVariable int id){
        return medicamentoFacade.buscarMedicamentoId(id);
    }

    @PostMapping("/adicionarMedicamento")
    public void adicionarMedicamento(@RequestBody MedicamentoModels medicamentoModels){
        medicamentoFacade.adicionarMedicamento(medicamentoModels);
    }

    @PutMapping("/atualizarMedicamento/{id}")
    public void atualizar(@PathVariable int id, @RequestBody MedicamentoModels medicamentoModels){
        medicamentoFacade.atualizarMedicamento(medicamentoModels);
    }

    @DeleteMapping("/removerMedicamento/{id}")
    public void remover(@PathVariable int id){
        medicamentoFacade.removerMedicamento(id);
    }


}
