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

import com.geriaTeam.geriatricare.facade.HistoricoFacade;
import com.geriaTeam.geriatricare.models.HistoricoModels;

@RequestMapping("/historico")
@RestController
public class HistoricoController {
    @Autowired
    private HistoricoFacade historicoFacade;

    @GetMapping
    public List<HistoricoModels> buscarHistorico(){
        return historicoFacade.buscarHistorico();
    }

    @GetMapping("/buscarHistoricoId/{id}")
    public HistoricoModels buscarHistoricoId(@PathVariable int id){
        return historicoFacade.buscarHistoricoId(id);
    }

    @PostMapping("/adicionarHistorico")
    public void adicionarHistorico(@RequestBody HistoricoModels historicoModels){
        historicoFacade.adicionarHistorico(historicoModels);
    }

    @PutMapping("/atualizarHistorico/{id}")
    public void atualizarHistorico(@PathVariable int id, @RequestBody HistoricoModels historicoModels){
        historicoFacade.atualizarHistorico(historicoModels);
    }

    @DeleteMapping("/removerHistorico/{id}")
    public void removerHistorico(@PathVariable int id){
        historicoFacade.removerHistorico(id);
    }
}
