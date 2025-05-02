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
    public void adicionarFamiliar(@RequestBody FamiliarModels familiarModels) {
        familiarFacade.adicionarFamiliar(familiarModels);
    }

    @DeleteMapping("/remover-familiar/{id}")
    public void removerFamiliar(@PathVariable int id) {
        familiarFacade.removerFamiliar(id);
    }

    @GetMapping("/buscar-familiar-id/{id}")
    public FamiliarModels buscarFamiliarId(@PathVariable int id) {
        return familiarFacade.buscarFamiliarId(id);
    }

    @GetMapping("/buscar-familiar-cpf/{cpf}")
    public FamiliarModels buscarFamiliarCpf(@PathVariable String Cpf) {
        return familiarFacade.buscarFamiliarCpf(Cpf);
    }

    @GetMapping("/buscar-familiar-nome/{nome}")
    public List<FamiliarModels> buscarFamiliarNome(@PathVariable String nome) {
        return familiarFacade.buscarPorNome(nome);
    }

    @PutMapping("/atualizar-familiar/{id}")
    public void atualizarFamiliar(@RequestBody FamiliarModels familiarModels) {
        familiarFacade.atualizarFamiliar(familiarModels);
    }

    @GetMapping("/todos")
    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarFacade.buscarTodosFamiliares();
    }
}
