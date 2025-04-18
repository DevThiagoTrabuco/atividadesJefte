package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.CondicaoMentalFacade;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicaomental/")
public class CondicaoMentalController {

    private final CondicaoMentalFacade condicaoMentalFacade;

    @Autowired
    public CondicaoMentalController(CondicaoMentalFacade condicaoMentalFacade) {
        this.condicaoMentalFacade = condicaoMentalFacade;
    }

    // CRUD padrão
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

    // Métodos adicionais

    @PostMapping("/adicionar")
    public void adicionarCondicaoMental(@RequestParam String nome, @RequestParam String descricao) {
        condicaoMentalFacade.adicionarCondicaoMental(nome, descricao);
    }

    @DeleteMapping("/remover-condicao/{codigo}")
    public void removerCondicaoMental(@PathVariable int codigo) {
        condicaoMentalFacade.removerCondicaoMental(codigo);
    }

    @GetMapping("/todas")
    public List<CondicaoMentalModels> buscarTodasCondicoes() {
        return condicaoMentalFacade.buscarTodasCondicoes();
    }

    @PutMapping("/atualizar-condicao/{codigo}")
    public void atualizarCondicaoMental(
            @PathVariable int codigo,
            @RequestParam String nome,
            @RequestParam String descricao
    ) {
        condicaoMentalFacade.atualizarCondicaoMental(codigo, nome, descricao);
    }

    @GetMapping("/verificar/{codigo}")
    public boolean verificarCondicaoMental(@PathVariable int codigo) {
        return condicaoMentalFacade.verificarCondicaoMental(codigo);
    }
}
