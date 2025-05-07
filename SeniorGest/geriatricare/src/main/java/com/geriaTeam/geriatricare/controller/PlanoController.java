package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PlanoFacade;
import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/plano/")
@RestController
public class PlanoController {
    private final PlanoFacade planoFacade;

    @Autowired
    public PlanoController(PlanoFacade planoFacade) {
        this.planoFacade = planoFacade;

    }

    @GetMapping("/todos-plano")
    public List<PlanoModels> buscar() {return planoFacade.buscar();}

    @GetMapping("buscar-plano-id/{codigo}")
    public PlanoModels buscarPlanoId(@PathVariable int codigo) {return planoFacade.buscarPlanoId(codigo);}

    @GetMapping("/buscar-plano-nome/{nome}")
    public List <PlanoModels> buscarPlanoNome(String nome){
        return planoFacade.buscarPlanoNome(nome);
    }

    @PostMapping("/adicionar-plano")
    public void adicionar(@RequestBody PlanoModels planoModels) {
        planoFacade.adicionar(planoModels);}

    @PutMapping("/atualizar-plano/{codigo}")
    public void atualizar(@RequestBody PlanoModels planoModels) {
        planoFacade.atualizar(planoModels);}

    @DeleteMapping("/remover-plano/{codigo}")
    public void remover(@PathVariable int codigo) {
        planoFacade.remover(codigo);}


}