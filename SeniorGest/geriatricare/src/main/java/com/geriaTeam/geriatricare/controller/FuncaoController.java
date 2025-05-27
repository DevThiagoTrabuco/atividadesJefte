package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.FuncaoFacade;
import com.geriaTeam.geriatricare.models.FuncaoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcao/")
public class FuncaoController {

    private final FuncaoFacade funcaoFacade;

    @Autowired
    public FuncaoController(FuncaoFacade funcaoFacade) {
        this.funcaoFacade = funcaoFacade;
    }

    // CRUD padrão
    @PostMapping("/adicionar-funcao")
    public void adicionarFuncao(@RequestBody FuncaoModels funcaoModels) {
        funcaoFacade.adicionarFuncao(funcaoModels);
    }

    @DeleteMapping("/remover-funcao/{id}")
    public void removerFuncao(@PathVariable int id) {
        funcaoFacade.removerFuncao(id);
    }

    @GetMapping("/buscar-funcao/{id}")
    public FuncaoModels buscarFuncao(@PathVariable int id) {
        return funcaoFacade.buscarFuncao(id);
    }

    @PutMapping("/atualizar-funcao/{id}")
    public void atualizarFuncao(@RequestBody FuncaoModels funcaoModels) {
        funcaoFacade.atualizarFuncao(funcaoModels);
    }

    @GetMapping("/buscar-todas-funcao")
    public List<FuncaoModels> buscarTodasFuncoes() {
        return funcaoFacade.buscarTodasFuncoes();
    }
}
