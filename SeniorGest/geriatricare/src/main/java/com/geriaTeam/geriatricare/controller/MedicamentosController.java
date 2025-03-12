package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.Admin;
import com.geriaTeam.geriatricare.models.Funcionarios;
import com.geriaTeam.geriatricare.models.Medicamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/medicamentos/")
@RestController
public class MedicamentosController {

    private final MedicamentosFacade medicamentosFacade;

    @Autowired
    public MedicamentosController(MedicamentosFacade medicamentoFacade) {
        this.medicamentosFacade = medicamentosFacade;

    }

    @GetMapping("")
    public List<Admin> get(){
        return medicamentosFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Admin getLanche(@PathVariable UUID codigo){
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
