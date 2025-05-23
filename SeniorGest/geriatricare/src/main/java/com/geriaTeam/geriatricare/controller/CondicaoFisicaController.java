package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.CondicaoFisicaFacade;
import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/condicao-fisica/")
@RestController
public class CondicaoFisicaController {

    private final CondicaoFisicaFacade condicaoFisicaFacade;

    @Autowired
    public CondicaoFisicaController(CondicaoFisicaFacade condicaoFisicaFacade) {
        this.condicaoFisicaFacade = condicaoFisicaFacade;
    }

    // CRUD padrão
    @PostMapping("/adicionar-condicao-fisica")
    public void adicionarCondicaoFisica(@RequestBody CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaFacade.adicionarCondicaoFisica(condicaoFisicaModels);
    }

    @DeleteMapping("/remover-condicao-fisica/{codigo}")
    public void removerCondicaoFisica(@PathVariable int codigo) {
        condicaoFisicaFacade.removerCondicaoFisica(codigo);
    }

    @GetMapping("/buscar-todas-condicao-fisica")
    public List<CondicaoFisicaModels> buscarTodasCondicoesFisicas() {
        return condicaoFisicaFacade.buscarCondicoesFisicas();
    }

    @GetMapping("/buscar-condicao-fisica-id/{codigo}")
    public CondicaoFisicaModels buscarCondicaoFisicaPorCodigo(@PathVariable int codigo) {
        return condicaoFisicaFacade.buscarCondicaoFisicaPorCodigo(codigo);
    }

    @GetMapping("/buscar-condicao-fisica-nome/{nome}")
    public List<CondicaoFisicaModels> buscarCondicaoFisicaPorNome(@PathVariable String nome) {
        return condicaoFisicaFacade.buscarCondicaoFisicaPorNome(nome);
    }

        @PutMapping("/atualizar-condicao-fisica/{codigo}")
    public void atualizarCondicaoFisica( @PathVariable int codigo, @RequestBody CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaFacade.atualizarCondicaoFisica(codigo, condicaoFisicaModels);
    }
}
