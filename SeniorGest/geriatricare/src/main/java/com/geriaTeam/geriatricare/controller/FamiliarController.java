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
    @PostMapping("/adicionar")
    public void adicionarFamiliar(@RequestParam String nome, @RequestParam String sobrenome, @RequestParam String cpf, @RequestParam String rg, @RequestParam String email, @RequestParam String telefone) {
        familiarFacade.adicionarFamiliar(nome, sobrenome, cpf, rg, email, telefone);
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
            @RequestParam String novoSobrenome,
            @RequestParam String novoEmail,
            @RequestParam String novoTelefone
    ) {
        familiarFacade.atualizarFamiliar(id, novoNome,novoSobrenome, novoEmail, novoTelefone);
    }

    @GetMapping("/todos")
    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarFacade.buscarTodosFamiliares();
    }
}
