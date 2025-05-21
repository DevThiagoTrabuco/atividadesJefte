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
    public void adicionarCondicaoFisica(@RequestParam String nome, @RequestParam String descricao) {
        condicaoFisicaFacade.adicionarCondicaoFisica(nome, descricao);
    }

    @DeleteMapping("/remover-condicao-fisica/{codigo}")
    public void removerCondicaoFisica(@PathVariable int codigo) {
        condicaoFisicaFacade.removerCondicaoFisica(codigo);
    }

    @GetMapping("/buscar-todas-condicao-fisica")
    public List<CondicaoFisicaModels> buscarTodasCondicoesFisicas() {
        return condicaoFisicaFacade.buscarCondicoesFisicas();
    }

        @PutMapping("/atualizar-condicao-fisica/{codigo}")
    public void atualizarCondicaoFisica(
            @PathVariable int codigo,
            @RequestParam String novoNome,
            @RequestParam String novaDescricao
    ) {
        condicaoFisicaFacade.atualizarCondicaoFisica(codigo, novoNome, novaDescricao);
    }
}
