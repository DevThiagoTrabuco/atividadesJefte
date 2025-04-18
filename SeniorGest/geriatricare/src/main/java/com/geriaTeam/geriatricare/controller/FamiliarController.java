package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.FamiliarFacade;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familiar/")
public class FamiliarController {

    private final FamiliarFacade familiarFacade;

    @Autowired
    public FamiliarController(FamiliarFacade familiarFacade) {
        this.familiarFacade = familiarFacade;
    }

    // CRUD padrão
    @GetMapping("")
    public List<FamiliarModels> buscar() {
        return familiarFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public FamiliarModels buscarPorCodigo(@PathVariable int codigo) {
        return familiarFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody FamiliarModels familiarModels) {
        familiarFacade.adicionar(familiarModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody FamiliarModels familiarModels) {
        familiarFacade.atualizar(familiarModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        familiarFacade.remover(codigo);
    }

    // Funções adicionais
    @PostMapping("/adicionar")
    public void adicionarFamiliar(@RequestParam String nome, @RequestParam String email, @RequestParam String telefone) {
        familiarFacade.adicionarFamiliar(nome, email, telefone);
    }

    @DeleteMapping("/remover-familiar/{id}")
    public void removerFamiliar(@PathVariable int id) {
        familiarFacade.removerFamiliar(id);
    }

    @GetMapping("/buscar-familiar/{id}")
    public FamiliarModels buscarFamiliar(@PathVariable int id) {
        return familiarFacade.buscarFamiliar(id);
    }

    @PutMapping("/atualizar-familiar/{id}")
    public void atualizarFamiliar(
            @PathVariable int id,
            @RequestParam String novoNome,
            @RequestParam String novoEmail,
            @RequestParam String novoTelefone
    ) {
        familiarFacade.atualizarFamiliar(id, novoNome, novoEmail, novoTelefone);
    }

    @GetMapping("/todos")
    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarFacade.buscarTodosFamiliares();
    }
}
