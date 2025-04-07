package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PlanosFacade;
import com.geriaTeam.geriatricare.models.domain.Plano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/planos/")
@RestController
public class PlanosController {
    private final PlanosFacade planosFacade;

    @Autowired
    public PlanosController(PlanosFacade planosFacade) {
        this.planosFacade = planosFacade;

    }

    @GetMapping("")
    public List<Plano> buscar() {return planosFacade.buscar();}

    @GetMapping("/{codigo}")
    public Plano buscarPorCodigo(@PathVariable int codigo) {return planosFacade.buscarPorCodigo(codigo);}

    @PostMapping("")
    public void adicionar(@RequestBody Plano plano) {planosFacade.adicionar(plano);}

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Plano plano) {planosFacade.atualizar(plano);}

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {planosFacade.remover(codigo);}


}