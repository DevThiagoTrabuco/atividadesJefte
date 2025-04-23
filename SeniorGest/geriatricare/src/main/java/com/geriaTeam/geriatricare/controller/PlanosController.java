package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PlanosFacade;
import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/plano/")
@RestController
public class PlanosController {
    private final PlanosFacade planosFacade;

    @Autowired
    public PlanosController(PlanosFacade planosFacade) {
        this.planosFacade = planosFacade;

    }

    @GetMapping("")
    public List<PlanoModels> buscar() {return planosFacade.buscar();}

    @GetMapping("/{codigo}")
    public PlanoModels buscarPorCodigo(@PathVariable int codigo) {return planosFacade.buscarPorCodigo(codigo);}

    @PostMapping("")
    public void adicionar(@RequestBody PlanoModels planoModels) {planosFacade.adicionar(planoModels);}

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody PlanoModels planoModels) {planosFacade.atualizar(planoModels);}

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {planosFacade.remover(codigo);}


}