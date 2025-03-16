package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.MedicamentosFacade;
import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/medicamentos/")
@RestController
public class MedicamentosController {
    private final MedicamentosFacade medicamentosFacade;

    @Autowired
    public MedicamentosController(MedicamentosFacade medicamentosFacade) {
        this.medicamentosFacade = medicamentosFacade;

    }

    @GetMapping("")
    public List<Admin> buscar(){return medicamentosFacade.buscar();}
    public List<Medicamentos> listar(){
        return medicamentosFacade.listar();
    }

    @GetMapping("/{codigo}")
    public Medicamentos listarPorCodigo(@PathVariable int codigo){
        return medicamentosFacade.listarPorCodigo(codigo);
    }

    @PostMapping("")
    public void registrar(@RequestBody Medicamentos medicamentos){
        medicamentosFacade.registrar(medicamentos);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Medicamentos medicamentos){
        medicamentosFacade.atualizar(codigo, medicamentos);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        medicamentosFacade.remover(codigo);
    }


}
