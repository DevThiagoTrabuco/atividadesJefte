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

import com.geriaTeam.geriatricare.facade.SinaisVitaisFacade;
import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

@RequestMapping("/sinaisvitais/")
@RestController
public class SinaisVitaisController {
    private final SinaisVitaisFacade sinaisvitaisFacade;

    @Autowired
    public SinaisVitaisController(SinaisVitaisFacade sinaisvitaisFacade) {
        this.sinaisvitaisFacade = sinaisvitaisFacade;

    }

    @GetMapping("")
    public List<SinaisVitais> buscar(){
        return sinaisvitaisFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public SinaisVitais buscarPorCodigo(@PathVariable int codigo){
        return sinaisvitaisFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody SinaisVitais sinaisvitais){
        sinaisvitaisFacade.adicionar(sinaisvitais);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody SinaisVitais sinaisvitais){
        sinaisvitaisFacade.atualizar(codigo, sinaisvitais);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        sinaisvitaisFacade.remover(codigo);
    }
}
