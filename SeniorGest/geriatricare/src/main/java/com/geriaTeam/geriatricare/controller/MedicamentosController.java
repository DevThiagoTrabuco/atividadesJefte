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

import com.geriaTeam.geriatricare.facade.MedicamentosFacade;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;

@RequestMapping("/medicamentos/")
@RestController
public class MedicamentosController {

    private final MedicamentosFacade medicamentosFacade;

    @Autowired
    public MedicamentosController(MedicamentosFacade medicamentoFacade) {
        this.medicamentosFacade = medicamentoFacade;
    }

    @GetMapping("")
    public List<Medicamentos> get(){
        return medicamentosFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Medicamentos getLanche(@PathVariable UUID codigo){
        return medicamentosFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Medicamentos medicamentos){
        medicamentosFacade.cadastrar(medicamentos);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Medicamentos medicamentos){
        medicamentosFacade.atualizar(codigo, medicamentos);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Medicamentos medicamentos){
        medicamentosFacade.remover(codigo, medicamentos);
    }
}
