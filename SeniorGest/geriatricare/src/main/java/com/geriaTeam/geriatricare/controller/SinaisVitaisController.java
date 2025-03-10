package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.models.SinaisVitais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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