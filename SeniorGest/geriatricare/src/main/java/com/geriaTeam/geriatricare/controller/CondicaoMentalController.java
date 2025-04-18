package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.CondicaoMentalFacade;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/condicaomental/")
@RestController
public class CondicaoMentalController {

    private final CondicaoMentalFacade condicaoMentalFacade;

    @Autowired
    public CondicaoMentalController(CondicaoMentalFacade condicaoMentalFacade) {
        this.condicaoMentalFacade = condicaoMentalFacade;
    }

    @GetMapping("")
    public List<CondicaoMentalModels> buscar() {
        return condicaoMentalFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public CondicaoMentalModels buscarPorCodigo(@PathVariable int codigo) {
        return condicaoMentalFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody CondicaoMentalModels condicaoMentalModels) {
        condicaoMentalFacade.adicionar(condicaoMentalModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody CondicaoMentalModels condicaoMentalModels) {
        condicaoMentalFacade.atualizar(condicaoMentalModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        condicaoMentalFacade.remover(codigo);
    }
}
