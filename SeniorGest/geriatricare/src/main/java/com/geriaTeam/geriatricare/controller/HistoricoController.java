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
import com.geriaTeam.geriatricare.models.domain.Historico;

@RequestMapping("/api/historico/")
@RestController
public class HistoricoController {
    private final HistoricoFacade historicoFacade;

    @Autowired
    public HistoricoController(HistoricoFacade historicoFacade) {
        this.historicoFacade = historicoFacade;

    }

    @GetMapping("")
    public List<Historico> buscar(){
        return historicoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Historico buscarPorCodigo(@PathVariable int codigo){
        return historicoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Historico historico){
        historicoFacade.adicionar(historico);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Historico historico){
        historicoFacade.atualizar(codigo, historico);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        historicoFacade.remover(codigo);
    }
}
