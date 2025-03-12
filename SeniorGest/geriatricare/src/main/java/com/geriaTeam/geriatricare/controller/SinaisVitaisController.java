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

import com.geriaTeam.geriatricare.facade.SinaisVitaisFacade;
import com.geriaTeam.geriatricare.models.domain.SinaisVitais;

@RequestMapping("/sinaisVitais/")
@RestController
public class SinaisVitaisController {

    private final SinaisVitaisFacade sinaisVitaisFacade;

    @Autowired
    public SinaisVitaisController(SinaisVitaisFacade sinaisVitaisFacade) {
        this.sinaisVitaisFacade = sinaisVitaisFacade;
    }

    @GetMapping("")
    public List<SinaisVitais> get(){
        return sinaisVitaisFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public SinaisVitais getSinaisVitais(@PathVariable UUID codigo){
        return sinaisVitaisFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody SinaisVitais sinaisVitais){
        sinaisVitaisFacade.cadastrar(sinaisVitais);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody SinaisVitais sinaisVitais){
        sinaisVitaisFacade.atualizar(codigo, sinaisVitais);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody SinaisVitais sinaisVitais){
        sinaisVitaisFacade.remover(codigo, sinaisVitais);
    }
}