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
import com.geriaTeam.geriatricare.models.IndicadorModels;

@RequestMapping("/indicador")
@RestController
public class IndicadorController {
    @Autowired
    private IndicadorFacade indicadorFacade;

    @GetMapping()
    public List<IndicadorModels> buscarTodosIndicador(){
        return indicadorFacade.buscarTodosIndicador();
    }

    @GetMapping("/buscarIndicadorId/{id}")
    public IndicadorModels buscarIndicadorId(@PathVariable int id){
        return indicadorFacade.buscarIndicadorId(id);
    }

    @PostMapping("/adicionarIndicador")
    public void adicionar(@RequestBody IndicadorModels indicadorModels){
        indicadorFacade.adicionarIndicador(indicadorModels);
    }

    @PutMapping("/atualizarIndicador/{id}")
    public void atualizar(@PathVariable int id, @RequestBody IndicadorModels indicadorModels){
        indicadorFacade.atualizarIndicador(indicadorModels);
    }

    @DeleteMapping("/removerIndicador/{id}")
    public void remover(@PathVariable int id){
        indicadorFacade.removerIndicador(id);
    }
}
