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
    @GetMapping("")
    public List<CondicaoFisicaModels> buscar() {
        return condicaoFisicaFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public CondicaoFisicaModels buscarPorCodigo(@PathVariable int codigo) {
        return condicaoFisicaFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaFacade.adicionar(condicaoFisicaModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody CondicaoFisicaModels condicaoFisicaModels) {
        condicaoFisicaFacade.atualizar(condicaoFisicaModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        condicaoFisicaFacade.remover(codigo);
    }

    // Métodos adicionais para manipulação direta de condições físicas

    @PostMapping("/adicionar")
    public void adicionarCondicaoFisica(@RequestParam String nome, @RequestParam String descricao) {
        condicaoFisicaFacade.adicionarCondicaoFisica(nome, descricao);
    }

    @DeleteMapping("/remover-condicao/{codigo}")
    public void removerCondicaoFisica(@PathVariable int codigo) {
        condicaoFisicaFacade.removerCondicaoFisica(codigo);
    }

    @GetMapping("/todas")
    public List<CondicaoFisicaModels> buscarTodasCondicoesFisicas() {
        return condicaoFisicaFacade.buscarCondicoesFisicas();
    }

    @PutMapping("/atualizar-condicao/{codigo}")
    public void atualizarCondicaoFisica(
            @PathVariable int codigo,
            @RequestParam String novoNome,
            @RequestParam String novaDescricao
    ) {
        condicaoFisicaFacade.atualizarCondicaoFisica(codigo, novoNome, novaDescricao);
    }
}
