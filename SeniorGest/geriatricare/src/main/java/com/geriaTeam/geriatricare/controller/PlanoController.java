package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/plano/")
@RestController
public class PlanoController {

    private final PlanoFacade planoFacade;

    @Autowired
    public PlanoController(PlanoFacade planoFacade) {
        this.planoFacade = planoFacade;
    }

    @GetMapping("")
    public List<Plano> get(){
        return planoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Plano getPlano(@PathVariable UUID codigo){
        return planoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Plano plano){
        planoFacade.cadastrar(plano);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Plano plano){
        planoFacade.atualizar(codigo, plano);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Plano plano){
        planoFacade.remover(codigo, plano);
    }
}