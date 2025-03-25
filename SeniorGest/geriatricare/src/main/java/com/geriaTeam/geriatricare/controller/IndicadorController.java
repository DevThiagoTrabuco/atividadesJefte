package com.geriaTeam.geriatricare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geriaTeam.geriatricare.facade.IndicadorFacade;
import com.geriaTeam.geriatricare.models.domain.Indicador;

@RequestMapping("/api/indicador/")
@RestController
public class IndicadorController {
    private final IndicadorFacade indicadorFacade;

    @Autowired
    public IndicadorController(IndicadorFacade indicadorFacade) {
        this.indicadorFacade = indicadorFacade;

    }

    @GetMapping("")
    public List<Indicador> buscar(){
        return indicadorFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Indicador buscarPorCodigo(@PathVariable int codigo){
        return indicadorFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Indicador indicador){
        indicadorFacade.adicionar(indicador);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Indicador indicador){
        indicadorFacade.atualizar(codigo, indicador);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        indicadorFacade.remover(codigo);
    }
}
